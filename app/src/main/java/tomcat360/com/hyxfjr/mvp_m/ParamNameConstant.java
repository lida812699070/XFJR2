package tomcat360.com.hyxfjr.mvp_m;

/**
 * Created by Administrator on 2017/4/12 0012.
 */

public class ParamNameConstant {
    /**
     * 标信息
     */
    public static final String BORROW = "borrow";//标
    public static final String BORROW_ID = "borrowId";//标id
    public static final String MARKET_ID = "marketId";//转让id
    public static final String TENDER_MONEY = "tenderMoney";//投资金额
    public static final String BORROW_PAYMENT = "borrowPayment";//还款方式
    public static final String BORROW_APR = "borrowApr";//利率
    public static final String BORROW_LIMIT = "borrowLimit";//借款期限
    /**
     * 红包信息
     */
    public static final String PACKET_MONEY = "packetMoney";//红包金额
    public static final String PACKET_NAME = "packetName";//红包名称
    public static final String PACKET_ID = "packetId";//红包id
    public static final String PACKET_CATEGORY = "packetCategory";//红包种类
    /**
     * 登录信息
     */
    public static final String ISLOGIN = "isLogin";//是否登录
    public static final String LOGIN_NAME = "name";//登录手机号
    public static final String LOGIN_PWD = "passWord";//登录密码
    public static final String SESSION_ID = "sessionId";//sessionId
    public static final String REALNAMESTATUS = "realVerifyStatus";//是否实名
    public static final String CARDBINDSTATUS = "cardBindingStatus";//是否绑卡
    public static final String EMAIL_NO = "emailNo";//邮箱号
    public static final String USER_ID = "userId";//用户id
    public static final String EMAIL_BIND_STATUS = "emailBindStatus";//邮箱是否有绑定
    public static final String FROM_SESSION_OUT = "fromSessionOut";//session中断标记
    public static final String GUEST_STATUS = "guestStatus";//手势密码
    /**
     * 账户信息
     */
    public static final String HIDEACCOUNT = "hideAccount";//隐藏金额
    public static final String SELF_HEAD_PIC = "headPic";//个人中心头像
    public static final String SEND_FORGETPWD = "sendForgetPwd";//忘记密码发送验证码标记
    public static final String ACCOUNT_USABLE = "accountUsable";//可用余额
    public static final String FROM_MODIFY_PWD = "fromModifyPwd";//修改密码标记
    /**
     * webview
     */
    public static final String PARAMETER_NAME_URL = "html_url"; // 地址
    public static final String PARAMETER_NAME_TITLE = "html_title"; // 标题
    public static final String PARAMETER_NAME_DATA = "html_data"; // 参数
    public static final String PARAMETER_NAME_ALLOW_BACK = "html_back"; // 允许回退上一页面
    /**
     * 商城
     */
    public static final String PARAMETER_MALL_PRODUCT = "mallProduct";//商品
}
