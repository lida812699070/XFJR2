package tomcat360.com.hyxfjr.v.view_impl.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import android.widget.Toast;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import tomcat360.com.hyxfjr.R;
import tomcat360.com.hyxfjr.mvp_m.ParamNameConstant;
import tomcat360.com.hyxfjr.v.APP;
import tomcat360.com.hyxfjr.view.gesture.LockPatternUtils;
import tomcat360.com.hyxfjr.view.gesture.LockPatternView;
import util.SPUtils;
import util.StrUtils;


public class UnlockGesturePasswordActivity extends Activity {

    @Bind(R.id.gesturepwd_unlock_text)
    TextView mHeadTextView;
    @Bind(R.id.gesturepwd_unlock_lockview)
    LockPatternView mLockPatternView;
    @Bind(R.id.gesturepwd_unlock_forget)
    TextView forgetPwd;
    @Bind(R.id.userid)
    TextView mUserId;

    private int mFailedPatternAttemptsSinceLastTimeout = 0;
    private CountDownTimer mCountdownTimer = null;
    private Animation mShakeAnim;
    private Toast mToast;

    private void showToast(CharSequence message) {
        if (null == mToast) {
            mToast = Toast.makeText(this, message, Toast.LENGTH_SHORT);
        } else {
            mToast.setText(message);
        }
        mToast.show();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.gesturepassword_unlock);
        ButterKnife.bind(this);
        super.onCreate(savedInstanceState);
        mLockPatternView.setOnPatternListener(mChooseNewLockPatternListener);
        mLockPatternView.setTactileFeedbackEnabled(true);
        mShakeAnim = AnimationUtils.loadAnimation(this, R.anim.shake_x);
        forgetPwd.setOnClickListener(forgetpwd);
        try {
            String userName = URLDecoder.decode((String) SPUtils.get(this, ParamNameConstant.LOGIN_NAME, ""), "utf-8");
            if (StrUtils.isPhoneNumber(userName)) {
                mUserId.setText(StrUtils.hidePhoneNumber(userName));
            } else {
                mUserId.setText(userName);
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    private View.OnClickListener forgetpwd = new View.OnClickListener() {

        @Override
        public void onClick(View arg0) {
            loginout();
        }
    };

    private void loginout() {
        //跳转到登录
        Intent intent = new Intent(UnlockGesturePasswordActivity.this, LoginActivity.class);
        startActivity(intent);
        APP.getInstance().logout();
        mLockPatternView.clearPattern();
        finish();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mCountdownTimer != null)
            mCountdownTimer.cancel();
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
            if (APP.getInstance().getLockPatternUtils().checkPattern(pattern)) {
                mLockPatternView
                        .setDisplayMode(LockPatternView.DisplayMode.Correct);
                showToast("解锁成功");
                finish();
            } else {
                mLockPatternView
                        .setDisplayMode(LockPatternView.DisplayMode.Wrong);
                if (pattern.size() >= LockPatternUtils.MIN_PATTERN_REGISTER_FAIL) {
                    mFailedPatternAttemptsSinceLastTimeout++;
                    int retry = LockPatternUtils.FAILED_ATTEMPTS_BEFORE_TIMEOUT_UNLOCK
                            - mFailedPatternAttemptsSinceLastTimeout;
                    if (retry > 0) {
                        mHeadTextView.setText("密码错误，还可以再输入" + retry + "次");
                        mHeadTextView.setTextColor(Color.RED);
                        mHeadTextView.startAnimation(mShakeAnim);
                    } else {
                        loginout();
                        return;
                    }

                } else {
                    showToast("输入长度不够，请重试");
                }

                if (mFailedPatternAttemptsSinceLastTimeout >= LockPatternUtils.FAILED_ATTEMPTS_BEFORE_TIMEOUT) {
                    // 去除手势密码
                    SPUtils.put(UnlockGesturePasswordActivity.this, ParamNameConstant.GUEST_STATUS, false);
                    // 进入登录页面
                    Intent intent = new Intent(UnlockGesturePasswordActivity.this, LoginActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    mLockPatternView.postDelayed(mClearPatternRunnable, 2000);
                }
            }
        }

        public void onPatternCellAdded(List<LockPatternView.Cell> pattern) {

        }

        private void patternInProgress() {
        }
    };

    Runnable attemptLockout = new Runnable() {

        @Override
        public void run() {
            mLockPatternView.clearPattern();
            mLockPatternView.setEnabled(false);
            mCountdownTimer = new CountDownTimer(
                    LockPatternUtils.FAILED_ATTEMPT_TIMEOUT_MS + 1, 1000) {

                @Override
                public void onTick(long millisUntilFinished) {
                    int secondsRemaining = (int) (millisUntilFinished / 1000) - 1;
                    if (secondsRemaining > 0) {
                        mHeadTextView.setText(secondsRemaining + " 秒后重试");
                    } else {
                        mHeadTextView.setText("请绘制手势密码");
                        mHeadTextView.setTextColor(Color.WHITE);
                    }

                }

                @Override
                public void onFinish() {
                    mLockPatternView.setEnabled(true);
                    mFailedPatternAttemptsSinceLastTimeout = 0;
                }
            }.start();
        }
    };

    @Override
    public void onBackPressed() {

    }
}
