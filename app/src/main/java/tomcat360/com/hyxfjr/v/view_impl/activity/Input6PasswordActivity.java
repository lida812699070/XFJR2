package tomcat360.com.hyxfjr.v.view_impl.activity;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.OnClick;
import tomcat360.com.hyxfjr.R;
import tomcat360.com.hyxfjr.listener.InputPasswordCallback;
import tomcat360.com.hyxfjr.mvp_presenter.presenter_impl.Input6PasswordPresenter;
import tomcat360.com.hyxfjr.mvp_v.i.IInput6PasswordView;
import tomcat360.com.hyxfjr.view.PasswordInputView;

public class Input6PasswordActivity extends BaseActivity implements IInput6PasswordView {


    @Bind(R.id.input_password_et)
    PasswordInputView inputPasswordEt;
    @Bind(R.id.input_password_forget_psw)
    TextView inputPasswordForgetPsw;
    @Bind(R.id.input_password_put_btn)
    Button inputPasswordPutBtn;
    @Bind(R.id.activity_input6_password)
    LinearLayout activityInput6Password;
    private Input6PasswordPresenter presenter;
    private String mPassword;

    @Override
    public int getLayoutId() {
        return R.layout.activity_input6_password;
    }

    @Override
    public void initData() {

    }

    @Override
    public void initView() {
        presenter = new Input6PasswordPresenter(this);
        initToolbar("输入交易密码");
        inputPasswordEt.setCallback(new InputPasswordCallback() {
            @Override
            public void inputFinish(String password) {
                mPassword = password;
                if (password.length() == 6) {
                    inputPasswordPutBtn.setBackgroundColor(getResources().getColor(R.color.guestPaint_color_wrong));
                }
            }
        });
    }

    @Override
    public void initTitle() {

    }

    @OnClick({R.id.input_password_put_btn})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.input_password_put_btn:
                presenter.intoLoanSuccess();
                break;
            default:
                break;
        }
    }

    @Override
    public void intoLoanSuccess() {
        startActivity(new Intent(this, LoanSuccessActivity.class));
    }

    @Override
    public String getPassword() {
        return mPassword;
    }
}
