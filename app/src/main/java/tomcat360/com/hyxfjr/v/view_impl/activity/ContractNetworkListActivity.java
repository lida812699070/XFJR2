package tomcat360.com.hyxfjr.v.view_impl.activity;

import android.Manifest;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.LocationManager;
import android.provider.Settings;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.tbruyelle.rxpermissions2.RxPermissions;

import butterknife.Bind;
import butterknife.OnClick;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import tomcat360.com.hyxfjr.R;

public class ContractNetworkListActivity extends BaseActivity {


    @Bind(R.id.toolbar_back)
    ImageView toolbarBack;
    @Bind(R.id.toolbar_title)
    TextView toolbarTitle;
    @Bind(R.id.rl_toolbar)
    RelativeLayout rlToolbar;
    @Bind(R.id.ll_center_company)
    RelativeLayout llCenterCompany;

    @Override
    public int getLayoutId() {
        return R.layout.activity_contract_network_list;
    }

    @Override
    public void initData() {

    }

    @Override
    public void initView() {

    }

    @Override
    public void initTitle() {

    }

    @OnClick(R.id.ll_center_company)
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ll_center_company:
                intoNewWorkMap();
                break;
        }
    }

    private void intoNewWorkMap() {
        new RxPermissions(this)
                .request(Manifest.permission.ACCESS_FINE_LOCATION)
                .subscribe(new Consumer<Boolean>() {
                    @Override
                    public void accept(@NonNull Boolean aBoolean) throws Exception {
                        if (aBoolean) {
                            initGPS();
                        } else {
                            Toast.makeText(ContractNetworkListActivity.this, "请到设置中同意相关权限", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    private void initGPS() {
        LocationManager locationManager = (LocationManager) this
                .getSystemService(Context.LOCATION_SERVICE);
        // 判断GPS模块是否开启，如果没有则开启
        if (!locationManager
                .isProviderEnabled(android.location.LocationManager.GPS_PROVIDER)) {
            Toast.makeText(ContractNetworkListActivity.this, "请打开GPS",
                    Toast.LENGTH_SHORT).show();
            AlertDialog.Builder dialog = new AlertDialog.Builder(this);
            dialog.setMessage("请打开GPS");
            dialog.setPositiveButton("确定",
                    new android.content.DialogInterface.OnClickListener() {

                        @Override
                        public void onClick(DialogInterface arg0, int arg1) {

                            // 转到手机设置界面，用户设置GPS
                            Intent intent = new Intent(
                                    Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                            startActivityForResult(intent, 0); // 设置完成后返回到原来的界面

                        }
                    });
            dialog.setNeutralButton("取消", new android.content.DialogInterface.OnClickListener() {

                @Override
                public void onClick(DialogInterface arg0, int arg1) {
                    arg0.dismiss();
                }
            });
            dialog.show();
        } else {
            //gps已经打开
            startActivity(new Intent(ContractNetworkListActivity.this, ContractNetworkActivity.class));
        }
    }

}
