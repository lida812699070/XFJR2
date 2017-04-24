package tomcat360.com.hyxfjr.view.mydialog;

import android.app.Activity;
import android.widget.TextView;
import android.widget.Toast;

import com.jiongbull.jlog.JLog;

/**
 * Created by lida on 2017/4/24 0024.
 */

public class ProvinceDialogUtils {

    public static void selectAddress(final Activity activity, final TextView tvLocation) {
        try {
            String strAddress = tvLocation.getText().toString();
            String str = strAddress.replace(" ", ",");
            ProvinceDialog dialog = new ProvinceDialog(activity, str);
            dialog.setListener(new ProvinceDialog.OnProvinceClick() {
                @Override
                public void onData(String province, String areaCode, String code) {
                    try {
                        tvLocation.setText(province.replace(",", " "));
                    } catch (Exception e) {
                        Toast.makeText(activity, "地址格式有误", Toast.LENGTH_SHORT).show();
                    }

                }
            });
            dialog.show();
        } catch (Exception e) {
            JLog.e(e.getMessage());
            Toast.makeText(activity, "地址解析错误", Toast.LENGTH_SHORT).show();
        }
    }
}