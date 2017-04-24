package tomcat360.com.hyxfjr.mvp_presenter.presenter_impl;

import tomcat360.com.hyxfjr.mvp_m.model_impl.DialogCheck1Model;
import tomcat360.com.hyxfjr.mvp_m.model_interface.IDialogCheck1Model;
import tomcat360.com.hyxfjr.mvp_v.i.IDialogCheck1View;

/**
 * Created by Administrator on 2017/4/18 0018.
 */

public class DialogCheckPresenter {

    private IDialogCheck1Model model;
    private IDialogCheck1View view;

    public DialogCheckPresenter(IDialogCheck1View view) {
        this.view = view;
        model=new DialogCheck1Model();
    }

    public void intoNext() {
        view.intoNext();
    }

    public void getCheckCode(String mobile) {
        if (model.checkIsmobile(mobile)){
            view.getCheckCode();
        }else {
            view.showErrorMobileNumber();
        }

    }
}
