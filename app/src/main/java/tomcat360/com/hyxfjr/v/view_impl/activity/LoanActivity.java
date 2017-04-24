package tomcat360.com.hyxfjr.v.view_impl.activity;

import android.content.Intent;
import android.graphics.Color;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.OnCheckedChanged;
import butterknife.OnClick;
import tomcat360.com.hyxfjr.R;
import tomcat360.com.hyxfjr.mvp_presenter.presenter_impl.LoadAcPresenter;
import tomcat360.com.hyxfjr.mvp_v.i.ILoanAcView;
import tomcat360.com.hyxfjr.view.MyToolbar;
import util.ButtonClickUtil;

public class LoanActivity extends BaseActivity implements ILoanAcView {

    @Bind(R.id.textView2)
    TextView textView2;
    @Bind(R.id.loan_repayment_details)
    RelativeLayout repaymentDetails;
    @Bind(R.id.loan_btn_put)
    Button loanBtnPut;
    @Bind(R.id.base_toolbar)
    MyToolbar baseToolbar;
    @Bind(R.id.checkbox_agree)
    CheckBox checkboxAgree;
    private LoadAcPresenter loadAcPresenter;

    @Override
    public int getLayoutId() {
        return R.layout.activity_loan;
    }

    @Override
    public void initData() {

    }

    @Override
    public void initView() {
        initToolbar("我要借款");
        loadAcPresenter = new LoadAcPresenter(this);
    }

    @OnClick({R.id.loan_repayment_details, R.id.loan_btn_put})
    public void onClick(View view) {
        if (ButtonClickUtil.isFastDoubleClick()) return;
        switch (view.getId()) {
            case R.id.loan_repayment_details://还款详情
                loadAcPresenter.showRepaymentFetails();
                break;
            case R.id.loan_btn_put://确定
                loadAcPresenter.intoPassword();
                break;
            default:
                break;
        }
    }

    @OnCheckedChanged(R.id.checkbox_agree)//是否同意选择框
    public void checkChange(CompoundButton view, boolean isChecked) {
        if (isChecked) {
            loanBtnPut.setBackgroundColor(getResources().getColor(R.color.guestPaint_color_wrong));
        } else {
            loanBtnPut.setBackgroundColor(Color.GRAY);
        }
    }


    @Override
    public void initTitle() {

    }


    @Override
    public void showDialog() {
        showProgress("登录中..");
    }

    @Override
    public void hideDialog() {
        hideProgress();
    }

    @Override
    public void showRepaymentDetails() {
        startActivity(new Intent(this, DialogLoanRepaymentActivity.class));
    }

    @Override
    public void intoPassword() {
        startActivity(new Intent(this, Input6PasswordActivity.class));
    }

    @Override
    public boolean isAgree() {
        return checkboxAgree.isChecked();
    }


}
