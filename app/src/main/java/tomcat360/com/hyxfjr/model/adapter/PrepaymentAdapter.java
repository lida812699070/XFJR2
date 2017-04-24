package tomcat360.com.hyxfjr.model.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.zhy.adapter.recyclerview.CommonAdapter;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import java.util.ArrayList;
import java.util.List;

import tomcat360.com.hyxfjr.R;

/**
 * Created by Administrator on 2017/4/20 0020.
 */

public class PrepaymentAdapter extends RecyclerView.Adapter<PrepaymentAdapter.MyViewHolder> {

    private List<String> mDatas;
    private Context mContext;
    private LayoutInflater inflater;

    public PrepaymentAdapter(Context context, List<String> datas) {
        this.mContext = context;
        this.mDatas = datas;
        inflater = LayoutInflater.from(mContext);

    }

    @Override
    public int getItemCount() {

        return mDatas.size();
    }

    //填充onCreateViewHolder方法返回的holder中的控件
    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {

        holder.tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final RecyclerView recyclerViewInner = initRecycleview(holder);
                int visibility = recyclerViewInner.getVisibility();
                if (visibility == View.GONE) {
                    recyclerViewInner.setVisibility(View.VISIBLE);
                } else {
                    recyclerViewInner.setVisibility(View.GONE);
                }
            }
        });
    }

    @NonNull
    private RecyclerView initRecycleview(MyViewHolder holder) {
        final RecyclerView recyclerView = holder.innerRv;
        recyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        ArrayList<String> strings = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            strings.add("1");
        }
        recyclerView.setAdapter(new CommonAdapter<String>(mContext, R.layout.item_prepayment_inner, strings) {

            @Override
            protected void convert(ViewHolder holder, String s, int position) {

            }
        });
        return recyclerView;
    }

    //重写onCreateViewHolder方法，返回一个自定义的ViewHolder
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.item_prepayment, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tv;
        RecyclerView innerRv;

        public MyViewHolder(View view) {
            super(view);
            tv = (TextView) view.findViewById(R.id.tv_instalments);
            innerRv = (RecyclerView) view.findViewById(R.id.inner_recyclerView);
        }

    }
}