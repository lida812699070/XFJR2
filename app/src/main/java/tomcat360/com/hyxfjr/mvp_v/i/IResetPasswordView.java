package tomcat360.com.hyxfjr.mvp_v.i;

/**
 * Created by lida on 2017/4/21 0021.
 */

public interface IResetPasswordView {
    String getPassword();

    String getPasswordAgain();

    String getMobile();

    String getCheckcode();

    void showMessage(String message);

    void startTimer();
}
