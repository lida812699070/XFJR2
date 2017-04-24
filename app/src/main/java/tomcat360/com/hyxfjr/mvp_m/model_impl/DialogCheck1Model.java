package tomcat360.com.hyxfjr.mvp_m.model_impl;

import tomcat360.com.hyxfjr.mvp_m.model_interface.IDialogCheck1Model;
import tomcat360.com.hyxfjr.my_utils.MobileCheckUtils;

/**
 * Created by Administrator on 2017/4/18 0018.
 */

public class DialogCheck1Model implements IDialogCheck1Model {
    @Override
    public boolean checkIsmobile(String mobile) {
        return MobileCheckUtils.isMobileNO(mobile);
    }
}
