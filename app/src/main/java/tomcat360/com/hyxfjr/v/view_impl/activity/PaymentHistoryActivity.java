package tomcat360.com.hyxfjr.v.view_impl.activity;

import android.app.Activity;
import android.content.Context;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.DisplayMetrics;
import android.util.TypedValue;

import java.util.ArrayList;

import butterknife.Bind;
import tomcat360.com.hyxfjr.R;
import tomcat360.com.hyxfjr.model.adapter.MyFragmentPagerAdapter;
import tomcat360.com.hyxfjr.v.view_impl.fragment.FragmentPaymentHistoryNotPayOffFragment;
import tomcat360.com.hyxfjr.view.TabLayoutUtils;

public class PaymentHistoryActivity extends BaseActivity {

    @Bind(R.id.sliding_tabs)
    TabLayout tabLayout;
    @Bind(R.id.viewpager)
    ViewPager viewPager;

    private static int TAB_MARGIN_DIP = 15;

    @Override
    public int getLayoutId() {
        return R.layout.activity_payment_history;
    }

    @Override
    public void initData() {

    }

    @Override
    public void initView() {
        initToolbar("还款记录");
        ArrayList<Fragment> fragments = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            fragments.add(new FragmentPaymentHistoryNotPayOffFragment());
        }
        viewPager.setOffscreenPageLimit(fragments.size());
        String[] tabTitles = new String[]{"未还清", "已还清", "逾期"};
        viewPager.setAdapter(new MyFragmentPagerAdapter(getSupportFragmentManager(), this, fragments, tabTitles));
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setTabMode(TabLayout.MODE_FIXED);
        TabLayoutUtils.setIndicatorMargin(this, tabLayout, TAB_MARGIN_DIP, TAB_MARGIN_DIP);
    }

    @Override
    public void initTitle() {

    }


    public static DisplayMetrics getDisplayMetrics(Context context) {
        DisplayMetrics metric = new DisplayMetrics();
        ((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(metric);
        return metric;
    }

    public static float getPXfromDP(float value, Context context) {
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, value,
                context.getResources().getDisplayMetrics());
    }

}
