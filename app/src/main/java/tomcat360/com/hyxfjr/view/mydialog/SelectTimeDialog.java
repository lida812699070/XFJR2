package tomcat360.com.hyxfjr.view.mydialog;

import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

import tomcat360.com.hyxfjr.v.view_impl.fragment.DatePickerFragment;

/**
 * Created by lida on 2017/4/24 0024.
 */

public class SelectTimeDialog {
    public static void showSelectTimeDialog(AppCompatActivity activity, final EditText etTime) {
        //选择时间对话框
        DatePickerFragment datePicker = new DatePickerFragment();
        datePicker.setDateCallBack(new DatePickerFragment.DateCallBack() {
            @Override
            public void getDate(String date) {
                etTime.setText(date);
            }
        });
        datePicker.show(activity.getSupportFragmentManager(), "datePicker");
    }
}