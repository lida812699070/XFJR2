package tomcat360.com.hyxfjr.v.view_impl.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import tomcat360.com.hyxfjr.R;
import tomcat360.com.hyxfjr.mvp_presenter.presenter_impl.MineFragmentPresenter;
import tomcat360.com.hyxfjr.mvp_v.i.IMineFragmentView;
import tomcat360.com.hyxfjr.my_utils.AntiShake;
import tomcat360.com.hyxfjr.v.view_impl.activity.ApplicationsRecordActivity;
import tomcat360.com.hyxfjr.v.view_impl.activity.BillActivity;
import tomcat360.com.hyxfjr.v.view_impl.activity.HelpActivity;
import tomcat360.com.hyxfjr.v.view_impl.activity.InviteFriendsActivity;
import tomcat360.com.hyxfjr.v.view_impl.activity.MyDataActivity;
import tomcat360.com.hyxfjr.v.view_impl.activity.MyMessageListActivity;
import tomcat360.com.hyxfjr.v.view_impl.activity.MyRedPacketActivity;
import tomcat360.com.hyxfjr.v.view_impl.activity.PaymentHistoryActivity;
import tomcat360.com.hyxfjr.v.view_impl.activity.SettingActivity;
import tomcat360.com.hyxfjr.v.view_impl.activity.ShareActivity;
import tomcat360.com.hyxfjr.view.myview.CircleImageView;
import tomcat360.com.hyxfjr.view.myview.MineItemView;


public class FragmentMineFragment extends BaseFragment implements SwipeRefreshLayout.OnRefreshListener, IMineFragmentView {


    @Bind(R.id.iv_setting)
    ImageView ivSetting;
    @Bind(R.id.iv_head)
    CircleImageView ivHead;
    @Bind(R.id.tv_name)
    TextView tvName;
    @Bind(R.id.tv_mobile)
    TextView tvMobile;
    @Bind(R.id.my_message)
    TextView myMessage;
    @Bind(R.id.tv_this_month_repayment)
    TextView tvThisMonthRepayment;
    @Bind(R.id.tv_can_use_money)
    TextView tvCanUseMoney;
    @Bind(R.id.my_money)
    TextView myMoney;
    @Bind(R.id.tv_my_bill)
    MineItemView tvMyBill;
    @Bind(R.id.tv_my_document)
    MineItemView tvMyDocument;
    @Bind(R.id.tv_red_packet)
    MineItemView tvRedPacket;
    @Bind(R.id.tv_payment_history)
    MineItemView tvPaymentHistory;
    @Bind(R.id.tv_applications_record)
    MineItemView tvApplicationsRecord;
    @Bind(R.id.tv_share_friends)
    MineItemView tvShareFriends;
    @Bind(R.id.tv_invite_friends)
    MineItemView tvInviteFriends;
    @Bind(R.id.tv_my_message)
    MineItemView tvMyMessage;
    @Bind(R.id.tv_help)
    MineItemView tvHelp;
    @Bind(R.id.swipeRefreshLayout)
    SwipeRefreshLayout swipeRefreshLayout;
    private MineFragmentPresenter presenter;
    private AntiShake util;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_mine, null);
        ButterKnife.bind(this, inflate);
        return inflate;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView();
    }

    private void initView() {
        presenter = new MineFragmentPresenter(this);
        util = new AntiShake();
        swipeRefreshLayout.setColorSchemeColors(getResources().getColor(R.color.guestPaint_color_wrong));
        swipeRefreshLayout.setOnRefreshListener(this);
    }

    @OnClick({R.id.iv_setting, R.id.my_message, R.id.tv_my_bill,
            R.id.tv_my_document, R.id.tv_red_packet, R.id.tv_payment_history,
            R.id.tv_applications_record, R.id.tv_share_friends, R.id.tv_invite_friends,
            R.id.tv_my_message,R.id.tv_help})
    public void onClick(View view) {
        if (util.check()) return;
        switch (view.getId()) {
            case R.id.iv_setting://设置
                presenter.intoSetting();
                break;
            case R.id.my_message://我的资料
                presenter.intoMyData();
                break;
            case R.id.tv_my_bill://我的账单
                presenter.intoMyBill();
                break;
            case R.id.tv_my_document://我的订单
                presenter.intoMyDocument();
                break;
            case R.id.tv_red_packet://我的红包
                presenter.intoMyRedPacket();
                break;
            case R.id.tv_payment_history://还款记录
                presenter.intoPayMentHistory();
                break;
            case R.id.tv_applications_record://申请记录
                presenter.intoApplicationsRecord();
                break;
            case R.id.tv_share_friends://分享好友
                presenter.intoShareFriends();
                break;
            case R.id.tv_invite_friends://邀请好友
                presenter.intoInviteFriends();
                break;
            case R.id.tv_my_message://我的消息
                presenter.intoMyMessage();
                break;
            case R.id.tv_help://帮助与反馈
                presenter.intoHelp();
                break;
            default:
                break;
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @Override
    public void onRefresh() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                swipeRefreshLayout.setRefreshing(false);
            }
        }, 1500);
    }

    @Override
    public void intoSetting() {
        startActivity(new Intent(getActivity(), SettingActivity.class));
    }

    @Override
    public void intoMyData() {
        startActivity(new Intent(getActivity(), MyDataActivity.class));
    }

    @Override
    public void intoMyBill() {
        startActivity(new Intent(getActivity(), BillActivity.class));
    }

    @Override
    public void intoMyDocument() {

    }

    @Override
    public void intoMyRedPacket() {
        startActivity(new Intent(getActivity(), MyRedPacketActivity.class));
    }

    @Override
    public void intoPayMentHistory() {
        startActivity(new Intent(getActivity(), PaymentHistoryActivity.class));
    }

    @Override
    public void intoApplicationsRecord() {
        startActivity(new Intent(getActivity(), ApplicationsRecordActivity.class));
    }

    @Override
    public void intoShareFriends() {
        startActivity(new Intent(getActivity(), ShareActivity.class));
    }

    @Override
    public void intoInviteFriends() {
        startActivity(new Intent(getActivity(), InviteFriendsActivity.class));
    }

    @Override
    public void intoMyMessage() {
        startActivity(new Intent(getActivity(), MyMessageListActivity.class));
    }

    @Override
    public void intoHelp() {
        startActivity(new Intent(getActivity(), HelpActivity.class));
    }
}
