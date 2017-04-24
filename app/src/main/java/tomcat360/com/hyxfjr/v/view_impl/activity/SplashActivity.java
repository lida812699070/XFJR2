package tomcat360.com.hyxfjr.v.view_impl.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.util.DisplayMetrics;
import android.view.WindowManager;

import java.io.File;

import tomcat360.com.hyxfjr.R;
import tomcat360.com.hyxfjr.mvp_m.G;
import util.SPUtils;

public class SplashActivity extends BaseActivity {

    private static final long SPLASH_DELAY_MILLIS = 2000;
    private int height;
    private int width;
    private boolean isFirstIn = true;

    @Override
    public int getLayoutId() {
        return R.layout.activity_splash;
    }

    @Override
    public void initData() {

    }

    @Override
    protected boolean isFull() {
        return true;
    }

    @Override
    public void initView() {
        if (!this.isTaskRoot()) { //判断该Activity是不是任务空间的源Activity，“非”也就是说是被系统重新实例化出来
            //如果你就放在launcher Activity中话，这里可以直接return了
            Intent mainIntent = getIntent();
            String action = mainIntent.getAction();
            if (mainIntent.hasCategory(Intent.CATEGORY_LAUNCHER) && action.equals(Intent.ACTION_MAIN)) {
                finish();
                return;//finish()之后该活动会继续执行后面的代码，你可以logCat验证，加return避免可能的exception
            }
        }
        WindowManager wm = (WindowManager) this.getSystemService(WINDOW_SERVICE);
        width = wm.getDefaultDisplay().getWidth();//手机屏幕的宽度
        height = wm.getDefaultDisplay().getHeight();//手机屏幕的高度
        init();
        login();
    }

    private void login() {

    }

    private static final int GOTO_NEXT = 1002;
    @SuppressLint("HandlerLeak")
    private Handler mHandler = new Handler() {
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case GOTO_NEXT:
                    gotoNext();
                    break;
            }
            super.handleMessage(msg);
        }
    };

    private void gotoNext() {
        if (this.isFirstIn) {
            this.goGuide();            //首次打开软件的导航动画
        } else {
            this.goHome();
        }
    }

    private void goHome() {
        Intent intent = new Intent(this, MainActivity.class);
        this.startActivity(intent);
        this.finish();
    }

    private void goGuide() {
        Intent intent = new Intent(this, GuideActivity.class);
        this.startActivity(intent);
        this.finish();
    }

    private void init() {
        this.isFirstIn = (boolean) SPUtils.get(this, "isFirstIn", true);
        this.mHandler.sendEmptyMessageDelayed(GOTO_NEXT, SPLASH_DELAY_MILLIS);

        //在SD卡下建目录
        String dir = G.getFileRootPath();
        File f = new File(dir);
        if (!f.exists())
            f.mkdir();
        //获取屏幕尺寸
        getScreenSize();
    }

    public void getScreenSize() {
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int W = dm.widthPixels;
        int H = dm.heightPixels;
        SPUtils.put(SplashActivity.this, "screenWidth", "" + W);
        SPUtils.put(SplashActivity.this, "screenHeight", "" + H);
    }

    @Override
    public void initTitle() {

    }
}
