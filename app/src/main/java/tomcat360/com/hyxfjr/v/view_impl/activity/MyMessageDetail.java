package tomcat360.com.hyxfjr.v.view_impl.activity;

import android.widget.TextView;

import butterknife.Bind;
import tomcat360.com.hyxfjr.R;
import tomcat360.com.hyxfjr.view.MyToolbar;

public class MyMessageDetail extends BaseActivity {

    @Bind(R.id.base_toolbar)
    MyToolbar baseToolbar;
    @Bind(R.id.tv_date)
    TextView tvDate;
    @Bind(R.id.text_content)
    TextView textContent;

    @Override
    public int getLayoutId() {
        return R.layout.activity_my_message_detail;
    }

    @Override
    public void initData() {

    }

    @Override
    public void initView() {
        initToolbar("我的消息");
    }

    @Override
    public void initTitle() {

    }
}
