package tomcat360.com.hyxfjr.v.view_impl.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.DownloadListener;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.io.UnsupportedEncodingException;

import butterknife.Bind;
import butterknife.ButterKnife;
import tomcat360.com.hyxfjr.R;
import tomcat360.com.hyxfjr.mvp_m.G;
import tomcat360.com.hyxfjr.mvp_m.ParamNameConstant;
import util.SPUtils;
import util.StrUtils;

public class HtmlPostActivity extends BaseActivity implements DownloadListener {

    @Bind(R.id.webview)
    WebView webview;
    @Bind(R.id.progress_bar)
    ProgressBar progressBar;
    @Bind(R.id.iv_back)
    ImageView ivBack;
    @Bind(R.id.webview_title)
    TextView title;
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    private String hTitle;
    private boolean allowBack;// true支持返回上一页面

    @Override
    public int getLayoutId() {
        return R.layout.activity_html;
    }

    @Override
    public void initData() {

    }

    @Override
    public void initView() {
        Intent intent = this.getIntent();
        String url = intent.getStringExtra(ParamNameConstant.PARAMETER_NAME_URL);
        hTitle = intent.getStringExtra(ParamNameConstant.PARAMETER_NAME_TITLE);
        String data = intent.getStringExtra(ParamNameConstant.PARAMETER_NAME_DATA);
        allowBack = intent.getBooleanExtra(ParamNameConstant.PARAMETER_NAME_ALLOW_BACK, false);
        this.webview.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        this.webview.getSettings().setUseWideViewPort(true);
        this.webview.getSettings().setJavaScriptEnabled(true);
        this.webview.getSettings().setBuiltInZoomControls(true);
        this.webview.getSettings().setSupportZoom(true); // 支持缩放
        this.webview.getSettings().setDisplayZoomControls(false);
        // 自适应屏幕
        this.webview.getSettings().setDefaultTextEncodingName("UTF-8");
        this.webview.getSettings().setLayoutAlgorithm(
                WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        this.webview.getSettings().setLoadWithOverviewMode(true);

        this.webview.setWebViewClient(new MyWebViewClient());
        this.webview.setWebChromeClient(new MyWebChromeClient());
        this.webview.setDownloadListener(this);
        this.webview.setHorizontalScrollBarEnabled(true);
        this.webview.setVerticalFadingEdgeEnabled(false);
        this.webview.setVerticalScrollBarEnabled(false);

        initTitle();
        if (hTitle != null) {
            title.setText(hTitle);
        }
        // 把登录的sessionId注入webview cookie，保持同一会话
        CookieSyncManager.createInstance(this);
        CookieManager cookieManager = CookieManager.getInstance();
        cookieManager.removeSessionCookie();
        String cookieString = "JSESSIONID=" + (String) SPUtils.get(this, ParamNameConstant.SESSION_ID, "");
        cookieManager.setCookie(url, cookieString);
        CookieSyncManager.getInstance().sync();
        // post提交

        if (data != null) {
            try {
                webview.postUrl(url, data.getBytes("UTF-8"));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        } else {
            webview.loadUrl(url);
        }
    }

    @Override
    public void initTitle() {
        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goBack();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.html, menu);
        return true;
    }

    /**
     * 返回处理
     */
    private void goBack() {
        if (allowBack && webview.canGoBack()) {//回退上一层
            webview.goBack();
        } else {//关闭页面
            this.finish();
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        // TODO Auto-generated method stub
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            this.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    protected void onDestroy() {
        // TODO Auto-generated method stub
        super.onDestroy();
    }

    private void openWithSystemExplorer(String url) {
        if (StrUtils.notEmpty(url)) {
            try {
                Uri uri = Uri.parse(url);
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void onDownloadStart(String url, String userAgent, String contentDisposition, String mimetype, long contentLength) {
        if (url != null)
            openWithSystemExplorer(url);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    private class MyWebViewClient extends WebViewClient {

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
        }

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            if (StrUtils.notEmpty(url)) {
                if (url.contains(G.URL_GO_CENTER)) {// 前往个人中心
                    //TODO
                    /*getOperation().addParameter(MainActivity.PARAMETER_TABID, MainActivity.TAB_SELFCENTER);
                    getOperation().forward(MainActivity.class);*/
                    finish();
                    return false;
                } else if (url.contains(G.URL_CLOSE)) {// 关闭当前页面
                    finish();
                    return false;
                }
                webview.loadUrl(url);//正常加载
                return true;
            }
            return false;
        }

        @Override
        public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
            if (handler != null) {
                // handler.cancel();// Android默认的处理方式
                handler.proceed();// 接受所有网站的证书
                // handleMessage(Message msg); //进行其他处理
            }
        }

        @Override
        public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
            super.onReceivedError(view, errorCode, description, failingUrl);
        }
    }

    private class MyWebChromeClient extends WebChromeClient {
        @Override
        public void onReceivedTitle(WebView view, String title) {
            super.onReceivedTitle(view, title);
            if (StrUtils.isEmpty(hTitle)) {
                HtmlPostActivity.this.title.setText(StrUtils.valueOf(title));
            }

        }

        @Override
        public void onProgressChanged(WebView view, int newProgress) {
            super.onProgressChanged(view, newProgress);
            if (progressBar != null) {
                progressBar.setProgress(newProgress);
                if (newProgress >= 99) {
                    progressBar.setVisibility(View.GONE);
                }
            }
        }
    }
}
