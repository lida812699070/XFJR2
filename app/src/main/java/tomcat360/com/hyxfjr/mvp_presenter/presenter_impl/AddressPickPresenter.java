package tomcat360.com.hyxfjr.mvp_presenter.presenter_impl;

import android.content.Context;

import tomcat360.com.hyxfjr.model.entity.AreaBean;
import tomcat360.com.hyxfjr.mvp_m.G;
import tomcat360.com.hyxfjr.mvp_m.model_impl.AddressModel;
import tomcat360.com.hyxfjr.mvp_m.model_interface.IAddressModel;
import tomcat360.com.hyxfjr.mvp_presenter.presenter_interface.IAddressPickPresenter;
import tomcat360.com.hyxfjr.net.MyCallBack;
import tomcat360.com.hyxfjr.v.view_impl.activity.IAddressPickActivity;


/**
 * Title:AddressPickPresenter
 * Package:com.tomcat360.presenter.presenter_impl
 * Description:TODO
 * Author: llj@tomcat360.com
 * Date: 2017/3/23
 * Version: V1.0.0
 * 版本号修改日期修改人修改内容
 */

public class AddressPickPresenter implements IAddressPickPresenter {

    private IAddressPickActivity addressPickActivity;
    private IAddressModel addressModel;
    public AddressPickPresenter(IAddressPickActivity activity) {
        addressPickActivity = activity;
        addressModel = new AddressModel();
    }

    @Override
    public void getAddrData(Context context, String parentId, final String parentName, final int type) {
        addressModel.getAddrData(context, parentId, new MyCallBack<AreaBean>() {
            @Override
            public void onSuccess(AreaBean bean) {
                if (bean.getCode().equals(G.REQUEST_SUCCESS_CODE)) {
                    addressPickActivity.getAddrSuc(bean,parentName,type);
                } else {
                    addressPickActivity.showMessage(bean.getMsg());
                }
            }

            @Override
            public void onFailed(String msg) {
                addressPickActivity.showMessage(msg);
            }

            @Override
            public void onFinish() {

            }
        });
    }
}
