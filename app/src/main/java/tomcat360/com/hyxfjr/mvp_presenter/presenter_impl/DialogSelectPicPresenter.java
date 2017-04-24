package tomcat360.com.hyxfjr.mvp_presenter.presenter_impl;

import tomcat360.com.hyxfjr.mvp_m.model_impl.DialogSelectPicModelImpl;
import tomcat360.com.hyxfjr.mvp_m.model_interface.IDialogSelectPicModel;
import tomcat360.com.hyxfjr.mvp_v.i.IDialogSelectPicView;

/**
 * Created by Administrator on 2017/4/16 0016.
 */

public class DialogSelectPicPresenter {

    private IDialogSelectPicModel model;
    private IDialogSelectPicView view;

    public DialogSelectPicPresenter(IDialogSelectPicView view) {
        this.view = view;
        model = new DialogSelectPicModelImpl();
    }

    public void takePic() {
        view.checkCameraPermission();
    }

    public void selectPicBySD() {
        view.checkSDPermission();
    }
}
