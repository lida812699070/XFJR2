package tomcat360.com.hyxfjr.v.view_impl.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import org.greenrobot.eventbus.EventBus;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import tomcat360.com.hyxfjr.R;
import tomcat360.com.hyxfjr.mvp_m.G;
import tomcat360.com.hyxfjr.view.myview.ClipImageLayout;

public class MyCutImageActivity extends AppCompatActivity {

    @Bind(R.id.id_clipImageLayout)
    ClipImageLayout mClipImageLayout;
    @Bind(R.id.iv_delete)
    ImageView ivDelete;
    @Bind(R.id.iv_cut)
    ImageView ivCut;
    @Bind(R.id.iv)
    ImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_cut_image);
        ButterKnife.bind(this);
        Intent intent = getIntent();
        String imagePath = intent.getStringExtra(G.IMAGE_PATH);
        mClipImageLayout.setImagePath(imagePath);
    }

    @OnClick({R.id.iv_cut, R.id.iv_delete})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_cut:
                cut();
                break;
            case R.id.iv_delete:
                finish();
                break;
        }
    }

    private void cut() {
        Bitmap bitmap = mClipImageLayout.clip();
        EventBus.getDefault().post(bitmap);
        finish();
    }
}
