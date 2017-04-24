package tomcat360.com.hyxfjr.v.view_impl.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import tomcat360.com.hyxfjr.R;

public class CallPhoneActivity extends AppCompatActivity {

    @Bind(R.id.cancel)
    TextView cancel;
    @Bind(R.id.call)
    TextView call;
    @Bind(R.id.activity_call_phone)
    RelativeLayout activityCallPhone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call_phone);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.cancel, R.id.call, R.id.activity_call_phone})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.call:
                callPhone();
                finish();
                break;
            case R.id.cancel://取消
            case R.id.activity_call_phone:
                finish();
                break;
        }
    }

    private void callPhone() {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        Uri data = Uri.parse("tel:" + "15067080345");
        intent.setData(data);
        startActivity(intent);
    }
}
