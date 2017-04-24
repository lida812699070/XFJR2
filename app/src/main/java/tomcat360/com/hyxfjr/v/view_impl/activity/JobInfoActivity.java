package tomcat360.com.hyxfjr.v.view_impl.activity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.OnClick;
import tomcat360.com.hyxfjr.R;
import tomcat360.com.hyxfjr.view.MyToolbar;
import tomcat360.com.hyxfjr.view.mydialog.ProvinceDialogUtils;

public class JobInfoActivity extends BaseActivity {


    @Bind(R.id.base_toolbar)
    MyToolbar baseToolbar;
    @Bind(R.id.tv_job_location)
    TextView tvJobLocation;
    @Bind(R.id.et_address_detail)
    EditText etAddressDetail;
    @Bind(R.id.btn_save)
    Button btnSave;

    @Override
    public int getLayoutId() {
        return R.layout.activity_job_info;
    }

    @Override
    public void initData() {

    }

    @Override
    public void initView() {
        initToolbar("职业信息");
    }

    @Override
    public void initTitle() {

    }

    @OnClick({R.id.tv_job_location})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_job_location:
                ProvinceDialogUtils.selectAddress(this, tvJobLocation);
                break;
        }
    }


}
