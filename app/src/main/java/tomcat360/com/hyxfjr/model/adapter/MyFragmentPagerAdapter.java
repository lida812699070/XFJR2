package tomcat360.com.hyxfjr.model.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import java.util.List;

/**
 * Created by Administrator on 2015/7/30.
 */
public class MyFragmentPagerAdapter extends android.support.v4.app.FragmentPagerAdapter {

    private String[] tabTitles;
    private Context context;
    private List<Fragment> fragmentList;

    public MyFragmentPagerAdapter(FragmentManager fm, Context context,
                                  List<Fragment> fragmentList,
                                  String[] tabTitles) {
        super(fm);
        this.context = context;
        this.fragmentList = fragmentList;
        this.tabTitles = tabTitles;
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitles[position];
    }
}