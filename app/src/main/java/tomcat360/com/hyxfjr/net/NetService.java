package tomcat360.com.hyxfjr.net;




import java.util.Map;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import tomcat360.com.hyxfjr.model.entity.AreaBean;
import tomcat360.com.hyxfjr.model.entity.LoginEntity;
import tomcat360.com.hyxfjr.model.entity.MsgBean;

/**
 * Title:NetService
 * Package:com.tomcat360.net
 * Description:TODO
 * Author: llj@tomcat360.com
 * Date: 2017/3/27
 * Version: V1.0.0
 * 版本号修改日期修改人修改内容
 */

public interface NetService {
    /**
     * 登录、注册、忘记密码
     */
    // 短信验证码
    @FormUrlEncoded
    @POST("app/send_code.html")
    Observable<MsgBean> getMessageCode(@FieldMap Map<String, String> map);
    // 图形验证码
    @GET("pcrimg.html")
    Observable<ResponseBody> getVerifyPic(@Query("keycode") String keycode);
    // 注册
    @FormUrlEncoded
    @POST("app/register.html")
    Observable<MsgBean> goRegister(@FieldMap Map<String, String> map);
    // 登录
    @FormUrlEncoded
    @POST("app/login.html")
    Observable<LoginEntity> goLogin(@FieldMap Map<String, String> map);
    // 地区选择
    @FormUrlEncoded
    @POST("app/province_list.html")
    Observable<AreaBean> getAddrData(@FieldMap Map<String,String> map);
}
