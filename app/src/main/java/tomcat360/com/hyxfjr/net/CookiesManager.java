package tomcat360.com.hyxfjr.net;


import android.content.Context;

import java.util.List;

import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.HttpUrl;

/**
 * Title:CookieManage
 * Package:com.tomcat360.yybz.volley
 * Description:cookie管理
 * Author: llj@tomcat360.com
 * Date: 2016/7/8
 * Version: V1.0.0
 * 版本号修改日期修改人修改内容
 */
public class CookiesManager implements CookieJar {

    private Context mContext;
    private PersistentCookieStore cookieStore = null;

    public CookiesManager(Context context) {
        this.mContext = context;
        cookieStore = new PersistentCookieStore(mContext);
    }

    @Override
    public void saveFromResponse(HttpUrl url, List<Cookie> cookies) {
        if (cookies != null && cookies.size() > 0) {
            for (Cookie item : cookies) {
                cookieStore.add(url, item);
            }
        }
    }

    @Override
    public List<Cookie> loadForRequest(HttpUrl url) {
        List<Cookie> cookies = cookieStore.get(url);
        return cookies;
    }

}