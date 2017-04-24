package tomcat360.com.hyxfjr.v.view_impl.activity;

import android.graphics.Color;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.OnClick;
import tomcat360.com.hyxfjr.R;
import tomcat360.com.hyxfjr.mvp_presenter.presenter_impl.ResetPasswordPresenter;
import tomcat360.com.hyxfjr.mvp_v.i.IResetPasswordView;
import tomcat360.com.hyxfjr.my_utils.GetCheckCodeUtils;
import tomcat360.com.hyxfjr.view.MyToolbar;
import util.ButtonClickUtil;

public class ResetPasswordActivity extends BaseActivity implements IResetPasswordView {


    @Bind(R.id.base_toolbar)
    MyToolbar baseToolbar;
    @Bind(R.id.et_mobile_number)
    EditText etMobileNumber;
    @Bind(R.id.et_check_code)
    EditText etCheckCode;
    @Bind(R.id.btn_get_checkcode)
    Button btnGetCheckcode;
    @Bind(R.id.textView3)
    TextView textView3;
    @Bind(R.id.et_new_password)
    EditText etNewPassword;
    @Bind(R.id.et_again_new_password)
    EditText etAgainNewPassword;
    @Bind(R.id.btn_reset_password_put)
    Button btnResetPasswordPut;
    private ResetPasswordPresenter presenter;

    @Override
    public int getLayoutId() {
        return R.layout.activity_reset_password;
    }

    @Override
    public void initData() {

    }


    @OnClick({R.id.btn_get_checkcode, R.id.btn_reset_password_put})
    public void onClick(View view) {
        if (ButtonClickUtil.isFastDoubleClick()) return;
        switch (view.getId()) {
            case R.id.btn_get_checkcode://获取验证码
                presenter.getCheckCode();
                break;
            case R.id.btn_reset_password_put://重置密码
                presenter.resetPassword();
                break;
        }
    }

    @Override
    public void initView() {
        initToolbar("忘记密码");
        presenter = new ResetPasswordPresenter(this);
    }

    @Override
    public void initTitle() {

    }

    @Override
    public String getPassword() {
        return etNewPassword.getText().toString().trim();
    }

    @Override
    public String getPasswordAgain() {
        return etAgainNewPassword.getText().toString().trim();
    }

    @Override
    public String getMobile() {
        return etMobileNumber.getText().toString().trim();
    }

    @Override
    public String getCheckcode() {
        return etCheckCode.getText().toString().trim();
    }

    @Override
    public void startTimer() {
        GetCheckCodeUtils.getCheckCode(60, btnGetCheckcode, Color.WHITE);
    }
}
