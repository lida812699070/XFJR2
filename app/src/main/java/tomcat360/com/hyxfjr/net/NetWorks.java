package tomcat360.com.hyxfjr.net;

import android.content.Context;


import java.util.Map;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import tomcat360.com.hyxfjr.model.entity.AreaBean;
import tomcat360.com.hyxfjr.model.entity.BaseBean;
import tomcat360.com.hyxfjr.model.entity.LoginEntity;

/**
 * Title:NetWorks
 * Package:com.tomcat360.net
 * Description:TODO
 * Author: lida@tomcat360.com
 * Date: 2017/3/27
 * Version: V1.0.0
 * 版本号修改日期修改人修改内容
 */

public class NetWorks extends RetrofitUtils {

    private static NetWorks instance;
    private NetService service;

    /**
     * 构造
     */
    public NetWorks() {
        if (service == null) {
            service = getRetrofit().create(NetService.class);
        }
    }

    /**
     * 单例
     *
     * @return
     */
    public synchronized static NetWorks getInstance() {
        if (instance == null) {
            instance = new NetWorks();
        }
        return instance;
    }

    /**
     * 通用订阅
     *
     * @param observable
     * @param observer
     * @param <T>
     */
    private <T extends BaseBean> void setSubscribe(Context context, Observable<T> observable, Observer<T> observer) {
        observable.subscribeOn(Schedulers.io())
                .flatMap(new RxHttpResult<T>(context))
                .subscribeOn(Schedulers.newThread())//子线程访问网络
                .observeOn(AndroidSchedulers.mainThread())//回调到主线程
                .subscribe(observer);
    }


    // 登录
    public void goLogin(Context context, Map<String, String> map, Observer<LoginEntity> observer) {
        setSubscribe(context, service.goLogin(map), observer);
    }

    // 地区选择
    public void getAddrData(Context context,Map<String,String>map,Observer<AreaBean> observer) {
        setSubscribe(context,service.getAddrData(map),observer);
    }
}
