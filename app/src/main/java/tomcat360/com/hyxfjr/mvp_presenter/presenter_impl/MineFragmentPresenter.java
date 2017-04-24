package tomcat360.com.hyxfjr.mvp_presenter.presenter_impl;

import tomcat360.com.hyxfjr.mvp_m.model_interface.IMineFragmentModel;
import tomcat360.com.hyxfjr.mvp_v.i.IMineFragmentView;

/**
 * Created by Administrator on 2017/4/18 0018.
 */

public class MineFragmentPresenter {
    private IMineFragmentModel model;
    private IMineFragmentView view;

    public MineFragmentPresenter(IMineFragmentView view) {
        this.view = view;
    }

    public void intoSetting() {
        view.intoSetting();
    }

    public void intoMyData() {
        view.intoMyData();
    }

    public void intoMyBill() {
        view.intoMyBill();
    }

    public void intoMyDocument() {
        view.intoMyDocument();
    }

    public void intoMyRedPacket() {
        view.intoMyRedPacket();
    }

    public void intoPayMentHistory() {
        view.intoPayMentHistory();
    }

    public void intoApplicationsRecord() {
        view.intoApplicationsRecord();
    }

    public void intoShareFriends() {
        view.intoShareFriends();
    }

    public void intoInviteFriends() {
        view.intoInviteFriends();
    }

    public void intoMyMessage() {
        view.intoMyMessage();
    }

    public void intoHelp() {
        view.intoHelp();
    }
}
