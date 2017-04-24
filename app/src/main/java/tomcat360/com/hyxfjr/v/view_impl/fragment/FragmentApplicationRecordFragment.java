package tomcat360.com.hyxfjr.v.view_impl.fragment;

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
import com.zhy.adapter.recyclerview.base.ViewHolder;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import tomcat360.com.hyxfjr.R;

public class FragmentApplicationRecordFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener {


    @Bind(R.id.recyclerView)
    RecyclerView recyclerView;
    @Bind(R.id.swipeRefreshLayout)
    SwipeRefreshLayout swipeRefreshLayout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_application_record, null);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        swipeRefreshLayout.setOnRefreshListener(this);
        swipeRefreshLayout.setColorSchemeColors(getResources().getColor(R.color.guestPaint_color_wrong));
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        ArrayList<String> strings = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            strings.add("1");
        }
        recyclerView.setAdapter(new CommonAdapter<String>(getActivity(),R.layout.item_application_record,strings) {
            @Override
            protected void convert(ViewHolder holder, String s, int position) {

            }
        });
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
        },2000);
    }
}
