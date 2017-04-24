package tomcat360.com.hyxfjr.v.view_impl.activity;

import android.graphics.Color;
import android.support.v7.widget.Toolbar;

import tomcat360.com.hyxfjr.R;
import util.StatusBarCompat;

public class MyInfoActivity extends BaseActivity {

    private static final int INVALID_VAL = -1;
    private static final int COLOR_DEFAULT = Color.parseColor("#20000000");
   

    @Override
    public int getLayoutId() {
        return R.layout.activity_my_info;
    }

    @Override
    public void initData() {

    }

    @Override
    public void initView() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.id_toolbar);
        setSupportActionBar(toolbar);
        StatusBarCompat.compat(this);
        StatusBarCompat.compat(this, getResources().getColor(R.color.blank));
    }

    @Override
    public void initTitle() {

    }
}
