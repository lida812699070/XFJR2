package tomcat360.com.hyxfjr.v.view_impl.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import java.util.ArrayList;

import butterknife.Bind;
import tomcat360.com.hyxfjr.R;
import tomcat360.com.hyxfjr.model.adapter.MyFragmentPagerAdapter;
import tomcat360.com.hyxfjr.v.view_impl.fragment.FragmentRedPacketFragment;

public class MyRedPacketActivity extends BaseActivity {

    @Bind(R.id.sliding_tabs)
    TabLayout slidingTabs;
    @Bind(R.id.viewpager)
    ViewPager viewpager;
    private MyFragmentPagerAdapter pagerAdapter;

    @Override
    public int getLayoutId() {
        return R.layout.activity_my_red_packet;
    }

    @Override
    public void initData() {

    }

    @Override
    public void initView() {
        initToolbar("我的红包");
        ArrayList<Fragment> fragments = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            fragments.add(new FragmentRedPacketFragment());
        }
        String[] titles = {"全部", "可用", "不可用"};
        pagerAdapter = new MyFragmentPagerAdapter(getSupportFragmentManager(), this, fragments, titles);
        viewpager.setAdapter(pagerAdapter);
        viewpager.setOffscreenPageLimit(3);
        slidingTabs.setupWithViewPager(viewpager);
    }

    @Override
    public void initTitle() {

    }
}
