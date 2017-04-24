package tomcat360.com.hyxfjr.mvp_m.model_interface;

/**
 * Created by Administrator on 2017/4/21 0021.
 */

public interface IRegisterModel {
    void register(String mobile, String checkCode, String inviteMobilem, String password);

    void getCheckCode(String mobileNumber);
}
