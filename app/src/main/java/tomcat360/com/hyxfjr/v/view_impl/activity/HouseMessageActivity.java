package tomcat360.com.hyxfjr.v.view_impl.activity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.jiongbull.jlog.JLog;

import butterknife.Bind;
import butterknife.OnClick;
import tomcat360.com.hyxfjr.R;
import tomcat360.com.hyxfjr.v.view_impl.fragment.DatePickerFragment;
import tomcat360.com.hyxfjr.view.MyToolbar;
import tomcat360.com.hyxfjr.view.mydialog.ProvinceDialog;

public class HouseMessageActivity extends BaseActivity {

    @Bind(R.id.base_toolbar)
    MyToolbar baseToolbar;
    @Bind(R.id.et_house_time)
    EditText etHouseTime;
    @Bind(R.id.tv_house_location)
    TextView tvHouseLocation;
    @Bind(R.id.et_house_acreage)
    EditText etHouseAcreage;
    @Bind(R.id.rb_not_mortgage)
    RadioButton rbNotMortgage;
    @Bind(R.id.rb_with_mortgage)
    RadioButton rbWithMortgage;
    @Bind(R.id.rg_mortgage)
    RadioGroup rgMortgage;
    @Bind(R.id.et_mortgage_money)
    EditText etMortgageMoney;
    @Bind(R.id.et_mortgage_number)
    EditText etMortgageNumber;
    @Bind(R.id.ll_with_mortgage)
    LinearLayout llWithMortgage;
    @Bind(R.id.btn_save)
    Button btnSave;
    @Bind(R.id.et_address_detail)
    EditText etAddressDetail;
    @Bind(R.id.et_house_nature)
    EditText etHouseNature;

    @Override
    public int getLayoutId() {
        return R.layout.activity_house_message;
    }

    @Override
    public void initData() {
        rgMortgage.setOnCheckedChangeListener(checkedChangeListener);
    }

    RadioGroup.OnCheckedChangeListener checkedChangeListener = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
            switch (checkedId) {
                case R.id.rb_not_mortgage://无按揭
                    llWithMortgage.animate().scaleY(0);
                    break;
                case R.id.rb_with_mortgage://有按揭
                    llWithMortgage.animate().scaleY(1);
                    break;
            }
        }
    };

    @OnClick({R.id.et_house_time, R.id.tv_house_location, R.id.et_house_nature})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.et_house_time://选择购房时间
                showTimePicker();
                break;
            case R.id.tv_house_location://选择房子位置
                selectAddress();
                break;
            case R.id.et_house_nature://选择房子性质
                break;
            default:
                break;
        }
    }

    //选择时间对话框
    private void showTimePicker() {
        DatePickerFragment datePicker = new DatePickerFragment();
        datePicker.setDateCallBack(new DatePickerFragment.DateCallBack() {
            @Override
            public void getDate(String date) {
                etHouseTime.setText(date);
            }
        });
        datePicker.show(getSupportFragmentManager(), "datePicker");
    }


    @Override
    public void initView() {
        initToolbar("房产信息");
        etHouseTime.setFocusable(false);
        etHouseNature.setFocusable(false);
    }

    @Override
    public void initTitle() {

    }

    private void selectAddress() {
        try {
            String strAddress = tvHouseLocation.getText().toString();
            String str = strAddress.replace(" ", ",");
            ProvinceDialog dialog = new ProvinceDialog(this, str);
            dialog.setListener(new ProvinceDialog.OnProvinceClick() {
                @Override
                public void onData(String province, String areaCode, String code) {
                    try {
                        tvHouseLocation.setText(province.replace(","," "));
                    } catch (Exception e) {
                        Toast.makeText(HouseMessageActivity.this, "地址格式有误", Toast.LENGTH_SHORT).show();
                    }

                }
            });
            dialog.show();
        } catch (Exception e) {
            JLog.e(e.getMessage());
            Toast.makeText(this, "地址解析错误", Toast.LENGTH_SHORT).show();
        }
    }
}
