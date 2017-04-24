package tomcat360.com.hyxfjr.v.view_impl.activity;

import android.content.Intent;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Switch;

import butterknife.Bind;
import butterknife.OnClick;
import tomcat360.com.hyxfjr.R;
import tomcat360.com.hyxfjr.v.APP;
import tomcat360.com.hyxfjr.view.MyToolbar;

public class GesturePasswordSettingActivity extends BaseActivity implements CompoundButton.OnCheckedChangeListener {

    @Bind(R.id.base_toolbar)
    MyToolbar baseToolbar;
    @Bind(R.id.switch_gesture)
    Switch switchGesture;
    @Bind(R.id.iv_right)
    ImageView ivRight;
    @Bind(R.id.ll_reset_gesture_password)
    LinearLayout llResetGesturePassword;

    @Override
    public int getLayoutId() {
        return R.layout.activity_gesture_password_setting;
    }

    @Override
    public void initData() {

    }

    @OnClick({R.id.iv_right, R.id.ll_reset_gesture_password})
    public void OnClick(View view) {
        switch (view.getId()) {
            case R.id.iv_right://修改手势密码
                Intent intent = new Intent(this, CreateGesturePasswordActivity.class);
                startActivity(intent);
                break;
        }
    }

    @Override
    public void initView() {
        initToolbar("手势密码");
        switchGesture.setOnCheckedChangeListener(this);
    }

    @Override
    public void initTitle() {

    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean checked) {
        if (checked) {//如果switch被打开
            //没有手势密码
            if (!APP.getInstance().getLockPatternUtils().savedPatternExists()) {
                Intent intent = new Intent(this, ModifyGesturePasswordActivity.class);
                startActivity(intent);
            }
        } else {
            APP.getInstance().getLockPatternUtils().clearLock();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (APP.getInstance().getLockPatternUtils().savedPatternExists()) {
            switchGesture.setChecked(true);
            llResetGesturePassword.setVisibility(View.VISIBLE);
        } else {
            switchGesture.setChecked(false);
            llResetGesturePassword.setVisibility(View.GONE);
        }
    }
}
