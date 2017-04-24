package tomcat360.com.hyxfjr.v.view_impl.activity;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.zhy.adapter.recyclerview.CommonAdapter;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import tomcat360.com.hyxfjr.R;
import tomcat360.com.hyxfjr.view.DividerItemDecoration;
import tomcat360.com.hyxfjr.view.MyToolbar;

public class TestActivity extends AppCompatActivity {

    @Bind(R.id.rv)
    RecyclerView rv;
    @Bind(R.id.base_toolbar)
    MyToolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);
        }
        setContentView(R.layout.activity_test);
        ButterKnife.bind(this);
        toolbar.setNavigationIcon(R.drawable.back);
        toolbar.setTitle("wwwww");
        toolbar.setTitleTextColor(getResources().getColor(R.color.white));
        /*toolbar.setTitle("haha");
        toolbar.setTitleTextColor(getResources().getColor(R.color.white));
        toolbar.setNavigationIcon(R.drawable.back);*/
        ArrayList<String> strings = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            strings.add("1");
        }
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL_LIST));
        rv.setAdapter(new CommonAdapter<String>(this, R.layout.item_load_dialog, strings) {
            @Override
            protected void convert(ViewHolder holder, String s, int position) {
                holder.setText(R.id.item_load_dialog_sum, s);
            }
        });
    }
}
