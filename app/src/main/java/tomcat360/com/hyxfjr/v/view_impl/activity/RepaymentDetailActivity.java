package tomcat360.com.hyxfjr.v.view_impl.activity;

import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.zhy.adapter.recyclerview.CommonAdapter;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import java.util.ArrayList;

import butterknife.Bind;
import tomcat360.com.hyxfjr.R;
import tomcat360.com.hyxfjr.view.RecycleViewDivider;

public class RepaymentDetailActivity extends BaseActivity implements SwipeRefreshLayout.OnRefreshListener {


    @Bind(R.id.recyclerView)
    RecyclerView recyclerView;
    @Bind(R.id.swipeRefreshLayout)
    SwipeRefreshLayout swipeRefreshLayout;

    @Override
    public int getLayoutId() {
        return R.layout.activity_repayment_detail;
    }

    @Override
    public void initData() {

    }

    @Override
    public void initView() {
        initToolbar("还款详情");
        swipeRefreshLayout.setOnRefreshListener(this);
        swipeRefreshLayout.setColorSchemeColors(getResources().getColor(R.color.guestPaint_color_wrong));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new RecycleViewDivider(this, LinearLayoutManager.HORIZONTAL));
        ArrayList<String> strings = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            strings.add("1");
        }
        recyclerView.setAdapter(new CommonAdapter<String>(this, R.layout.item_repayment_detail, strings) {
            @Override
            protected void convert(ViewHolder holder, String s, int position) {

            }
        });
    }

    @Override
    public void initTitle() {

    }


    @Override
    public void onRefresh() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                swipeRefreshLayout.setRefreshing(false);
            }
        }, 2000);
    }
}
