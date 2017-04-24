package tomcat360.com.hyxfjr.mvp_presenter.presenter_impl;

import tomcat360.com.hyxfjr.mvp_m.model_interface.ISettingAcModel;
import tomcat360.com.hyxfjr.mvp_v.i.ISettingAcView;

/**
 * Created by Administrator on 2017/4/17 0017.
 */

public class SettingAcPresenter {
    private ISettingAcModel model;
    private ISettingAcView view;

    public SettingAcPresenter(ISettingAcView view) {
        this.view = view;
    }

    public void intoResetPassword(){
        view.intoResetPassword();
    }

    public void intoBankCardManage() {
        view.intoBankCardManage();
    }

    public void intoAddressManage() {
        view.intoAddressManage();
    }

    public void intoBindMobile() {
        view.intoBindMobile();
    }

    public void intoAddressManagement() {
        view.intoAddressManagement();
    }

    public void intoGesturePassword() {
        view.intoGesturePassword();
    }
}
