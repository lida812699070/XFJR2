package tomcat360.com.hyxfjr.v;

import android.app.Application;
import android.content.res.AssetManager;

import com.jiongbull.jlog.JLog;
import com.umeng.socialize.Config;
import com.umeng.socialize.PlatformConfig;
import com.umeng.socialize.UMShareAPI;

import java.io.InputStream;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import tomcat360.com.hyxfjr.BuildConfig;
import tomcat360.com.hyxfjr.model.entity.CityModel;
import tomcat360.com.hyxfjr.model.entity.ProvinceModel;
import tomcat360.com.hyxfjr.mvp_m.ParamNameConstant;
import tomcat360.com.hyxfjr.mvp_m.StateConstant;
import tomcat360.com.hyxfjr.my_utils.XmlParserHandler;
import tomcat360.com.hyxfjr.net.PersistentCookieStore;
import tomcat360.com.hyxfjr.view.gesture.LockPatternUtils;
import util.SPUtils;

/**
 * Created by Administrator on 2017/4/12 0012.
 */

public class APP extends Application {

    private static APP mInstance;
    private LockPatternUtils mLockPatternUtils;
    private List<ProvinceModel> provinceList;
    private List<CityModel> cityList;

    public LockPatternUtils getLockPatternUtils() {
        return mLockPatternUtils;
    }

    public static APP getInstance() {
        return mInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
        initThirdSdk();
      /*  Cockroach.install(new Cockroach.ExceptionHandler() {
            // handlerException内部建议手动try{  你的异常处理逻辑  }catch(Throwable e){ } ，以防handlerException内部再次抛出异常，导致循环调用handlerException

            @Override
            public void handlerException(final Thread thread, final Throwable throwable) {
                //开发时使用Cockroach可能不容易发现bug，所以建议开发阶段在handlerException中用Toast谈个提示框，
                //由于handlerException可能运行在非ui线程中，Toast又需要在主线程，所以new了一个new Handler(Looper.getMainLooper())，
                //所以千万不要在下面的run方法中执行耗时操作，因为run已经运行在了ui线程中。
                //new Handler(Looper.getMainLooper())只是为了能弹出个toast，并无其他用途
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            //建议使用下面方式在控制台打印异常，这样就可以在Error级别看到红色log
                            Log.e("AndroidRuntime", "--->CockroachException:" + thread + "<---", throwable);
                        } catch (Throwable e) {

                        }
                    }
                });
            }
        });*/
    }

    private void initThirdSdk() {
        //友盟分享登陆
        Config.DEBUG = true;
        UMShareAPI.get(this);
        //初始化手势密码
        mLockPatternUtils = new LockPatternUtils(this);
        JLog.init(this).setDebug(BuildConfig.DEBUG);
    }

    //配置第三方登陆的key
    {
        PlatformConfig.setWeixin("wx967daebe835fbeac", "5bb696d9ccd75a38c8a0bfe0675559b3");
        PlatformConfig.setAlipay("");
        PlatformConfig.setSinaWeibo("", "", "");
    }

    public List<ProvinceModel> getProvinceList() {
        if (provinceList == null)
            parserProvince();
        return provinceList;
    }

    public List<CityModel> getCtiyList() {
        if (cityList == null)
            parserProvince();
        return cityList;
    }

    private void parserProvince() {
        AssetManager asset = this.getAssets();
        try {
            InputStream input = asset.open("province_data.xml");
            // 创建一个解析xml的工厂对象
            SAXParserFactory spf = SAXParserFactory.newInstance();
            // 解析xml
            SAXParser parser = spf.newSAXParser();
            XmlParserHandler handler = new XmlParserHandler();
            parser.parse(input, handler);
            input.close();
            provinceList = handler.getDataList();
            cityList = handler.getCityList();
        } catch (Throwable e) {

        }
    }


    /**
     * 登出操作,清除密码
     */
    public void logout() {
        SPUtils.put(getInstance(), ParamNameConstant.LOGIN_PWD, "");
        SPUtils.put(this, ParamNameConstant.GUEST_STATUS, false);
        sessionOut();
    }

    /**
     * session中断,不清除密码
     */
    public void sessionOut() {
        SPUtils.put(getInstance(), ParamNameConstant.ISLOGIN, StateConstant.STATE_LOGINOUT);
        SPUtils.put(getInstance(), ParamNameConstant.SESSION_ID, "");
        SPUtils.put(getInstance(), ParamNameConstant.REALNAMESTATUS, "");
        SPUtils.put(getInstance(), ParamNameConstant.CARDBINDSTATUS, "");
        SPUtils.put(getInstance(), ParamNameConstant.SELF_HEAD_PIC, "");
        PersistentCookieStore.clearCookie();//本地cookie清空
    }


}
