package tomcat360.com.hyxfjr.mvp_presenter.presenter_impl;

import tomcat360.com.hyxfjr.mvp_m.model_interface.IHomeFragmentModel;
import tomcat360.com.hyxfjr.mvp_v.i.IHomeFragmentView;

/**
 * Created by Administrator on 2017/4/18 0018.
 */

public class HomeFragmentPresenter {
    private IHomeFragmentModel model;
    private IHomeFragmentView view;

    public HomeFragmentPresenter(IHomeFragmentView view) {
        this.view = view;
    }


    public void showLoginDialog() {
        view.showLoginDialog();
    }

    public void putCenterBtn() {
        view.putCenterBtn();
    }

    public void intoContractNetwork() {
        view.intoContractNetwork();
    }

    public void intoMyData() {
        view.intoMyData();
    }

    public void intoRePayment() {
        view.intoRePayment();
    }

    public void intoScannin() {
        view.intoScannin();
    }
}
