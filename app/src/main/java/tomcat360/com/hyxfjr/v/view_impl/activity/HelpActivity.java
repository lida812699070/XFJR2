package tomcat360.com.hyxfjr.v.view_impl.activity;

import android.content.Intent;
import android.view.View;
import android.widget.RelativeLayout;

import butterknife.Bind;
import butterknife.OnClick;
import tomcat360.com.hyxfjr.R;
import tomcat360.com.hyxfjr.view.MyToolbar;

public class HelpActivity extends BaseActivity {


    @Bind(R.id.base_toolbar)
    MyToolbar baseToolbar;
    @Bind(R.id.rl_phone)
    RelativeLayout rlPhone;
    @Bind(R.id.rl_say)
    RelativeLayout rlSay;

    @Override
    public int getLayoutId() {
        return R.layout.activity_help;
    }

    @OnClick({R.id.rl_phone, R.id.rl_say})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.rl_phone://拨打客户电话
                startActivity(new Intent(this,CallPhoneActivity.class));
                break;
            case R.id.rl_say://在线留言
                startActivity(new Intent(this,SayMessageActivity.class));
                break;
            default:
                break;
        }
    }

    @Override
    public void initData() {

    }

    @Override
    public void initView() {
        initToolbar("帮助与留言");
    }

    @Override
    public void initTitle() {

    }

}
