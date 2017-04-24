package tomcat360.com.hyxfjr.v.view_impl.activity;

import android.content.Intent;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.zhy.adapter.recyclerview.CommonAdapter;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.OnClick;
import tomcat360.com.hyxfjr.R;
import tomcat360.com.hyxfjr.mvp_presenter.presenter_impl.ShipAddressManageAcPresenter;
import tomcat360.com.hyxfjr.mvp_v.i.IShipAddressManageAcView;
import tomcat360.com.hyxfjr.view.myview.SettingItemView;

public class ShipAddressManageActivity extends BaseActivity implements IShipAddressManageAcView, SwipeRefreshLayout.OnRefreshListener {

    @Bind(R.id.add_new_address)
    SettingItemView addNewAddress;
    @Bind(R.id.recyclerView)
    RecyclerView recyclerView;
    @Bind(R.id.swipeRefreshLayout)
    SwipeRefreshLayout swipeRefreshLayout;
    private ShipAddressManageAcPresenter presenter;
    private CommonAdapter<String> adapter;
    private ArrayList<String> strings;


    @Override
    public int getLayoutId() {
        return R.layout.activity_ship_address_manage;
    }

    @Override
    public void initData() {

    }

    @Override
    public void initView() {
        initToolbar("收货地址管理");
        presenter = new ShipAddressManageAcPresenter(this);
        swipeRefreshLayout.setOnRefreshListener(this);
        swipeRefreshLayout.setColorSchemeColors(getResources().getColor(R.color.guestPaint_color_wrong));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        strings = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            strings.add("1");
        }
        recyclerView.setAdapter(adapter = new CommonAdapter<String>(this, R.layout.item_add_address, strings) {
            @Override
            protected void convert(ViewHolder holder, String s, final int position) {
                holder.setOnClickListener(R.id.delete_address, new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        strings.remove(position);
                        adapter.notifyItemRemoved(position);
                    }
                });
            }
        });
    }

    @OnClick(R.id.add_new_address)
    public void OnClick(View view) {
        switch (view.getId()) {
            case R.id.add_new_address:
                presenter.newAddress();
                break;
        }
    }

    @Override
    public void initTitle() {

    }

    @Override
    public void newAddress() {
        startActivity(new Intent(this, NewAddressActivity.class));
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
