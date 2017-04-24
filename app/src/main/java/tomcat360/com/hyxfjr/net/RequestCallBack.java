package tomcat360.com.hyxfjr.net;

/**
 * Title:RequestCallBack
 * Package:com.tomcat360.net
 * Description:TODO
 * Author: llj@tomcat360.com
 * Date: 2017/3/27
 * Version: V1.0.0
 * 版本号修改日期修改人修改内容
 */

public interface RequestCallBack<T> {
    void onSuccess(T response);
    void onFailed(String msg);
    void onFinish();
}
