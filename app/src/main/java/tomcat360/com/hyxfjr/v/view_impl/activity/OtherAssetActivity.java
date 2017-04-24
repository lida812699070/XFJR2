package tomcat360.com.hyxfjr.v.view_impl.activity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import butterknife.Bind;
import butterknife.OnClick;
import tomcat360.com.hyxfjr.R;
import tomcat360.com.hyxfjr.view.MyToolbar;
import tomcat360.com.hyxfjr.view.mydialog.SelectTimeDialog;

public class OtherAssetActivity extends BaseActivity {

    @Bind(R.id.base_toolbar)
    MyToolbar baseToolbar;
    @Bind(R.id.et_financing_select_time)
    EditText etFinancingSelectTime;
    @Bind(R.id.et_deposit_select_time)
    EditText etDepositSelectTime;
    @Bind(R.id.et_cover_date)
    EditText etCoverDate;
    @Bind(R.id.btn_save)
    Button btnSave;

    @Override
    public int getLayoutId() {
        return R.layout.activity_other_asset;
    }

    @Override
    public void initData() {

    }

    @OnClick({R.id.et_financing_select_time, R.id.et_deposit_select_time, R.id.et_cover_date})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.et_financing_select_time: //理财时间
                SelectTimeDialog.showSelectTimeDialog(this, etFinancingSelectTime);
                break;
            case R.id.et_deposit_select_time://存款时间
                SelectTimeDialog.showSelectTimeDialog(this, etDepositSelectTime);
                break;
            case R.id.et_cover_date://投保时间
                SelectTimeDialog.showSelectTimeDialog(this, etCoverDate);
                break;
        }
    }

    @Override
    public void initView() {
        initToolbar("其他类资产");
    }

    @Override
    public void initTitle() {

    }

}
