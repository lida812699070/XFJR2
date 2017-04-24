package tomcat360.com.hyxfjr.mvp_m.model_impl;

import android.content.Context;

import java.util.Map;

import tomcat360.com.hyxfjr.mvp_m.G;
import tomcat360.com.hyxfjr.mvp_m.model_interface.IUserActionModel;
import tomcat360.com.hyxfjr.model.entity.LoginEntity;
import tomcat360.com.hyxfjr.net.MyCallBack;
import tomcat360.com.hyxfjr.net.MyObserver;
import tomcat360.com.hyxfjr.net.NetWorks;

/**
 * Created by Administrator on 2017/4/12 0012.
 */

public class UserActionModel implements IUserActionModel{
    /**
     * 登录
     * @param context 上下文
     * @param name 用户名
     * @param password 密码
     * @param callback 回调
     */
    @Override
    public void goLogin(final Context context, String name, String password, final MyCallBack<LoginEntity> callback) {
        Map<String,String> map = G.getCommonMap();
        map.put("mobile", name);
        map.put("password", password);
        NetWorks.getInstance().goLogin(context,map, new MyObserver<LoginEntity>() {
            @Override
            public void onNext(LoginEntity loginEntity) {
                callback.onSuccess(loginEntity);
            }

            @Override
            public void onError(Throwable e) {
                callback.onFailed(G.NETERROR + "登录失败");
            }
        });
    }
}
