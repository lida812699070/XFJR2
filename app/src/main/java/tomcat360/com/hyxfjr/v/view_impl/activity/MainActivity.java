package tomcat360.com.hyxfjr.v.view_impl.activity;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import butterknife.Bind;
import butterknife.OnClick;
import tomcat360.com.hyxfjr.R;
import tomcat360.com.hyxfjr.mvp_m.ParamNameConstant;
import tomcat360.com.hyxfjr.v.view_impl.fragment.BaseFragment;
import tomcat360.com.hyxfjr.v.view_impl.fragment.FragmentDecorationStageFragment;
import tomcat360.com.hyxfjr.v.view_impl.fragment.FragmentHomeFragment;
import tomcat360.com.hyxfjr.v.view_impl.fragment.FragmentMallStageFragment;
import tomcat360.com.hyxfjr.v.view_impl.fragment.FragmentMineFragment;
import util.SPUtils;

public class MainActivity extends BaseActivity {


    @Bind(R.id.gr_main)
    RadioGroup grMain;
    @Bind(R.id.main_fl_content)
    FrameLayout mainFlContent;
    @Bind(R.id.home)
    RadioButton home;
    @Bind(R.id.decorationStage)
    RadioButton decorationStage;
    @Bind(R.id.stagingMall)
    RadioButton StagingMall;
    @Bind(R.id.mine)
    RadioButton mine;
    //当前选中的fragment
    private BaseFragment currFragment;
    private FragmentHomeFragment homeFragment;
    private FragmentDecorationStageFragment decorationStageFragment;
    private FragmentMallStageFragment mallStageFragment;
    private FragmentMineFragment mineFragment;

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }


    @Override
    public void initData() {

    }

    @Override
    public void initView() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        homeFragment = new FragmentHomeFragment();
        transaction.add(R.id.main_fl_content, homeFragment);
        currFragment = homeFragment;
        transaction.show(homeFragment);
        transaction.commit();
        //判断点击的是否是当前选中的fragment 是就不做操作 不是就隐藏之前的  显示被点击的
        grMain.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                switch (i) {
                    case R.id.home://首页
                        if (currFragment == homeFragment) {
                            break;
                        }
                        fragmentTransaction.hide(currFragment);
                        currFragment = homeFragment;
                        break;
                    case R.id.decorationStage://立即用钱
                       /* if (decorationStageFragment == null) {
                            decorationStageFragment = new FragmentDecorationStageFragment();
                            fragmentTransaction.add(R.id.main_fl_content, decorationStageFragment);
                        }
                        if (currFragment == decorationStageFragment) {
                            break;
                        }
                        fragmentTransaction.hide(currFragment);
                        currFragment = decorationStageFragment;*/
                        break;
                    case R.id.stagingMall://邀请返佣
                        if (mallStageFragment == null) {
                            mallStageFragment = new FragmentMallStageFragment();
                            fragmentTransaction.add(R.id.main_fl_content, mallStageFragment);
                        }
                        if (currFragment == mallStageFragment) {
                            break;
                        }
                        fragmentTransaction.hide(currFragment);
                        currFragment = mallStageFragment;
                        break;
                    case R.id.mine://我的
                        if (mineFragment == null) {
                            mineFragment = new FragmentMineFragment();
                            fragmentTransaction.add(R.id.main_fl_content, mineFragment);
                        }
                        if (currFragment == mineFragment) {
                            break;
                        }
                        fragmentTransaction.hide(currFragment);
                        currFragment = mineFragment;
                        break;
                    default:
                        break;
                }
                fragmentTransaction.show(currFragment);
                fragmentTransaction.commitAllowingStateLoss();
            }
        });
        home.performClick();
        //如果设置了手势密码
        if ((boolean) SPUtils.get(this, ParamNameConstant.GUEST_STATUS, false)) {
            Intent intent = new Intent(MainActivity.this,
                    UnlockGesturePasswordActivity.class);
            startActivity(intent);
        }
    }

    @OnClick(R.id.decorationStage)
    public void OnClick(View view) {

        startActivity(new Intent(MainActivity.this, LoanActivity.class));
    }

    @Override
    public void initTitle() {

    }

}
