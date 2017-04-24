package tomcat360.com.hyxfjr.mvp_m;

/**
 * Created by Administrator on 2017/4/12 0012.
 */

public class StateConstant {
    // 登录
    public static final String STATE_ISLOGIN = "1";//登录状态
    public static final String STATE_LOGINOUT = "0";//未登录状态

    // 投资列表条件名称
    public static final String CONDITION_CATEGORY = "category";//分类
    public static final String CONDITION_BORROW_TYPE = "borrowType";//标类别
    public static final String CONDITION_XMSY = "xmsy";//收益
    public static final String CONDITION_BORROW_RZQX = "rzqx";//期限
    public static final String CONDITION_TBZT = "tbzt";//投标状态
    public static final String CONDITION_ORDERBY = "orderby";//期限

    // 红包分类
    public static final int CATEGORY_REDPACKET = 1;
    public static final int CATEGORY_EXPERIENCE = 2;
    public static final int CATEGORY_ADDRATE = 3;

    // 红包状态
    public static final int REDPACKET_USABLE = 0;
    public static final int REDPACKET_USED = 1;
    public static final int REDPACKET_OUTDATE = 3;

    // 验证码(手机修改、邮箱修改用）
    public static final int MSG_SEND_FIRST = 1;//第一个验证码
    public static final int MSG_SEND_SECOND = 2;//第二个验证码

    // 商城列表条件名称
    public static final String MALL_CONDITION_SCORE = "jfqj";//积分区域
    public static final String MALL_CONDITION_CATEGORY = "storeType";//分类
    public static final String MALL_CONDITION_ORDERBY = "orderby";//排序
}
