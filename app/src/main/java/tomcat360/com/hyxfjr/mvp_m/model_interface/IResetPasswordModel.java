package tomcat360.com.hyxfjr.mvp_m.model_interface;

/**
 * Created by lida on 2017/4/21 0021.
 */

public interface IResetPasswordModel {
    void getCheckCode(String mobileNumber);

    void resetPassword(String mobile, String checkCode, String password);
}
