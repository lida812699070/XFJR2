package tomcat360.com.hyxfjr.v.view_impl.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import java.util.ArrayList;

import butterknife.Bind;
import tomcat360.com.hyxfjr.R;
import tomcat360.com.hyxfjr.model.adapter.MyFragmentPagerAdapter;
import tomcat360.com.hyxfjr.v.view_impl.fragment.FragmentApplicationRecordFragment;
import tomcat360.com.hyxfjr.view.MyToolbar;

public class ApplicationsRecordActivity extends BaseActivity {

    @Bind(R.id.base_toolbar)
    MyToolbar baseToolbar;
    @Bind(R.id.sliding_tabs)
    TabLayout slidingTabs;
    @Bind(R.id.viewpager)
    ViewPager viewpager;
    private MyFragmentPagerAdapter pagerAdapter;

    @Override
    public int getLayoutId() {
        return R.layout.activity_applications_record;
    }

    @Override
    public void initData() {

    }

    @Override
    public void initView() {
        initToolbar("申请记录");
        ArrayList<Fragment> fragments = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            fragments.add(new FragmentApplicationRecordFragment());
        }
        String[] titles = {"全部", "成功", "失败"};

        pagerAdapter = new MyFragmentPagerAdapter(getSupportFragmentManager(), this, fragments, titles);
        viewpager.setAdapter(pagerAdapter);
        viewpager.setOffscreenPageLimit(3);
        slidingTabs.setupWithViewPager(viewpager);
    }

    @Override
    public void initTitle() {

    }

}
