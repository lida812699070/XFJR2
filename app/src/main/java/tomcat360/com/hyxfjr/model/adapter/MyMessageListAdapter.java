package tomcat360.com.hyxfjr.model.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import tomcat360.com.hyxfjr.R;

/**
 * Created by Administrator on 2017/4/19 0019.
 */

public class MyMessageListAdapter extends RecyclerView.Adapter<MyMessageListAdapter.MyViewHolder> {

    private Context context;
    private List<String> mDatas;
    //是否显示单选框,默认false
    private boolean isshowBox = false;
    // 存储勾选框状态的map集合
    private Map<Integer, Boolean> map = new HashMap<>();

    public MyMessageListAdapter(Context context, List<String> mDatas) {
        this.context = context;
        this.mDatas = mDatas;
        initMap();

    }

    public Map<Integer, Boolean> getMap() {
        return map;
    }

    private void initMap() {
        for (int i = 0; i < mDatas.size(); i++) {
            map.put(i, false);
        }
    }

    public void editCheck(boolean isshowBox) {
        this.isshowBox = isshowBox;
        notifyDataSetChanged();
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MyViewHolder holder = new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.item_my_message, parent,
                false));
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        //设置checkBox改变监听
        holder.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                //用map集合保存
                map.put(position, isChecked);
            }
        });
        // 设置CheckBox的状态
        if (map.get(position) == null) {
            map.put(position, false);
        }
        holder.checkBox.setChecked(map.get(position));
        if (isshowBox) {
            holder.checkBox.setVisibility(View.VISIBLE);
        } else {
            holder.checkBox.setVisibility(View.INVISIBLE);
        }
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    public void markAll() {
        for (int i = 0; i < map.size(); i++) {
            map.put(i, true);
        }
        notifyDataSetChanged();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        CheckBox checkBox;

        public MyViewHolder(View view) {
            super(view);
            checkBox = (CheckBox) view.findViewById(R.id.checkbox);
        }
    }
}
