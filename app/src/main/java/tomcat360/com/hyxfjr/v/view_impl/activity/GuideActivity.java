package tomcat360.com.hyxfjr.v.view_impl.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import tomcat360.com.hyxfjr.R;
import tomcat360.com.hyxfjr.model.adapter.ViewPagerAdapter;
import util.ButtonClickUtil;
import util.SPUtils;

public class GuideActivity extends BaseActivity {
    private static int[] guidePics = {
            R.drawable.guide_01,
            R.drawable.guide_02,
            R.drawable.guide_03
    };
    @Bind(R.id.vp)
    ViewPager vp;

    @Override
    public int getLayoutId() {
        return R.layout.activity_guide;
    }

    private View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (ButtonClickUtil.isFastDoubleClick())
                return;
            setGuided();
            goHome();
        }
    };

    private void goHome() {
        Intent intent = new Intent(this, MainActivity.class);
        this.startActivity(intent);
        this.finish();
    }

    private void setGuided() {
        SPUtils.put(this, "isFirstIn", false);
    }

    @Override
    public void initData() {
        List<ImageView> imageViews = new ArrayList<>();
        for (int i = 0; i < guidePics.length; i++) {
            ImageView imageView = new ImageView(this);
            imageView.setImageResource(guidePics[i]);
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT));
            if (i == guidePics.length - 1) {
                imageView.setOnClickListener(listener);
            }
            imageViews.add(imageView);
        }
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(imageViews);
        vp.setAdapter(viewPagerAdapter);
    }

    @Override
    public void initView() {

    }

    @Override
    public void initTitle() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
