package tomcat360.com.hyxfjr.v.view_impl.activity;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import butterknife.Bind;
import butterknife.OnClick;
import tomcat360.com.hyxfjr.R;
import tomcat360.com.hyxfjr.view.MyToolbar;
import util.ButtonClickUtil;

public class FaceRecognitionActivity extends BaseActivity {

    @Bind(R.id.base_toolbar)
    MyToolbar baseToolbar;
    @Bind(R.id.iv_face_pic)
    ImageView ivFacePic;
    @Bind(R.id.btn_next)
    Button btnNext;

    @Override
    public int getLayoutId() {
        return R.layout.activity_face_recognition;
    }

    @OnClick({R.id.btn_next})
    public void onClick(View view) {
        if (ButtonClickUtil.isFastDoubleClick()) return;
        switch (view.getId()) {
            case R.id.btn_next:
                startActivity(new Intent(this, BaseMessageActivity.class));
                break;
            default:
                break;
        }
    }

    @Override
    public void initData() {

    }

    @Override
    public void initView() {
        initToolbar("人脸识别");
    }

    @Override
    public void initTitle() {

    }
}
