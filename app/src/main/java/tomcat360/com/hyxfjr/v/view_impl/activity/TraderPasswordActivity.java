package tomcat360.com.hyxfjr.v.view_impl.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import tomcat360.com.hyxfjr.R;
import tomcat360.com.hyxfjr.view.MyToolbar;
import tomcat360.com.hyxfjr.view.PasswordInputView;
import util.ButtonClickUtil;

public class TraderPasswordActivity extends BaseActivity {

    @Bind(R.id.base_toolbar)
    MyToolbar baseToolbar;
    @Bind(R.id.et_input_password)
    PasswordInputView etInputPassword;
    @Bind(R.id.et_input_password_again)
    PasswordInputView etInputPasswordAgain;
    @Bind(R.id.btn_promotion_quota)
    Button btnPromotionQuota;
    @Bind(R.id.btn_submit)
    Button btnSubmit;
    @Bind(R.id.ll_bottom)
    LinearLayout llBottom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trader_password);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btn_promotion_quota, R.id.btn_submit})
    public void onCliclk(View view) {
        if (ButtonClickUtil.isFastDoubleClick()) return;
        switch (view.getId()) {
            case R.id.btn_promotion_quota: //提额神器
                break;
            case R.id.btn_submit: //提交
                submitPassword();
                break;
        }
    }

    private void submitPassword() {
        String password = etInputPassword.getText().toString();
        String passwordAgain = etInputPasswordAgain.getText().toString();
        if (!password.equals(passwordAgain)) {
            Toast.makeText(this, "两次输入的密码不一致", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_trader_password;
    }

    @Override
    public void initData() {

    }

    @Override
    public void initView() {

    }

    @Override
    public void initTitle() {
        initToolbar("交易密码");
    }
}
