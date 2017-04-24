package tomcat360.com.hyxfjr.net;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import tomcat360.com.hyxfjr.mvp_m.G;

/**
 * Title:RetrofitUtils
 * Package:com.tomcat360.net
 * Description:TODO
 * Author: llj@tomcat360.com
 * Date: 2017/3/27
 * Version: V1.0.0
 * 版本号修改日期修改人修改内容
 */

public abstract class RetrofitUtils {
    private static Retrofit mRetrofit;
    private static Retrofit mImgRetrofit;//图片
    private static OkHttpClient mOkHttpClient;

    protected static Retrofit getRetrofit() {
        if (mRetrofit == null) {
            if (mOkHttpClient == null) {
                mOkHttpClient = OkHttp3Utils.getOkHttpClient();
            }
            mRetrofit = new Retrofit.Builder()
                    .baseUrl(G.URL_PREFIX + "/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .client(mOkHttpClient)
                    .build();
        }
        return mRetrofit;
    }

    protected static Retrofit getImgRetrofit() {
        if (mImgRetrofit == null) {
            if (mOkHttpClient == null) {
                mOkHttpClient = OkHttp3Utils.getOkHttpClient();
            }
            mImgRetrofit = new Retrofit.Builder()
                    .baseUrl(G.URL_PREFIX_PIC + "/")
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    // 图片不添加gsonconvert
                    .client(mOkHttpClient)
                    .build();
        }
        return mImgRetrofit;
    }

}
