package tomcat360.com.hyxfjr.v.view_impl.activity;

import android.graphics.Color;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import butterknife.Bind;
import butterknife.OnClick;
import io.reactivex.disposables.Disposable;
import tomcat360.com.hyxfjr.R;
import tomcat360.com.hyxfjr.mvp_presenter.presenter_impl.RegisterPresenter;
import tomcat360.com.hyxfjr.mvp_v.i.IRegisterView;
import tomcat360.com.hyxfjr.my_utils.GetCheckCodeUtils;
import tomcat360.com.hyxfjr.view.MyToolbar;

public class RegisterActivity extends BaseActivity implements IRegisterView {


    @Bind(R.id.reg_mobile)
    EditText regMobile;
    @Bind(R.id.reg_message_check_et)
    EditText regMessageCheckEt;
    @Bind(R.id.reg_message_check_btn)
    Button regMessageCheckBtn;
    @Bind(R.id.reg_invite_mobile)
    EditText regInviteMobile;
    @Bind(R.id.reg_password)
    EditText regPassword;
    @Bind(R.id.reg_put_btn)
    Button regPutBtn;
    @Bind(R.id.activity_register)
    LinearLayout activityRegister;
    @Bind(R.id.base_toolbar)
    MyToolbar baseToolbar;
    @Bind(R.id.reg_password_again)
    EditText regPasswordAgain;
    private Disposable checkCode;
    private RegisterPresenter presenter;

    @Override
    public int getLayoutId() {
        return R.layout.activity_register;
    }

    @Override
    public void initData() {

    }

    @Override
    public void initView() {
        initToolbar("注册");
        presenter = new RegisterPresenter(this);
    }

    @Override
    public void initTitle() {

    }

    @OnClick({R.id.reg_put_btn, R.id.reg_message_check_btn})
    public void onclick(View view) {
        switch (view.getId()) {
            case R.id.reg_put_btn:
                presenter.regiter(getMobileNumber(),getCheckCode(),getInviterMobile(),getPassword(),getPasswordAgain());
                break;
            case R.id.reg_message_check_btn:
                presenter.getCheckCode(getMobileNumber());
                break;
        }
    }

    @Override
    protected void onDestroy() {
        if (checkCode != null) {
            checkCode.dispose();
        }
        super.onDestroy();
    }

    @Override
    public String getMobileNumber() {
        return regMobile.getText().toString().trim();
    }

    @Override
    public String getCheckCode() {
        return regMessageCheckEt.getText().toString().trim();
    }

    @Override
    public String getInviterMobile() {
        return regInviteMobile.getText().toString().trim();
    }

    @Override
    public String getPassword() {
        return regPassword.getText().toString().trim();
    }

    @Override
    public String getPasswordAgain() {
        return regPasswordAgain.getText().toString().trim();
    }

    @Override
    public void startTimer() {
        checkCode = GetCheckCodeUtils.getCheckCode(60, regMessageCheckBtn, Color.WHITE);
    }
}
