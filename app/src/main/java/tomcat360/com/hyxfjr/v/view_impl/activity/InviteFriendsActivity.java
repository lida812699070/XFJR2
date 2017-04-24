package tomcat360.com.hyxfjr.v.view_impl.activity;

import android.os.Bundle;

import tomcat360.com.hyxfjr.R;

public class InviteFriendsActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_invite_friends);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_invite_friends;
    }

    @Override
    public void initData() {

    }

    @Override
    public void initView() {
        initToolbar("邀请好友");
    }

    @Override
    public void initTitle() {

    }
}
