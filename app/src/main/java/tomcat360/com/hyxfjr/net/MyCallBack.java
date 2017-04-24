package tomcat360.com.hyxfjr.net;

/**
 * Title:MyCallBack
 * Package:com.tomcat360.net
 * Description:TODO
 * Author: llj@tomcat360.com
 * Date: 2017/3/27
 * Version: V1.0.0
 * 版本号修改日期修改人修改内容
 */

public abstract class MyCallBack<T> implements RequestCallBack<T> {

    @Override
    public void onSuccess(T response) {

    }

    @Override
    public void onFailed(String msg) {

    }

    @Override
    public void onFinish() {

    }
}
