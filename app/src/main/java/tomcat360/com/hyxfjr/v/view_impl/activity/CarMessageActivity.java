package tomcat360.com.hyxfjr.v.view_impl.activity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import butterknife.Bind;
import butterknife.OnClick;
import tomcat360.com.hyxfjr.R;
import tomcat360.com.hyxfjr.v.view_impl.fragment.DatePickerFragment;
import tomcat360.com.hyxfjr.view.MyToolbar;

public class CarMessageActivity extends BaseActivity {

    @Bind(R.id.base_toolbar)
    MyToolbar baseToolbar;
    @Bind(R.id.et_select_time)
    EditText etSelectTime;
    @Bind(R.id.et_car_number)
    EditText etCarNumber;
    @Bind(R.id.et_car_brand)
    EditText etCarBrand;
    @Bind(R.id.rg_mortgage)
    RadioGroup rgMortgage;
    @Bind(R.id.rb_with_mortgage)
    RadioButton rbWithMortgage;
    @Bind(R.id.rb_not_mortgage)
    RadioButton rbNotMortgage;
    @Bind(R.id.rb_pledge)
    RadioButton rbPledge;
    @Bind(R.id.et_mortgage_money)
    EditText etMortgageMoney;
    @Bind(R.id.et_mortgage_number)
    EditText etMortgageNumber;
    @Bind(R.id.ll_with_mortgage)
    LinearLayout llWithMortgage;
    @Bind(R.id.btn_save)
    Button btnSave;

    @Override
    public int getLayoutId() {
        return R.layout.activity_car_message;
    }

    @Override
    public void initData() {

    }

    @Override
    public void initView() {
        initToolbar("车产信息");
        etSelectTime.setFocusable(false);
        rgMortgage.setOnCheckedChangeListener(checkedChangeListener);
    }

    RadioGroup.OnCheckedChangeListener checkedChangeListener = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup radioGroup, int checkId) {
            switch (checkId) {
                case R.id.rb_with_mortgage://有按揭
                    llWithMortgage.animate().scaleY(1);
                    break;
                case R.id.rb_not_mortgage://无按揭
                    llWithMortgage.animate().scaleY(0);
                    break;
                case R.id.rb_pledge://抵押贷款
                    llWithMortgage.animate().scaleY(0);
                    break;
                default:
                    break;
            }
        }
    };

    @OnClick({R.id.et_select_time})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.et_select_time:
                DatePickerFragment datePicker = new DatePickerFragment();
                datePicker.setDateCallBack(new DatePickerFragment.DateCallBack() {
                    @Override
                    public void getDate(String date) {
                        etSelectTime.setText(date);
                    }
                });
                datePicker.show(getSupportFragmentManager(), "datePicker");
                break;
            default:
                break;
        }
    }

    @Override
    public void initTitle() {

    }


}
