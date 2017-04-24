package tomcat360.com.hyxfjr.v.view_impl.activity;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.OnClick;
import tomcat360.com.hyxfjr.R;

public class BillActivity extends BaseActivity {

    @Bind(R.id.tv_money)
    TextView tvMoney;
    @Bind(R.id.tv_repayment_date)
    TextView tvRepaymentDate;
    @Bind(R.id.ll_current_account)
    LinearLayout llCurrentAccount;
    @Bind(R.id.ll_bill_detail)
    LinearLayout llBillDetail;
    @Bind(R.id.ll_bottom)
    LinearLayout llBottom;
    @Bind(R.id.iv_back)
    ImageView ivBack;
    @Bind(R.id.ll_history_bill)
    LinearLayout llHistoryBill;
    @Bind(R.id.btn_prepayment)
    Button btnPrepayment;
    @Bind(R.id.btn_repayment)
    Button btnRepayment;

    @Override
    public int getLayoutId() {
        return R.layout.activity_bill;
    }

    @Override
    public void initData() {

    }

    @OnClick({R.id.ll_current_account, R.id.ll_history_bill, R.id.btn_prepayment})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ll_current_account://本期账单
                startActivity(new Intent(this, CurrentAccountListActivity.class));
                break;
            case R.id.ll_history_bill://历史账单
                startActivity(new Intent(this, HistoryBillActivity.class));
                break;
            case R.id.btn_prepayment://历史账单
                startActivity(new Intent(this, PrepaymentActivity.class));
                break;
        }
    }

    @Override
    public void initView() {

    }

    @Override
    public void initTitle() {

    }


}
