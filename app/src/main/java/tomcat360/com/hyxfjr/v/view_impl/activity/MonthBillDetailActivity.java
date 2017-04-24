package tomcat360.com.hyxfjr.v.view_impl.activity;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.zhy.adapter.recyclerview.CommonAdapter;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import java.util.ArrayList;

import butterknife.Bind;
import tomcat360.com.hyxfjr.R;
import tomcat360.com.hyxfjr.view.MyToolbar;
import tomcat360.com.hyxfjr.view.RecycleViewDivider;

public class MonthBillDetailActivity extends BaseActivity {

    @Bind(R.id.base_toolbar)
    MyToolbar baseToolbar;
    @Bind(R.id.tv_repayment_date)
    TextView tvRepaymentDate;
    @Bind(R.id.tv_money)
    TextView tvMoney;
    @Bind(R.id.recyclerView)
    RecyclerView recyclerView;
    @Bind(R.id.btn_after_repayment)
    Button btnAfterRepayment;
    @Bind(R.id.btn_repayment)
    Button btnRepayment;
    @Bind(R.id.ll_bottom)
    LinearLayout llBottom;


    @Override
    public int getLayoutId() {
        return R.layout.activity_month_bill_detail;
    }

    @Override
    public void initData() {

    }

    @Override
    public void initView() {
        initToolbar("xxxxx年xx月账单详情");
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add("1");
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new RecycleViewDivider(this,LinearLayoutManager.HORIZONTAL));
        recyclerView.setAdapter(new CommonAdapter<String>(this, R.layout.item_bill_detail, list) {

            @Override
            protected void convert(ViewHolder holder, String s, int position) {

            }
        });
    }

    @Override
    public void initTitle() {

    }
}
