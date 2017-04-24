package tomcat360.com.hyxfjr.net;

import java.io.File;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.OkHttpClient;
import tomcat360.com.hyxfjr.mvp_m.G;
import tomcat360.com.hyxfjr.v.APP;

/**
 * Title:OkHttp3Utils
 * Package:com.tomcat360.net
 * Description:TODO
 * Author: llj@tomcat360.com
 * Date: 2017/3/27
 * Version: V1.0.0
 * 版本号修改日期修改人修改内容
 */

public class OkHttp3Utils {
    private static OkHttpClient mOkHttpClient;
    // 设置缓存目录
    private static File cacheDir = new File(G.getFileRootPath(),"mycache");
    private static Cache cache = new Cache(cacheDir,10*1024*1024);//10M

    public static OkHttpClient getOkHttpClient() {
        if (mOkHttpClient == null) {
            mOkHttpClient = new OkHttpClient.Builder()
                    .cookieJar(new CookiesManager(APP.getInstance().getApplicationContext()))
                    .connectTimeout(10, TimeUnit.SECONDS)
                    .writeTimeout(30,TimeUnit.SECONDS)
                    .readTimeout(30,TimeUnit.SECONDS)
                    .cache(cache)
                    .build();
        }
        return mOkHttpClient;
    }
}
