package tomcat360.com.hyxfjr.mvp_presenter.presenter_impl;

import tomcat360.com.hyxfjr.mvp_m.model_interface.IMyDataAcModle;
import tomcat360.com.hyxfjr.mvp_v.i.IMyDataAcView;

/**
 * Created by Administrator on 2017/4/19 0019.
 */

public class MyDataPresenter {
    private IMyDataAcModle modle;
    private IMyDataAcView view;

    public MyDataPresenter(IMyDataAcView view) {
        this.view = view;
    }

    public void intoBaseMessage() {
        view.intoBaseMessage();
    }

    public void intoJobMessage() {
        view.intoJobMessage();
    }

    public void intoHouseMessage() {
        view.intoHouseMessage();
    }

    public void intoCarMessage() {
        view.intoCarMessage();
    }

    public void intoHouseMoney() {
        view.intoHouseMoney();
    }

    public void intoOtherMessage() {
        view.intoOtherMessage();

    }
}
