package tomcat360.com.hyxfjr.mvp_presenter.presenter_impl;

import tomcat360.com.hyxfjr.mvp_m.model_impl.LoanAcModel;
import tomcat360.com.hyxfjr.mvp_m.model_interface.ILoanAcModel;
import tomcat360.com.hyxfjr.mvp_v.i.ILoanAcView;

/**
 * Created by Administrator on 2017/4/15 0015.
 */

public class LoadAcPresenter {
    private ILoanAcModel loanAcModel;
    private ILoanAcView view;

    public LoadAcPresenter(ILoanAcView loanAcView) {
        this.view = loanAcView;
        loanAcModel = new LoanAcModel();
    }


    public void showRepaymentFetails() {
        view.showRepaymentDetails();
    }

    public void intoPassword() {
        if (view.isAgree()) {
            view.intoPassword();
        }
    }
}
