package tomcat360.com.hyxfjr.mvp_presenter.presenter_impl;


import tomcat360.com.hyxfjr.mvp_m.model_impl.Input6PasswordModel;
import tomcat360.com.hyxfjr.mvp_m.model_interface.IInput6PasswordModel;
import tomcat360.com.hyxfjr.mvp_v.i.IInput6PasswordView;

/**
 * Created by Administrator on 2017/4/15 0015.
 */

public class Input6PasswordPresenter {
    private IInput6PasswordModel model;
    private IInput6PasswordView view;

    public Input6PasswordPresenter(IInput6PasswordView loanAcView) {
        this.view = loanAcView;
        model = new Input6PasswordModel();
    }

    public void intoLoanSuccess() {
        if (view.getPassword() == null || view.getPassword().length() != 6) {
            view.showMessage("密码长度为6位数");
            return;
        }
        view.intoLoanSuccess();
    }
}
