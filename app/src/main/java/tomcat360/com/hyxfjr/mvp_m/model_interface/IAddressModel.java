package tomcat360.com.hyxfjr.mvp_m.model_interface;

import android.content.Context;

import tomcat360.com.hyxfjr.model.entity.AreaBean;
import tomcat360.com.hyxfjr.net.MyCallBack;

/**
 * Title:IAddressModel
 * Package:com.tomcat360.m.model_interface
 * Description:TODO
 * Author: llj@tomcat360.com
 * Date: 2017/3/23
 * Version: V1.0.0
 * 版本号修改日期修改人修改内容
 */

public interface IAddressModel {
    void getAddrData(Context context, String parentId, MyCallBack<AreaBean> callBack);
}
