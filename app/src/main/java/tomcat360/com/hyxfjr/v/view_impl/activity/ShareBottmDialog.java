package tomcat360.com.hyxfjr.v.view_impl.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import tomcat360.com.hyxfjr.R;

public class ShareBottmDialog extends AppCompatActivity {

    @Bind(R.id.iv_share_facebook)
    ImageView ivShareFacebook;
    @Bind(R.id.iv_share_sina)
    ImageView ivShareSina;
    @Bind(R.id.iv_share_wx)
    ImageView ivShareWx;
    @Bind(R.id.iv_share_qq)
    ImageView ivShareQq;
    @Bind(R.id.ll_cancle)
    LinearLayout llCancle;
    @Bind(R.id.rl_gen)
    RelativeLayout rlGen;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share_bottm_dialog);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.ll_cancle, R.id.rl_gen, R.id.iv_share_facebook,
            R.id.iv_share_sina, R.id.iv_share_wx, R.id.iv_share_qq})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ll_cancle://取消
            case R.id.rl_gen:
                finish();
                break;
            case R.id.iv_share_facebook://分享facebook
                break;
            case R.id.iv_share_sina://分享新浪微博
                break;
            case R.id.iv_share_wx://分享微信
                break;
            case R.id.iv_share_qq://分享qq
                break;
        }
    }

}
