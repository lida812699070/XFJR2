package tomcat360.com.hyxfjr.mvp_m;

import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.support.annotation.Nullable;

import java.util.HashMap;
import java.util.Map;

import util.StrUtils;

public final class G {

    //	public static final String URL_PREFIX = "http://183.129.157.218:8188/cbd";
//	public static final String URL_PREFIX_PIC = "http://183.129.157.218:8188";
    /*public static final String URL_PREFIX = "http://183.129.157.218:8446/cbd";
    public static final String URL_PREFIX_PIC = "http://183.129.157.218:8446";*/
    public static final String URL_PREFIX = "https://www.chebangp2p.com";
    public static final String URL_PREFIX_PIC = "https://www.chebangp2p.com";

    /**
     * 注册-h5
     */
    // 用户注册协议
    public static final String URL_H5_REGIST_AGRREMENT = URL_PREFIX + "/wechat/index.html#/registAgreement";

    /**
     * 个人中心-h5
     */
    // 还款
    public static final String URL_PAY = URL_PREFIX + "/app/myhome/repayment.html";
    // 邀请好友
    public static final String URL_H5_INVITE = URL_PREFIX + "/wechat/index.html#/invite";

    /**
     * 投资-h5
     */
    // 投标
    public static final String URL_INVEST = URL_PREFIX + "/app/myhome/tender.html";
    // 承接债权
    public static final String URL_INVEST_ZR = URL_PREFIX + "/app/myhome/accept_right.html";
    //借款信息-h5
    public static final String URL_H5_BORROW_INFO = URL_PREFIX + "/wechat/index.html#/borrowInfo";
    //借款信息-h5
    public static final String URL_H5_CAR_INFO = URL_PREFIX + "/wechat/index.html#/carInfo";

    /**
     * 设置-h5
     */
    // 实名
    public static final String URL_REALNAME = URL_PREFIX + "/app/myhome/realname.html";
    // 充值
    public static final String URL_RECHARGE = URL_PREFIX + "/app/myhome/charge.html";
    // 提现
    public static final String URL_WITHDRAW = URL_PREFIX + "/app/myhome/withdraw.html";

    /**
     * 更多-h5
     */
    public static final String URL_H5_ABOUT_US = URL_PREFIX + "/wechat/index.html#/aboutus";//关于我们
    public static final String URL_H5_PLAT_DATA = URL_PREFIX + "/wechat/index.html#/data";//平台数据
    public static final String URL_H5_NOTICE = URL_PREFIX + "/wechat/index.html#/notice";//平台公告
    public static final String URL_H5_AFTER_BORROW = URL_PREFIX + "/wechat/index.html#/afterBorrow";//贷后中心
    public static final String URL_H5_HELP = URL_PREFIX + "/wechat/index.html#/help";//帮助中心
    public static final String URL_H5_JOIN = URL_PREFIX + "/wechat/index.html#/join";//招商加盟

    /**
     * 第三方
     */
    public static final String URL_GO_CENTER = "/center";// 返回个人中心
    public static final String URL_CLOSE = "/close";//关闭页面

    // 成功返回code
    public static final String REQUEST_SUCCESS_CODE = "0";
    // 掉线code
    public static final String LOGINOUT_CODE = "-1";
    //banner页面的宽高比
    public static final double BANNER_SIZE_RATE = 25.0 / 9.0;
    //客服电话
    public static final String OFFICIAL_TEL = "400-9057-127";
    //图片地址
    public static final String IMAGE_PATH = "imagePath";
    //扫描二维码 Activity返回码
    public static final int SCANNIN_GREQUEST_CODE = 4;
    // 用于限制多次弹出账号掉线对话框
    public static boolean SESSION_BROKEN = false;
    // 设备ID
    public static String DEVICE_ID = "";
    // 系统API
    public static int SYSTEM_SDK_API = 0;
    // app版本，不需要维护
    public static String APPVERSION = "";// 赋值防止自动登录map有null值不访问
    // 登录提示语
    public static String LOGIN_WARN = "请先登录";
    // 网络框架error提示头
    public static final String NETERROR = "未知的错误:";
    // session掉线
    public static final String SESSION_OUT = "与服务器的连接中断，请重新登录";
    //拍照/选择图片  返回码
    public static final int SELECT_PICTURE = 1;
    public static final int SELECT_CAMER = 2;
    //图片裁剪 返回码
    public static final int RESULT_REQUEST_CODE = 3;
    //7.0获取本地路径uri的时候权限用
    public static final String GET_PATH_URI = "tomcat360.com.hyxfjr.v.view_impl.activity";
  /*  //手势密码 intent  key
    public static final String GESTURE_KEY = "gesture_key";
    //手势密码  创建
    public static final int GESTURE_CREATE = 0;
    //手势密码  校验
    public static final int GESTURE_CHECK = 1;
    //手势密码  修改密码
    public static final int GESTURE_RESET = 2;
    //手势密码  取消
    public static final int GESTURE_CANCEL = 3;*/

    /**
     * 统一的文件保存路径
     *
     * @return
     */
    public static String getFileRootPath() {
        return Environment.getExternalStorageDirectory().getPath() + "/cbd";
    }

    /**
     * 后台上传图片路径处理
     *
     * @param path
     * @return
     */
    @Nullable
    public static Uri formatUri(String path) {
        if (StrUtils.isEmpty(path)) {
            return null;
        }
        return Uri.parse(formatPath(path));
    }

    /**
     * 后台上传图片路径处理
     *
     * @param path
     * @return
     */
    @Nullable
    public static String formatPath(String path) {
        if (StrUtils.isEmpty(path)) {
            return null;
        }
        if (path.contains("/cbd") && !path.contains(URL_PREFIX_PIC)) {//未包含头部地址，拼接
            return G.URL_PREFIX_PIC + path;
        } else {//已经包含地址的
            return path;
        }
    }

    /**
     * @param
     * @Title getCommonMap
     * @Description 公用请求参数map
     */
    public static Map<String, String> getCommonMap() {
        Map<String, String> maps = new HashMap<>();
        maps.put("version", G.APPVERSION);
        maps.put("deviceType", Build.MODEL);    //设备类型
        return maps;
    }
}
