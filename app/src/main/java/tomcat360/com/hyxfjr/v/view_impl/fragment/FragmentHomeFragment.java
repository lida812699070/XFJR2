package tomcat360.com.hyxfjr.v.view_impl.fragment;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.tbruyelle.rxpermissions2.RxPermissions;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import tomcat360.com.hyxfjr.R;
import tomcat360.com.hyxfjr.mvp_presenter.presenter_impl.HomeFragmentPresenter;
import tomcat360.com.hyxfjr.mvp_v.i.IHomeFragmentView;
import tomcat360.com.hyxfjr.v.view_impl.activity.ContractNetworkListActivity;
import tomcat360.com.hyxfjr.v.view_impl.activity.DialogLoginCheck1Activity;
import tomcat360.com.hyxfjr.v.view_impl.activity.LoginActivity;
import tomcat360.com.hyxfjr.v.view_impl.activity.MonthBillDetailActivity;
import tomcat360.com.hyxfjr.v.view_impl.activity.MyDataActivity;
import tomcat360.com.hyxfjr.view.myview.CircleImageView;
import util.ButtonClickUtil;


public class FragmentHomeFragment extends BaseFragment implements IHomeFragmentView, SwipeRefreshLayout.OnRefreshListener {

    @Bind(R.id.toolbar_iv_menu)
    ImageView toolbarIvMenu;
    @Bind(R.id.toolbar_icon)
    CircleImageView toolbarIcon;
    @Bind(R.id.toolbar_right)
    ImageView toolbarRight;
    @Bind(R.id.home_title_1)
    TextView homeTitle1;
    @Bind(R.id.home_title_2)
    TextView homeTitle2;
    @Bind(R.id.home_btn_center)
    Button homeBtnCenter;
    @Bind(R.id.home_can_use)
    TextView homeCanUse;
    @Bind(R.id.my_use)
    TextView myUse;
    @Bind(R.id.daily_interst)
    TextView dailyInterst;
    @Bind(R.id.home_center_content_image)
    ImageView homeCenterContentImage;
    @Bind(R.id.application_promotion)
    TextView applicationPromotion;
    @Bind(R.id.home_item_application_promotion)
    CardView homeItemApplicationPromotion;
    @Bind(R.id.quick_repayment)
    TextView quickRepayment;
    @Bind(R.id.home_item_quick_repayment)
    CardView homeItemQuickRepayment;
    @Bind(R.id.preferential_activities)
    TextView preferentialActivities;
    @Bind(R.id.home_item_preferential_activities)
    CardView homeItemPreferentialActivities;
    @Bind(R.id.contract_network)
    TextView contractNetwork;
    @Bind(R.id.home_item_contract_network)
    CardView homeItemContractNetwork;
    @Bind(R.id.ll_toolbar_left)
    LinearLayout llToolbarLeft;
    @Bind(R.id.imageView)
    ImageView imageView;
    @Bind(R.id.swipeRefreshLayout)
    SwipeRefreshLayout swipeRefreshLayout;
    private HomeFragmentPresenter presenter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_home, null);
        ButterKnife.bind(this, inflate);
        return inflate;
    }


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView();
    }

    private void initView() {
        swipeRefreshLayout.setOnRefreshListener(this);
        swipeRefreshLayout.setColorSchemeColors(getResources().getColor(R.color.guestPaint_color_wrong));
        presenter = new HomeFragmentPresenter(this);
    }

    @OnClick({R.id.ll_toolbar_left, R.id.home_btn_center, R.id.home_item_contract_network,
            R.id.home_item_application_promotion, R.id.home_item_quick_repayment, R.id.toolbar_right})
    public void onClick(View view) {
        if (ButtonClickUtil.isFastDoubleClick()) return;
        switch (view.getId()) {
            case R.id.ll_toolbar_left://登陆注册 左上角
                presenter.showLoginDialog();
                break;
            case R.id.home_btn_center://登陆注册 中间
                presenter.putCenterBtn();
                break;
            case R.id.home_item_contract_network://签约网点
                presenter.intoContractNetwork();
                break;
            case R.id.home_item_application_promotion://申请额度  进入我的资料
                presenter.intoMyData();
                break;
            case R.id.home_item_quick_repayment://快速还款
                presenter.intoRePayment();
                break;
            case R.id.toolbar_right://扫描
                presenter.intoScannin();
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
    public void showLoginDialog() {
        startActivity(new Intent(getActivity(), DialogLoginCheck1Activity.class));
    }

    @Override
    public void putCenterBtn() {
        startActivity(new Intent(getActivity(), LoginActivity.class));
    }

    @Override
    public void intoContractNetwork() {
        startActivity(new Intent(getActivity(), ContractNetworkListActivity.class));
    }

    @Override
    public void intoMyData() {
        startActivity(new Intent(getActivity(), MyDataActivity.class));
    }

    @Override
    public void intoRePayment() {
        startActivity(new Intent(getActivity(), MonthBillDetailActivity.class));
    }

    @Override
    public void intoScannin() {
        new RxPermissions(getActivity())
                .request(Manifest.permission.CAMERA,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE)
                .subscribe(new Consumer<Boolean>() {
                    @Override
                    public void accept(@NonNull Boolean aBoolean) throws Exception {
                        if (aBoolean) {
                            Toast.makeText(getActivity(), "有权限了", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(getActivity(), "请到权限设置中同意相关权限", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}
