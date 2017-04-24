package tomcat360.com.hyxfjr.v.view_impl.activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

import butterknife.ButterKnife;
import tomcat360.com.hyxfjr.R;
import util.StrUtils;

public abstract class BaseActivity extends AppCompatActivity {

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (isFull()) {
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                    WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }
        if (isSteep() && Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            WindowManager.LayoutParams localLayoutParams = getWindow().getAttributes();
            //设置状态栏透明
            localLayoutParams.flags = (WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS | localLayoutParams.flags);
           /* Window window = getWindow();
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);*/
        }
        setContentView(getLayoutId());
        ButterKnife.bind(this);
        initTitle();
        initView();
    }

    //设置全屏显示
    protected boolean isFull() {
        return false;
    }

    //设置沉浸式
    protected boolean isSteep() {
        return true;
    }

    protected void initToolbar(String title) {
        toolbar = (Toolbar) findViewById(R.id.base_toolbar);
        if (toolbar == null) {
            return;
        }
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

    public Toolbar getToolbar() {
        return toolbar;
    }

    @Override
    protected void onResume() {
        super.onResume();
        initData();
    }


    @Override
    public void finish() {
        super.finish();
//		if (android.os.Build.VERSION.SDK_INT >= 5) {
//			overridePendingTransition(
//					R.anim.translate_between_interface_left_in,
//					R.anim.translate_between_interface_right_out);
//		}
    }

    @Override
    public void startActivity(Intent intent) {
        super.startActivity(intent);
//		if (android.os.Build.VERSION.SDK_INT >= 5) {
//			overridePendingTransition(
//					R.anim.zoomin,
//					R.anim.zoomout);
//		}
    }

    // 获取布局id
    public abstract int getLayoutId();

    /**
     * 0
     * 初始化数据
     */
    public abstract void initData();

    /**
     * 初始化视图
     */
    public abstract void initView();

    /**
     * 初始化标题
     */
    public abstract void initTitle();


    /**
     * 当ui元素都不可见时，如切换到另一个app，进行资源释放操作
     */
    @Override
    public void onTrimMemory(int level) {
        super.onTrimMemory(level);
        switch (level) {
            case TRIM_MEMORY_UI_HIDDEN:
                // 进行资源释放操作
                break;
        }
    }

    public void showMessage(String str) {
        if (!StrUtils.isEmpty(str)) {
            Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
        }


    }

    private ProgressDialog progressDialog;

    public void showProgress(int messageResId) {
        showProgress(getString(messageResId));
    }

    public void showProgress(String message) {
        showProgress(message, false);
    }

    public void showProgress(String message, boolean cancelable) {
        try {
            if (progressDialog == null) {
                progressDialog = new ProgressDialog(this);
                progressDialog.setMessage(message);
                progressDialog.setCancelable(cancelable);
                progressDialog.show();
            } else {
                progressDialog.setMessage(message);
                progressDialog.setCancelable(cancelable);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void hideProgress() {
        if (progressDialog != null) {
            try {
                progressDialog.dismiss();
                progressDialog = null;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 字体大小不受系统影响
     *
     * @return
     */
    @Override
    public Resources getResources() {
        Resources res = super.getResources();
        Configuration config = new Configuration();
        config.setToDefaults();
        res.updateConfiguration(config, res.getDisplayMetrics());
        return res;
    }


}
