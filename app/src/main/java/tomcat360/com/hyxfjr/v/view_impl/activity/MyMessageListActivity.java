package tomcat360.com.hyxfjr.v.view_impl.activity;

import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.OnClick;
import tomcat360.com.hyxfjr.R;
import tomcat360.com.hyxfjr.model.adapter.MyMessageListAdapter;
import tomcat360.com.hyxfjr.mvp_presenter.presenter_impl.MyMessagePresenter;
import tomcat360.com.hyxfjr.mvp_v.i.IMyMessageListView;
import tomcat360.com.hyxfjr.view.RecycleViewDivider;

public class MyMessageListActivity extends BaseActivity implements IMyMessageListView, SwipeRefreshLayout.OnRefreshListener {

    @Bind(R.id.iv_toolbar_back)
    ImageView ivToolbarBack;
    @Bind(R.id.tv_toolbar_right)
    TextView tvToolbarRight;
    @Bind(R.id.recyclerView)
    RecyclerView recyclerView;
    @Bind(R.id.swipeRefreshLayout)
    SwipeRefreshLayout swipeRefreshLayout;
    @Bind(R.id.tv_mark_all)
    TextView tvMarkAll;
    @Bind(R.id.tv_delete)
    TextView tvDelete;
    @Bind(R.id.ll_edit_bottom)
    RelativeLayout llEditBottom;
    private boolean mIsEditStatus = false;//是否可以编辑
    private MyMessagePresenter presenter;
    private MyMessageListAdapter adapter;

    @Override
    public int getLayoutId() {
        return R.layout.activity_my_message;
    }

    @OnClick({R.id.tv_toolbar_right, R.id.iv_toolbar_back, R.id.tv_mark_all
            , R.id.tv_delete})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_toolbar_back://返回
                finish();
                break;
            case R.id.tv_toolbar_right://编辑
                presenter.editMessage(mIsEditStatus);
                break;
            case R.id.tv_delete://删除
                presenter.delete();
                break;
            case R.id.tv_mark_all://标记全部
                presenter.markAll();
                break;
        }
    }

    @Override
    public void initData() {

    }

    @Override
    public void initView() {
        initToolbar("我的消息");
        Toolbar toolbar = getToolbar();
        setSupportActionBar(toolbar);
        presenter = new MyMessagePresenter(this);
        swipeRefreshLayout.setOnRefreshListener(this);
        swipeRefreshLayout.setColorSchemeColors(getResources().getColor(R.color.guestPaint_color_wrong));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new RecycleViewDivider(this, LinearLayoutManager.HORIZONTAL));
        ArrayList<String> strings = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            strings.add("1");
        }
        recyclerView.setAdapter(adapter = new MyMessageListAdapter(this, strings));
    }

    @Override
    public void initTitle() {

    }

    @Override
    public void editMessage() {
        mIsEditStatus = !mIsEditStatus;
    }

    @Override
    public void isShowCheckBox(boolean mIsEditStatus) {
        adapter.editCheck(mIsEditStatus);
    }

    @Override
    public void delete() {
        if (!mIsEditStatus) return;
    }

    @Override
    public void markAll() {
        if (!mIsEditStatus) return;
        adapter.markAll();
    }

    @Override
    public void setLlBottomVisable(boolean mIsEditStatus) {
        llEditBottom.setVisibility(mIsEditStatus ? View.VISIBLE : View.GONE);
    }

    @Override
    public void setIsEdit(boolean mIsEditStatus) {
        tvToolbarRight.setText(mIsEditStatus ? "取消编辑" : "编辑");
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
