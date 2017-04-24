package tomcat360.com.hyxfjr.v.view_impl.activity;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.zhy.adapter.recyclerview.CommonAdapter;
import com.zhy.adapter.recyclerview.MultiItemTypeAdapter;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.OnClick;
import tomcat360.com.hyxfjr.R;
import tomcat360.com.hyxfjr.view.MyToolbar;
import tomcat360.com.hyxfjr.view.RecycleViewDivider;

public class CurrentAccountListActivity extends BaseActivity {

    @Bind(R.id.base_toolbar)
    MyToolbar baseToolbar;
    @Bind(R.id.recyclerView)
    RecyclerView recyclerView;
    @Bind(R.id.btn_prepayment)
    Button btnAfterRepayment;
    @Bind(R.id.btn_repayment)
    Button btnRepayment;
    @Bind(R.id.ll_bottom)
    LinearLayout llBottom;
    private CommonAdapter<String> adapter;


    @Override
    public int getLayoutId() {
        return R.layout.activity_current_account_detail;
    }

    @Override
    public void initData() {

    }

    @OnClick({R.id.btn_prepayment})
    public void onClick(View view){
        switch (view.getId()){
            case R.id.btn_prepayment:
                startActivity(new Intent(this,PrepaymentActivity.class));
                break;
        }
    }

    @Override
    public void initView() {
        initToolbar("本期账单");
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new RecycleViewDivider(this, LinearLayoutManager.HORIZONTAL));
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add("1");
        }
        recyclerView.setAdapter(adapter = new CommonAdapter<String>(this, R.layout.item_bill_detail, list) {
            @Override
            protected void convert(ViewHolder holder, String s, int position) {

            }
        });
        adapter.setOnItemClickListener(new MultiItemTypeAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, RecyclerView.ViewHolder holder, int position) {
                startActivity(new Intent(CurrentAccountListActivity.this, CurrentAccountActivity.class));
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
}
