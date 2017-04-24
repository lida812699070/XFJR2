package tomcat360.com.hyxfjr.v.view_impl.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zhy.adapter.recyclerview.CommonAdapter;
import com.zhy.adapter.recyclerview.MultiItemTypeAdapter;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import tomcat360.com.hyxfjr.R;
import tomcat360.com.hyxfjr.v.view_impl.activity.RepaymentDetailActivity;

public class FragmentPaymentHistoryNotPayOffFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener, MultiItemTypeAdapter.OnItemClickListener {

    @Bind(R.id.recyclerView)
    RecyclerView recyclerView;
    @Bind(R.id.swipeRefreshLayout)
    SwipeRefreshLayout swipeRefreshLayout;
    private ArrayList<String> strings;
    private CommonAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_payment_history_not_pay_off, null);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        swipeRefreshLayout.setOnRefreshListener(this);
        swipeRefreshLayout.setColorSchemeColors(getResources().getColor(R.color.guestPaint_color_wrong));
        strings = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            strings.add("1");
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter = new CommonAdapter<String>(getActivity(), R.layout.item_payment_history, strings) {
            @Override
            protected void convert(ViewHolder holder, String s, int position) {

            }
        };
        recyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(this);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
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

    @Override
    public void onItemClick(View view, RecyclerView.ViewHolder holder, int position) {
        startActivity(new Intent(getActivity(), RepaymentDetailActivity.class));
    }

    @Override
    public boolean onItemLongClick(View view, RecyclerView.ViewHolder holder, int position) {
        return false;
    }
}
