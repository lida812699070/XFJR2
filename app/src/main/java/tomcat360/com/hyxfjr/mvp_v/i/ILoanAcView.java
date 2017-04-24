package tomcat360.com.hyxfjr.mvp_v.i;

/**
 * Created by Administrator on 2017/4/15 0015.
 */

public interface ILoanAcView {
    void showDialog();
    void hideDialog();
    void showRepaymentDetails();

    void intoPassword();

    boolean isAgree();
}
