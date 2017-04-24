package tomcat360.com.hyxfjr.v.view_impl.activity;


import android.content.Intent;
import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.jiongbull.jlog.JLog;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.io.File;

import butterknife.Bind;
import butterknife.OnClick;
import tomcat360.com.hyxfjr.R;
import tomcat360.com.hyxfjr.mvp_presenter.presenter_impl.SettingAcPresenter;
import tomcat360.com.hyxfjr.mvp_v.i.ISettingAcView;
import tomcat360.com.hyxfjr.view.MyToolbar;
import tomcat360.com.hyxfjr.view.myview.CircleImageView;
import tomcat360.com.hyxfjr.view.myview.SettingItemView;

public class SettingActivity extends BaseActivity implements ISettingAcView {


    @Bind(R.id.base_toolbar)
    MyToolbar baseToolbar;
    @Bind(R.id.title)
    TextView title;
    @Bind(R.id.setting_head_right_iv)
    ImageView settingHeadRightIv;
    @Bind(R.id.iv_head)
    CircleImageView ivHead;
    @Bind(R.id.setting_head_rl)
    RelativeLayout settingHeadRl;
    @Bind(R.id.setting_mobile_rl)
    RelativeLayout settingMobileRl;
    @Bind(R.id.reset_password)
    SettingItemView resetPassword;
    @Bind(R.id.reset_gesture_password)
    SettingItemView resetGesturePassword;
    @Bind(R.id.bank_card_management)
    SettingItemView bankCardManagement;
    @Bind(R.id.shipping_address_management)
    SettingItemView shippingAddressManagement;
    @Bind(R.id.follow_wx)
    SettingItemView followWx;
    @Bind(R.id.about)
    SettingItemView about;
    @Bind(R.id.cache_right_iv)
    ImageView cacheRightIv;
    @Bind(R.id.setting_cache_value)
    TextView settingCacheValue;
    @Bind(R.id.setting_clear_cache_rl)
    RelativeLayout settingClearCacheRl;
    @Bind(R.id.service_agreement)
    SettingItemView serviceAgreement;
    @Bind(R.id.my_quota_contract)
    SettingItemView myQuotaContract;
    private File imageFile;
    private SettingAcPresenter presenter;

    @Override
    public int getLayoutId() {
        return R.layout.activity_setting;
    }

    @Override
    public void initData() {

    }

    @Override
    public void initView() {
        EventBus.getDefault().register(this);
        presenter = new SettingAcPresenter(this);
        initToolbar("设置");
    }

    @Override
    protected void onStart() {
        super.onStart();

    }

    @Override
    public void initTitle() {

    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(Bitmap bitmap) {//收到剪切后的图片
        JLog.e("收到图片");
        if (bitmap == null) {
            Toast.makeText(this, "无法读取图片", Toast.LENGTH_SHORT).show();
            return;
        }
        ivHead.setImageBitmap(bitmap);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @OnClick({R.id.setting_head_rl, R.id.setting_mobile_rl, R.id.reset_password,
            R.id.bank_card_management, R.id.shipping_address_management, R.id.reset_gesture_password})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.setting_head_rl://设置头像
                startActivity(new Intent(this, DialogSelectPic.class));
                break;
            case R.id.setting_mobile_rl://绑定手机
                presenter.intoBindMobile();
                break;
            case R.id.reset_password://修改密码
                presenter.intoResetPassword();
                break;
            case R.id.bank_card_management://银行卡管理
                presenter.intoBankCardManage();
                break;
            case R.id.shipping_address_management://收货人地址管理
                presenter.intoAddressManagement();
                break;
            case R.id.reset_gesture_password://手势密码
                presenter.intoGesturePassword();
                break;
            default:
                break;
        }
    }

    @Override
    public void intoResetPassword() {
        startActivity(new Intent(this, ResetPasswordActivity.class));
    }

    @Override
    public void intoBankCardManage() {
        startActivity(new Intent(this, BankCardManageActivity.class));
    }

    @Override
    public void intoAddressManage() {
        startActivity(new Intent(this, ShipAddressManageActivity.class));
    }

    @Override
    public void intoBindMobile() {
        startActivity(new Intent(this, BindMobilActivity.class));
    }


    @Override
    public void intoAddressManagement() {
        startActivity(new Intent(this, ShipAddressManageActivity.class));
    }

    @Override
    public void intoGesturePassword() {
        startActivity(new Intent(this, GuestActivity.class));
    }


}
