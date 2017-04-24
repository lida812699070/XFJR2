package tomcat360.com.hyxfjr.v.view_impl.activity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import tomcat360.com.hyxfjr.R;
import tomcat360.com.hyxfjr.mvp_m.ParamNameConstant;
import tomcat360.com.hyxfjr.v.APP;
import tomcat360.com.hyxfjr.view.gesture.LockPatternUtils;
import tomcat360.com.hyxfjr.view.gesture.LockPatternView;
import tomcat360.com.hyxfjr.view.mydialog.DialogManager;
import util.SPUtils;


public class CreateGesturePasswordActivity extends BaseActivity {

    @Bind(R.id.gesturepwd_create_lockview)
    LockPatternView mLockPatternView;
    @Bind(R.id.gesturepwd_create_text)
    TextView mHeaderText;

    private static final int ID_EMPTY_MESSAGE = -1;
    private static final String KEY_UI_STAGE = "uiStage";
    private static final String KEY_PATTERN_CHOICE = "chosenPattern";

    protected List<LockPatternView.Cell> mChosenPattern = null;
    private Toast mToast;
    private Stage mUiStage = Stage.Introduction;

    private int mFailedPatternAttemptsSinceLastTimeout = 0;
    private Animation mShakeAnim;
    /**
     * The patten used during the help screen to show how to draw a pattern.
     */
    private final List<LockPatternView.Cell> mAnimatePattern = new ArrayList<LockPatternView.Cell>();


    /**
     * Keep track internally of where the user is in choosing a pattern.
     */
    protected enum Stage {

        Introduction(R.string.lockpattern_recording_intro_header,
                ID_EMPTY_MESSAGE, true), HelpScreen(
                R.string.lockpattern_settings_help_how_to_record
                , ID_EMPTY_MESSAGE,
                false), ChoiceTooShort(
                R.string.lockpattern_recording_incorrect_too_short,
                ID_EMPTY_MESSAGE, true), FirstChoiceValid(
                R.string.lockpattern_pattern_entered_header,
                ID_EMPTY_MESSAGE, false), NeedToConfirm(
                R.string.lockpattern_need_to_confirm,
                ID_EMPTY_MESSAGE, true), ConfirmWrong(
                R.string.lockpattern_need_to_unlock_wrong,
                ID_EMPTY_MESSAGE, true), ChoiceConfirmed(
                R.string.lockpattern_pattern_confirmed_header,
                ID_EMPTY_MESSAGE, false);

        /**
         * @param headerMessage  The message displayed at the top.
         * @param footerMessage  The footer message.
         * @param patternEnabled Whether the pattern widget is enabled.
         */
        Stage(int headerMessage, int footerMessage,
              boolean patternEnabled) {
            this.headerMessage = headerMessage;
            this.footerMessage = footerMessage;
            this.patternEnabled = patternEnabled;
        }

        final int headerMessage;
        final int footerMessage;
        final boolean patternEnabled;
    }

    private void showToast(CharSequence message) {
        if (null == mToast) {
            mToast = Toast.makeText(this, message, Toast.LENGTH_SHORT);
        } else {
            mToast.setText(message);
        }

        mToast.show();
    }

    @Override
    public int getLayoutId() {
        return R.layout.gesturepassword_create;
    }

    @Override
    public void initData() {

    }

    @Override
    public void initView() {
        mLockPatternView.setOnPatternListener(mChooseNewLockPatternListener);
        mLockPatternView.setTactileFeedbackEnabled(true);
        mShakeAnim = AnimationUtils.loadAnimation(this, R.anim.shake_x);
        updateStage(Stage.Introduction);
        mHeaderText.setText(R.string.gesture_password_guide_text);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        // restore from previous state
        final String patternString = savedInstanceState
                .getString(KEY_PATTERN_CHOICE);
        if (patternString != null) {
            mChosenPattern = LockPatternUtils
                    .stringToPattern(patternString);
        }
        updateStage(Stage.values()[savedInstanceState.getInt(KEY_UI_STAGE)]);
    }

