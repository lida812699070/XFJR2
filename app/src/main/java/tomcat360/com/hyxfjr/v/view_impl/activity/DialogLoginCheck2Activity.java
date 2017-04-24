package tomcat360.com.hyxfjr.v.view_impl.activity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.OnClick;
import tomcat360.com.hyxfjr.R;

public class DialogLoginCheck2Activity extends BaseActivity {

    @Bind(R.id.et_password)
    EditText etPassword;
    @Bind(R.id.et_password_again)
    EditText etPasswordAgain;
    @Bind(R.id.btn_finish)
    Button btnFinish;
    @Bind(R.id.iv_back)
    ImageView ivBack;
    @Bind(R.id.tv_back)
    TextView tvBack;

    @Override
    public int getLayoutId() {
        return R.layout.activity_dialog_login_check2;
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

    @OnClick({R.id.iv_back, R.id.tv_back, R.id.btn_finish})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_back://回退
            case R.id.tv_back://回退
                finish();
                break;
            case R.id.btn_finish://完成
                finish();
                break;
        }
    }

}
