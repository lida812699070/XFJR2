package tomcat360.com.hyxfjr.mvp_presenter.presenter_impl;

import tomcat360.com.hyxfjr.mvp_v.i.IContractNetworkView;

/**
 * Created by Administrator on 2017/4/19 0019.
 */

public class ContractNetworkPresenter {
    private IContractNetworkView view;

    public ContractNetworkPresenter(IContractNetworkView view) {
        this.view = view;
    }

    public void initCompanyAddresList() {
        view.initCompanyAddresList();
    }
}
