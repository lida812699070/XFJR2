package tomcat360.com.hyxfjr.mvp_presenter.presenter_impl;

import tomcat360.com.hyxfjr.mvp_m.model_interface.IMyMessageListModel;
import tomcat360.com.hyxfjr.mvp_v.i.IMyMessageListView;

/**
 * Created by Administrator on 2017/4/19 0019.
 */

public class MyMessagePresenter {
    private IMyMessageListModel model;
    private IMyMessageListView view;

    public MyMessagePresenter(IMyMessageListView view) {
        this.view = view;
    }


    public void editMessage(boolean mIsEditStatus) {
        view.editMessage();
        mIsEditStatus=!mIsEditStatus;
        view.setLlBottomVisable(mIsEditStatus);
        view.setIsEdit(mIsEditStatus);
        isShowCheckBox(mIsEditStatus);
    }

    public void isShowCheckBox(boolean mIsEditStatus) {
        view.isShowCheckBox(mIsEditStatus);
    }

    public void delete() {
        view.delete();
    }

    public void markAll() {
        view.markAll();
    }
}
