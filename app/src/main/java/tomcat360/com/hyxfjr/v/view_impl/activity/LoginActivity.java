package tomcat360.com.hyxfjr.v.view_impl.activity;

import android.Manifest;
import android.content.Intent;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.jiongbull.jlog.JLog;
import com.tbruyelle.rxpermissions2.RxPermissions;
import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.bean.SHARE_MEDIA;

import java.util.Map;

import butterknife.Bind;
import butterknife.OnClick;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import tomcat360.com.hyxfjr.R;
import tomcat360.com.hyxfjr.mvp_m.G;
import tomcat360.com.hyxfjr.mvp_m.ParamNameConstant;
import tomcat360.com.hyxfjr.mvp_presenter.presenter_impl.LoginPresenter;
import tomcat360.com.hyxfjr.mvp_presenter.presenter_interface.ILoginPresenter;
import tomcat360.com.hyxfjr.mvp_v.i.ILoginView;
import tomcat360.com.hyxfjr.my_utils.MobileCheckUtils;
import util.StrUtils;

public class LoginActivity extends BaseActivity implements ILoginView {

    @Bind(R.id.btn_login)
    Button btnLogin;
    @Bind(R.id.login_finish)
    ImageView loginFinish;
    @Bind(R.id.login_mobil)
    EditText loginMobil;
    @Bind(R.id.tv_bottom_mobile)
    TextView tvBottomMobile;
    @Bind(R.id.iv_delete_phone)
    ImageView ivDeletePhone;
    @Bind(R.id.login_password)
    EditText loginPassword;
    @Bind(R.id.iv_wx_login)
    ImageView ivWxLogin;
    @Bind(R.id.login_into_reg)
    TextView loginIntoReg;
    @Bind(R.id.login_into_forget_password)
    TextView loginIntoForgetPassword;
    @Bind(R.id.activity_login)
    LinearLayout activityLogin;

    private ILoginPresenter loginPresenter;

    @Override
    public int getLayoutId() {
        return R.layout.activity_login;
    }

    @OnClick({R.id.btn_login, R.id.login_finish, R.id.iv_alipay_login, R.id.iv_delete_phone,
            R.id.iv_wx_login, R.id.login_into_reg, R.id.login_into_forget_password})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_login://登陆
                checkSdPermission();
                break;
            case R.id.login_finish://退出
                finish();
                break;
            case R.id.iv_alipay_login://支付宝登陆
                UMShareAPI.get(this).doOauthVerify(this, SHARE_MEDIA.WEIXIN, authListener);
                break;
            case R.id.iv_wx_login://微信登录
                UMShareAPI.get(this).doOauthVerify(this, SHARE_MEDIA.WEIXIN, authListener);
                break;
            case R.id.login_into_reg://立即注册
                startActivity(new Intent(this, RegisterActivity.class));
                break;
            case R.id.login_into_forget_password://忘记密码
                startActivity(new Intent(this, ResetPasswordActivity.class));
                break;
            case R.id.iv_delete_phone://清空电话编辑框
                loginMobil.setText("");
                break;

        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        UMShareAPI.get(this).onActivityResult(requestCode, resultCode, data);
    }

    UMAuthListener authListener = new UMAuthListener() {
        @Override
        public void onStart(SHARE_MEDIA platform) {

        }

        @Override
        public void onComplete(SHARE_MEDIA platform, int action, Map<String, String> data) {
            JLog.e("成功");
        }

        @Override
        public void onError(SHARE_MEDIA platform, int action, Throwable t) {
            JLog.e("失败" + t.getMessage());
        }

        @Override
        public void onCancel(SHARE_MEDIA platform, int action) {
            JLog.e("取消");
        }
    };

    private void checkSdPermission() {
        new RxPermissions(this)
                .request(Manifest.permission.WRITE_EXTERNAL_STORAGE)
                .subscribe(new Consumer<Boolean>() {
                    @Override
                    public void accept(@NonNull Boolean aBoolean) throws Exception {
                        if (aBoolean) {
                            login();
                        } else {
                            Toast.makeText(LoginActivity.this, "请到权限设置中同意相关权限", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    public void login() {
        if (!MobileCheckUtils.isMobileNO(loginMobil.getText().toString().trim())) {
            Toast.makeText(this, getResources().getString(R.string.mobile_error), Toast.LENGTH_SHORT).show();
            return;
        }
        showProgress("登录中...");
        loginPresenter.onPerformLogin(this, "15869025849", "a111111");
    }

    @Override
    public void initData() {

    }

    @Override
    public void initView() {
        loginPresenter = new LoginPresenter(this);

    }

    @Override
    public void initTitle() {

    }

    @Override
    public void loginSuccess() {
        showMessage("登录成功");
        hideProgress();
    }

    @Override
    public void loginFailed(String str) {
        hideProgress();
        showMessage(str);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            hideProgress();
            // 断线回退到主界面
            if (!StrUtils.isEmpty(getIntent().getStringExtra(ParamNameConstant.FROM_SESSION_OUT))) {
                G.SESSION_BROKEN = false;
                //TODO
            } else {
                finish();
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

}
