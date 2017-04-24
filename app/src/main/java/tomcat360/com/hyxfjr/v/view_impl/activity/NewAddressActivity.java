package tomcat360.com.hyxfjr.v.view_impl.activity;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.jiongbull.jlog.JLog;

import butterknife.Bind;
import butterknife.OnClick;
import tomcat360.com.hyxfjr.R;
import tomcat360.com.hyxfjr.view.MyToolbar;
import tomcat360.com.hyxfjr.view.mydialog.ProvinceDialog;
import tomcat360.com.hyxfjr.view.myview.AddressPickerView;

public class NewAddressActivity extends BaseActivity implements AddressPickerView.AddressPickerCallBack {

    @Bind(R.id.base_toolbar)
    MyToolbar baseToolbar;
    @Bind(R.id.ll_select_city)
    LinearLayout llSelectCity;
    @Bind(R.id.province)
    TextView etProvince;
    @Bind(R.id.city)
    TextView etCity;
    @Bind(R.id.district)
    TextView etDistrict;
    private AddressPickerView addressPickerView;

    @Override
    public int getLayoutId() {
        return R.layout.activity_new_address;
    }

    @Override
    public void initData() {

    }

    @Override
    public void initView() {
        initToolbar("收货地址管理");
        addressPickerView = new AddressPickerView(this, true, this);
    }

    @Override
    public void initTitle() {

    }

    @Override
    public void updateAddress(String address) {

    }

    @OnClick(R.id.ll_select_city)
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ll_select_city://选择省市
                selectAddress();
                break;
        }
    }

    private void selectAddress() {
        try {
            String str = etProvince.getText() + "," + etCity.getText() + "," + etDistrict.getText();
            ProvinceDialog dialog = new ProvinceDialog(this, str);
            dialog.setListener(new ProvinceDialog.OnProvinceClick() {
                @Override
                public void onData(String province, String areaCode, String code) {
                    try {
                        String[] split = province.split(",");
                        etProvince.setText(split[0]);
                        etCity.setText(split[1]);
                        etDistrict.setText(split[2]);
                    } catch (Exception e) {
                        Toast.makeText(NewAddressActivity.this, "地址格式有误", Toast.LENGTH_SHORT).show();
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
