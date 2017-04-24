package tomcat360.com.hyxfjr.v.view_impl.activity;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.OnClick;
import tomcat360.com.hyxfjr.R;
import tomcat360.com.hyxfjr.mvp_presenter.presenter_impl.MyDataPresenter;
import tomcat360.com.hyxfjr.mvp_v.i.IMyDataAcView;
import tomcat360.com.hyxfjr.view.MyToolbar;
import util.ButtonClickUtil;

public class MyDataActivity extends BaseActivity implements IMyDataAcView {


    @Bind(R.id.base_toolbar)
    MyToolbar baseToolbar;
    @Bind(R.id.iv_base_message)
    ImageView ivBaseMessage;
    @Bind(R.id.tv_base_message_title)
    TextView tvBaseMessageTitle;
    @Bind(R.id.tv_base_message_content)
    TextView tvBaseMessageContent;
    @Bind(R.id.tv_base_message_state)
    TextView tvBaseMessageState;
    @Bind(R.id.ll_base_message)
    LinearLayout llBaseMessage;
    @Bind(R.id.tv_job_message_state)
    TextView tvJobMessageState;
    @Bind(R.id.ll_job_message)
    LinearLayout llJobMessage;
    @Bind(R.id.tv_house_message_state)
    TextView tvHouseMessageState;
    @Bind(R.id.ll_house_message)
    LinearLayout llHouseMessage;
    @Bind(R.id.tv_car_message_state)
    TextView tvCarMessageState;
    @Bind(R.id.ll_car_message)
    LinearLayout llCarMessage;
    @Bind(R.id.ll_house_money)
    LinearLayout llHouseMoney;
    @Bind(R.id.ll_other_message)
    LinearLayout llOtherMessage;
    @Bind(R.id.btn_submit)
    Button btnSubmit;
    private MyDataPresenter presenter;

    @Override
    public int getLayoutId() {
        return R.layout.activity_my_data;
    }

    @Override
    public void initData() {

    }

    @Override
    public void initView() {
        initToolbar("我的资料");
        presenter = new MyDataPresenter(this);
    }

    @Override
    public void initTitle() {

    }

    @OnClick({R.id.ll_base_message, R.id.ll_job_message, R.id.ll_house_message,
            R.id.ll_car_message, R.id.ll_house_money, R.id.ll_other_message})
    public void onClick(View view) {
        if (ButtonClickUtil.isFastDoubleClick()) {
            return;
        }
        switch (view.getId()) {
            case R.id.ll_base_message://基本信息
                presenter.intoBaseMessage();
                break;
            case R.id.ll_job_message://职业信息
                presenter.intoJobMessage();
                break;
            case R.id.ll_house_message://房产信息
                presenter.intoHouseMessage();
                break;
            case R.id.ll_car_message://车产信息
                presenter.intoCarMessage();
                break;
            case R.id.ll_house_money://社保公积金
                presenter.intoHouseMoney();
                break;
            case R.id.ll_other_message://其他信息
                presenter.intoOtherMessage();
                break;
            default:
                break;
        }
    }


    @Override
    public void intoBaseMessage() {
        startActivity(new Intent(this, IdentityAuthenticationActivity.class));
    }

    @Override
    public void intoJobMessage() {
        startActivity(new Intent(this, JobInfoActivity.class));
    }

    @Override
    public void intoHouseMessage() {
        startActivity(new Intent(this, HouseMessageActivity.class));
    }

    @Override
    public void intoCarMessage() {
        startActivity(new Intent(this, CarMessageActivity.class));
    }

    @Override
    public void intoHouseMoney() {
        startActivity(new Intent(this, SocialSecurityActivity.class));
    }

    @Override
    public void intoOtherMessage() {
        startActivity(new Intent(this, OtherAssetActivity.class));
    }
}
