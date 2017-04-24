package tomcat360.com.hyxfjr.mvp_presenter.presenter_impl;

import tomcat360.com.hyxfjr.mvp_m.model_interface.IShipAddressManageAcModel;
import tomcat360.com.hyxfjr.mvp_v.i.IShipAddressManageAcView;

/**
 * Created by Administrator on 2017/4/17 0017.
 */

public class ShipAddressManageAcPresenter {
    private IShipAddressManageAcModel model;
    private IShipAddressManageAcView view;

    public ShipAddressManageAcPresenter(IShipAddressManageAcView view) {
        this.view = view;
    }


    public void newAddress() {
        view.newAddress();
    }
}
