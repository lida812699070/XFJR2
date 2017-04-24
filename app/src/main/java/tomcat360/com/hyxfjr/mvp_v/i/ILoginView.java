package tomcat360.com.hyxfjr.mvp_v.i;

/**
 * Created by Administrator on 2017/4/12 0012.
 */

public interface ILoginView {
    /**
     * 登录成功操作
     */
    void loginSuccess();

    /**
     * 登录失败操作
     * @param str
     */
    void loginFailed(String str);
}
