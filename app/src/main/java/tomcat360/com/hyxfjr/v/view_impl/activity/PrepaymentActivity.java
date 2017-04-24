package tomcat360.com.hyxfjr.v.view_impl.activity;

import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import butterknife.Bind;
import tomcat360.com.hyxfjr.R;
import tomcat360.com.hyxfjr.model.adapter.PrepaymentAdapter;
import tomcat360.com.hyxfjr.view.MyToolbar;

public class PrepaymentActivity extends BaseActivity implements SwipeRefreshLayout.OnRefreshListener {

    @Bind(R.id.base_toolbar)
    MyToolbar baseToolbar;
    @Bind(R.id.recyclerView)
    RecyclerView recyclerView;
    @Bind(R.id.swipeRefreshLayout)
    SwipeRefreshLayout swipeRefreshLayout;

    @Override
    public int getLayoutId() {
        return R.layout.activity_prepayment;
    }

    @Override
    public void initData() {

    }

    @Override
    public void initView() {
        initToolbar("提前还款");
        swipeRefreshLayout.setColorSchemeColors(getResources().getColor(R.color.guestPaint_color_wrong));
        swipeRefreshLayout.setOnRefreshListener(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            list.add("1");
        }
        recyclerView.setAdapter(new PrepaymentAdapter(this,list));
      /*  recyclerView.setAdapter(new CommonAdapter<String>(this, R.layout.item_prepayment, list) {

            @Override
            protected void convert(final ViewHolder holder, String s, int position) {
                holder.setOnClickListener(R.id.tv_instalments, new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        final RecyclerView recyclerViewInner = initRecycleview(holder);
                        int visibility = recyclerViewInner.getVisibility();
                        if (visibility == View.GONE) {
                            recyclerViewInner.setVisibility(View.VISIBLE);
                        } else {
                            recyclerViewInner.setVisibility(View.GONE);
                        }
                    }
                });
            }

            @NonNull
            private RecyclerView initRecycleview(ViewHolder holder) {
                final RecyclerView recyclerView = holder.getView(R.id.inner_recyclerView);
                recyclerView.setLayoutManager(new LinearLayoutManager(PrepaymentActivity.this));
                ArrayList<String> strings = new ArrayList<>();
                for (int i = 0; i < 3; i++) {
                    strings.add("1");
                }
                recyclerView.setAdapter(new CommonAdapter<String>(PrepaymentActivity.this, R.layout.item_prepayment_inner, strings) {

                    @Override
                    protected void convert(ViewHolder holder, String s, int position) {

                    }
                });
                return recyclerView;
            }
        });*/
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
