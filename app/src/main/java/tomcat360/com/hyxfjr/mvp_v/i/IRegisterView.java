package tomcat360.com.hyxfjr.mvp_v.i;

/**
 * Created by Administrator on 2017/4/21 0021.
 */

public interface IRegisterView {
    String getMobileNumber();

    String getCheckCode();

    String getInviterMobile();

    String getPassword();

    String getPasswordAgain();

    void showMessage(String message);

    void startTimer();
}
