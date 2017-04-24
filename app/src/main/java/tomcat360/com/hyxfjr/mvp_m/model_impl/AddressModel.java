package tomcat360.com.hyxfjr.mvp_m.model_impl;

import android.content.Context;

import java.util.Map;

import tomcat360.com.hyxfjr.model.entity.AreaBean;
import tomcat360.com.hyxfjr.mvp_m.G;
import tomcat360.com.hyxfjr.mvp_m.model_interface.IAddressModel;
import tomcat360.com.hyxfjr.net.MyCallBack;
import tomcat360.com.hyxfjr.net.MyObserver;
import tomcat360.com.hyxfjr.net.NetWorks;

/**
 * Title:AddressModel
 * Package:com.tomcat360.m.model_impl
 * Description:TODO
 * Author: llj@tomcat360.com
 * Date: 2017/3/23
 * Version: V1.0.0
 * 版本号修改日期修改人修改内容
 */

public class AddressModel implements IAddressModel {

    @Override
    public void getAddrData(Context context, String parentId, final MyCallBack<AreaBean> callBack) {
        Map<String,String> map = G.getCommonMap();
        map.put("parentId",parentId);
        NetWorks.getInstance().getAddrData(context,map,
                new MyObserver<AreaBean>() {
                    @Override
                    public void onNext(AreaBean bean) {
                        callBack.onSuccess(bean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        callBack.onFailed(G.NETERROR+"地区查询失败");
                    }
                });
    }
}
