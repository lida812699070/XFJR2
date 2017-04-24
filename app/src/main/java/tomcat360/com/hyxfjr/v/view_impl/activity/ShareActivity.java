package tomcat360.com.hyxfjr.v.view_impl.activity;

import android.content.Intent;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import tomcat360.com.hyxfjr.R;

public class ShareActivity extends BaseActivity {


    private Toolbar toolbar;

    @Override
    public int getLayoutId() {
        return R.layout.activity_share;
    }

    @Override
    public void initData() {

    }

    @Override
    public void initView() {
        initToolbar("分享");

    }

    protected void initToolbar(String title) {
        toolbar = (Toolbar) findViewById(R.id.base_toolbar);
        if (toolbar == null) {
            return;
        }
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                startActivity(new Intent(ShareActivity.this, ShareBottmDialog.class));
                return true;
            }
        });
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.back);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        toolbar.setTitle(title);
        toolbar.setTitleTextColor(getResources().getColor(R.color.white));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.share_item:
                startActivity(new Intent(ShareActivity.this, ShareBottmDialog.class));
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.share_toolbar_menu, menu);
        return true;
    }

    @Override
    public void initTitle() {

    }
}
