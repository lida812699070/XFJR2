package tomcat360.com.hyxfjr.v.view_impl.activity;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.OnClick;
import tomcat360.com.hyxfjr.R;
import tomcat360.com.hyxfjr.view.MyToolbar;

public class LoanSuccessActivity extends BaseActivity {


    @Bind(R.id.base_toolbar)
    MyToolbar baseToolbar;
    @Bind(R.id.tv_money)
    TextView tvMoney;
    @Bind(R.id.tv_bankcard)
    TextView tvBankcard;
    @Bind(R.id.tv_first_repayment)
    TextView tvFirstRepayment;
    @Bind(R.id.tv_first_repayment_day)
    TextView tvFirstRepaymentDay;
    @Bind(R.id.btn_reloan)
    Button btnReloan;
    @Bind(R.id.btn_back_home)
    Button btnBackHome;
    @Bind(R.id.activity_loan_success)
    LinearLayout activityLoanSuccess;

    @Override
    public int getLayoutId() {
        return R.layout.activity_loan_success;
    }

    @Override
    public void initData() {

    }

    @OnClick({R.id.btn_reloan, R.id.btn_back_home})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_reloan:
                Intent intent = new Intent(this, LoanActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                break;
            case R.id.btn_back_home:
                Intent intent2 = new Intent(this, MainActivity.class);
                intent2.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent2);
                break;
        }
    }

    @Override
    public void initView() {
        initToolbar("借款成功");
    }

    @Override
    public void initTitle() {

    }

}
