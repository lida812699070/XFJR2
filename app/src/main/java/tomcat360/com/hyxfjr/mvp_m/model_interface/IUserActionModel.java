package tomcat360.com.hyxfjr.mvp_m.model_interface;

/**
 * Created by Administrator on 2017/4/12 0012.
 */

import android.content.Context;

import tomcat360.com.hyxfjr.model.entity.LoginEntity;
import tomcat360.com.hyxfjr.net.MyCallBack;


/**
 * Title:IUserActionModel
 * Package:com.tomcat360.model.modelInterface
 * Description:用户操作型model 包括登录 注册 忘记密码等
 * Author: wwh@tomcat360.com
 * Date: 16/3/24
 * Version: V1.0.0
 * 版本号修改日期修改人修改内容
 */
public interface IUserActionModel {
    /**
     * 登录请求 A011
     * @param context 上下文
     * @param name 用户名
     * @param password 密码
     * @param callBack 回调
     */
    void goLogin(Context context, String name, String password, MyCallBack<LoginEntity> callBack);

}

