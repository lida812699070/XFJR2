package tomcat360.com.hyxfjr.v.view_impl.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.jiongbull.jlog.JLog;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.disposables.Disposable;
import tomcat360.com.hyxfjr.R;
import tomcat360.com.hyxfjr.mvp_presenter.presenter_impl.DialogCheckPresenter;
import tomcat360.com.hyxfjr.mvp_v.i.IDialogCheck1View;
import tomcat360.com.hyxfjr.my_utils.GetCheckCodeUtils;

/**
 * Created by Administrator on 2017/4/14 0014.
 */

public class DialogLoginCheck1Activity extends BaseActivity implements IDialogCheck1View {
    @Bind(R.id.dialog_login_check_back)
    ImageView dialogLoginCheckBack;
    @Bind(R.id.dialog_login_check_mobile)
    EditText dialogLoginCheckMobile;
    @Bind(R.id.textView)
    TextView textView;
    @Bind(R.id.dialog_login_check_code)
    EditText dialogLoginCheckCode;
    @Bind(R.id.dialog_login_check_reinvite_code)
    EditText dialogLoginCheckReinviteCode;
    @Bind(R.id.dialog_login_check_next_btn)
    Button dialogLoginCheckNextBtn;
    @Bind(R.id.dialog_login_check_back_tv)
    TextView dialogLoginCheckBackTv;
    @Bind(R.id.btn_get_identifying_code)
    Button mSend;
    private DialogCheckPresenter presenter;
    private long count = 60;
    private Disposable checkCode;

    @Override
    public int getLayoutId() {
        return R.layout.dialog_login_check;
    }

    @Override
    public void initData() {

    }

    @OnClick({R.id.dialog_login_check_next_btn, R.id.dialog_login_check_back,
            R.id.dialog_login_check_back_tv, R.id.btn_get_identifying_code})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.dialog_login_check_next_btn://下一步
                presenter.intoNext();
                break;
            case R.id.dialog_login_check_back://返回
            case R.id.dialog_login_check_back_tv:
                finish();
            case R.id.btn_get_identifying_code://获取验证码
                presenter.getCheckCode(dialogLoginCheckMobile.getText().toString().trim());
                break;
        }
    }

    @Override
    public void initView() {
        presenter = new DialogCheckPresenter(this);
    }

    @Override
    public void initTitle() {

    }

    @Override
    public void intoNext() {
        startActivity(new Intent(this, DialogLoginCheck2Activity.class));
        finish();
    }

    @Override
    public void getCheckCode() {
        checkCode = GetCheckCodeUtils.getCheckCode(60, mSend, getResources().getColor(R.color.text_color_blue));
    }

    @Override
    public void showErrorMobileNumber() {
        showMessage(getResources().getString(R.string.mobile_error));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @Override
    protected void onDestroy() {
        JLog.e("onDestroy");
        if (checkCode != null)
            checkCode.dispose();
        super.onDestroy();
    }
}
