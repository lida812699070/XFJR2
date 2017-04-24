package tomcat360.com.hyxfjr.v.view_impl.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import tomcat360.com.hyxfjr.R;
import tomcat360.com.hyxfjr.model.adapter.LoadDialogAdapter;

public class DialogLoanRepaymentActivity extends BaseActivity {

    @Bind(R.id.load_dialog_lv)
    ListView loadDialogLv;
    @Bind(R.id.load_dialog_finish_btn)
    ImageView loadDialogFinishBtn;

    @Override
    public int getLayoutId() {
        return R.layout.activity_dialog_loan_repayment;
    }

    @OnClick({R.id.load_dialog_finish_btn})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.load_dialog_finish_btn:
                finish();
                break;
        }
    }

    @Override
    public void initData() {

    }

    @Override
    public void initView() {
        ArrayList<String> strings = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            strings.add("1");
        }
        loadDialogLv.setAdapter(new LoadDialogAdapter(this, strings));
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
