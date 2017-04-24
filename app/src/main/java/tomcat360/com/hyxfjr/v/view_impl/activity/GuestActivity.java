package tomcat360.com.hyxfjr.v.view_impl.activity;

import android.content.Intent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ToggleButton;

import butterknife.Bind;
import butterknife.OnClick;
import tomcat360.com.hyxfjr.R;
import tomcat360.com.hyxfjr.mvp_m.ParamNameConstant;
import util.SPUtils;

/**
 * Title:GuestActivity
 * Package:com.tomcat360.v.view_impl.activity
 * Description:TODO
 * Author: llj@tomcat360.com
 * Date: 2017/4/11
 * Version: V1.0.0
 * 版本号修改日期修改人修改内容
 */

public class GuestActivity extends BaseActivity {

    @Bind(R.id.manage_guesture_togglebtn)
    ToggleButton manageGuestureTogglebtn;
    @Bind(R.id.ll_modify_gesture)
    LinearLayout lModifyGesture;

    private boolean gwflag;

    @Override
    public int getLayoutId() {
        return R.layout.activity_gesture;
    }

    @Override
    public void initData() {
        gwflag = (boolean) SPUtils.get(this, ParamNameConstant.GUEST_STATUS, false);
        manageGuestureTogglebtn.setChecked(gwflag);
        lModifyGesture.setVisibility(gwflag ? View.VISIBLE : View.GONE);
    }

    @Override
    public void initView() {
        initToolbar("手势密码");
    }

    @Override
    public void initTitle() {
    }

    @OnClick({R.id.modify_gesture, R.id.manage_guesture_togglebtn, R.id.guest_switch})
    void onclick(View view) {
        switch (view.getId()) {
            case R.id.modify_gesture://修改
                startActivity(new Intent(this, ModifyGesturePasswordActivity.class));
                break;
            case R.id.guest_switch://开关
            case R.id.manage_guesture_togglebtn:
                if (!manageGuestureTogglebtn.isChecked()) {
                    startActivity(new Intent(this, CancelGesturePasswordActivity.class));
                } else {
                    if (!gwflag) {
                        startActivity(new Intent(this, CreateGesturePasswordActivity.class));
                    }
                }
                break;
        }
    }
}
