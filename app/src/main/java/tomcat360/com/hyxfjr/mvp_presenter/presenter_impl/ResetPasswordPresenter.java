package tomcat360.com.hyxfjr.mvp_presenter.presenter_impl;

import android.text.TextUtils;

import tomcat360.com.hyxfjr.mvp_m.model_impl.ResetPasswordModel;
import tomcat360.com.hyxfjr.mvp_m.model_interface.IResetPasswordModel;
import tomcat360.com.hyxfjr.mvp_v.i.IResetPasswordView;
import tomcat360.com.hyxfjr.my_utils.MobileCheckUtils;

/**
 * Created by lida on 2017/4/21 0021.
 */

public class ResetPasswordPresenter {
    private IResetPasswordModel model;
    private IResetPasswordView view;

    public ResetPasswordPresenter(IResetPasswordView view) {
        this.view = view;
        model = new ResetPasswordModel();
    }

    public void getCheckCode() {
        String mobileNumber = view.getMobile();
        if (TextUtils.isEmpty(mobileNumber)) {
            view.showMessage("手机号不能为空");
        } else if (!MobileCheckUtils.isMobileNO(mobileNumber)) {
            view.showMessage("输入正确的手机号");
        } else {
            //获取验证码
            view.showMessage("获取验证码。。。");
            view.startTimer();
            model.getCheckCode(mobileNumber);
        }
    }

    public void resetPassword() {
        String password = view.getPassword();
        String passwordAgain = view.getPasswordAgain();
        String checkCode = view.getCheckcode();
        String mobile = view.getMobile();
        if (TextUtils.isEmpty(password) || TextUtils.isEmpty(passwordAgain)) {
            view.showMessage("密码不能为空");
        } else if (checkCode.length() > 6) {
            view.showMessage("短信验证码格式不正确");
        } else if (!MobileCheckUtils.isMobileNO(mobile)) {
            view.showMessage("输入正确的手机号");
        } else if (password.matches("[0-9]+")) {
            view.showMessage("密码不能纯数字");
        } else if (password.matches("[A-Za-z]+")) {
            view.showMessage("密码不能纯字母");
        } else if (password.matches("[A-Za-z]+")) {
            view.showMessage("密码不能纯字母");
        } else if (password.matches("[A-Za-z]+")) {
            view.showMessage("密码不能纯字母");
        } else {
            //注册
            view.showMessage("重置密码。。。");
            model.resetPassword(mobile, checkCode, password);
        }
    }
}