    @Override
    public void initTitle() {
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(KEY_UI_STAGE, mUiStage.ordinal());
        if (mChosenPattern != null) {
            outState.putString(KEY_PATTERN_CHOICE,
                    LockPatternUtils.patternToString(mChosenPattern));
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            finish();
            return true;
        }
        return false;
    }

    private Runnable mClearPatternRunnable = new Runnable() {
        public void run() {
            mLockPatternView.clearPattern();
        }
    };

    protected LockPatternView.OnPatternListener mChooseNewLockPatternListener = new LockPatternView.OnPatternListener() {

        public void onPatternStart() {
            mLockPatternView.removeCallbacks(mClearPatternRunnable);
            patternInProgress();
        }

        public void onPatternCleared() {
            mLockPatternView.removeCallbacks(mClearPatternRunnable);
        }

        public void onPatternDetected(List<LockPatternView.Cell> pattern) {
            if (pattern == null)
                return;
            if (mUiStage == Stage.NeedToConfirm
                    || mUiStage == Stage.ConfirmWrong) {
                if (mChosenPattern == null)
                    throw new IllegalStateException(
                            "null chosen pattern in stage 'need to confirm");
                if (mChosenPattern.equals(pattern)) {
                    updateStage(Stage.ChoiceConfirmed);
                } else {
                    updateStage(Stage.ConfirmWrong);
                }
            } else if (mUiStage == Stage.Introduction
                    || mUiStage == Stage.ChoiceTooShort) {
                if (pattern.size() < LockPatternUtils.MIN_LOCK_PATTERN_SIZE) {
                    updateStage(Stage.ChoiceTooShort);
                } else {
                    mChosenPattern = new ArrayList<LockPatternView.Cell>(
                            pattern);
                    updateStage(Stage.FirstChoiceValid);
                }
            } else {
                throw new IllegalStateException("Unexpected stage " + mUiStage
                        + " when " + "entering the pattern.");
            }
        }

        public void onPatternCellAdded(List<LockPatternView.Cell> pattern) {

        }

        private void patternInProgress() {
            mHeaderText.setText(R.string.lockpattern_recording_inprogress);
        }
    };

    private void updateStage(Stage stage) {
        mUiStage = stage;
        if (stage == Stage.ChoiceTooShort) {
            mHeaderText.setText(getResources().getString(stage.headerMessage,
                    LockPatternUtils.MIN_LOCK_PATTERN_SIZE));
        } else {
            mHeaderText.setText(stage.headerMessage);
        }

        // same for whether the patten is enabled
        if (stage.patternEnabled) {
            mLockPatternView.enableInput();
        } else {
            mLockPatternView.disableInput();
        }

        mLockPatternView.setDisplayMode(LockPatternView.DisplayMode.Correct);

        switch (mUiStage) {
            case Introduction:
                mLockPatternView.clearPattern();
                break;
            case HelpScreen:
                mLockPatternView.setPattern(LockPatternView.DisplayMode.Animate, mAnimatePattern);
                break;
            case ChoiceTooShort:
                mLockPatternView.setDisplayMode(LockPatternView.DisplayMode.Wrong);
                postClearPatternRunnable();
                break;
            case FirstChoiceValid:
                updateStage(Stage.NeedToConfirm);
                break;
            case NeedToConfirm:
                mLockPatternView.clearPattern();
                break;
            case ConfirmWrong:
                mLockPatternView.setDisplayMode(LockPatternView.DisplayMode.Wrong);
                postClearPatternRunnable();
                break;
            case ChoiceConfirmed:
                saveChosenPatternAndFinish();
                break;
        }

    }

    // clear the wrong pattern unless they have started a new one
    // already
    private void postClearPatternRunnable() {
        mLockPatternView.removeCallbacks(mClearPatternRunnable);
        mLockPatternView.postDelayed(mClearPatternRunnable, 2000);
    }

    private void saveChosenPatternAndFinish() {
        APP.getInstance().getLockPatternUtils().saveLockPattern(mChosenPattern);
        DialogManager.showAlertDialog(CreateGesturePasswordActivity.this, "手势密码设置成功");
        SPUtils.put(this, ParamNameConstant.GUEST_STATUS, true);
        finish();
    }

}
