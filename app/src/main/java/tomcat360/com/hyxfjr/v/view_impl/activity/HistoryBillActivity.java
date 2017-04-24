package tomcat360.com.hyxfjr.v.view_impl.activity;

import android.content.Intent;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.zhy.adapter.recyclerview.MultiItemTypeAdapter;

import java.util.ArrayList;

import butterknife.Bind;
import tomcat360.com.hyxfjr.R;
import tomcat360.com.hyxfjr.model.adapter.MyBillHistoryAdapter;
import tomcat360.com.hyxfjr.model.entity.MyBillHistory;
import tomcat360.com.hyxfjr.view.MyToolbar;
import tomcat360.com.hyxfjr.view.RecycleViewDivider;

public class HistoryBillActivity extends BaseActivity implements SwipeRefreshLayout.OnRefreshListener {

    @Bind(R.id.base_toolbar)
    MyToolbar baseToolbar;
    @Bind(R.id.recyclerView)
    RecyclerView recyclerView;
    @Bind(R.id.swipeRefreshLayout)
    SwipeRefreshLayout swipeRefreshLayout;
    private ArrayList<MyBillHistory> list;
    private MyBillHistoryAdapter adapter;

    @Override
    public int getLayoutId() {
        return R.layout.activity_history_bill;
    }

    @Override
    public void initData() {

    }

    @Override
    public void initView() {
        initToolbar("历史账单");
        swipeRefreshLayout.setColorSchemeColors(getResources().getColor(R.color.guestPaint_color_wrong));
        swipeRefreshLayout.setOnRefreshListener(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new RecycleViewDivider(this, LinearLayoutManager.HORIZONTAL));
        list = new ArrayList<>();
        list.add(new MyBillHistory("2017年账单", 1));
        for (int i = 0; i < 10; i++) {
            list.add(new MyBillHistory("3月账单", "2017.02.28-2017.03.28", 5555.55, 2));
        }
        list.add(new MyBillHistory("2016年账单", 1));
        for (int i = 0; i < 10; i++) {
            list.add(new MyBillHistory("3月账单", "2016.02.28-2016.03.28", 33333, 2));
        }
        adapter = new MyBillHistoryAdapter(this, list);
        recyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(new MultiItemTypeAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, RecyclerView.ViewHolder holder, int position) {
                startActivity(new Intent(HistoryBillActivity.this, MonthBillDetailActivity.class));
            }

            @Override
            public boolean onItemLongClick(View view, RecyclerView.ViewHolder holder, int position) {
                return false;
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
        }, 1500);
    }
}
