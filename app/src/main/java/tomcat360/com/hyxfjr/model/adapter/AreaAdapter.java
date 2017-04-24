package tomcat360.com.hyxfjr.model.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;


import java.util.List;

import tomcat360.com.hyxfjr.R;
import tomcat360.com.hyxfjr.model.entity.AreaBean;

/**
 * Title:AreaAdapter
 * Package:com.tomcat360.zjz.erp.adapter
 * Description:TODO
 * Author: llj@tomcat360.com
 * Date: 2016/10/21
 * Version: V1.0.0
 * 版本号修改日期修改人修改内容
 */

public class AreaAdapter extends BaseAdapter {
    private Context mContext;
    private List<AreaBean.DataEntity> datas;

    private int currentItem = 0;

    public List<AreaBean.DataEntity> getDatas() {
        return datas;
    }

    public void setDatas(List<AreaBean.DataEntity> datas) {
        this.datas = datas;
    }

    public AreaAdapter(Context mContext) {
        super();
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        return datas.size();
    }

    @Override
    public Object getItem(int position) {
        return datas.get(position);
    }

    @Override
    public long getItemId(int position) {

        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.list_item_address_dialog, null);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.show(datas.get(position));

        if (currentItem == position) {
            convertView.setSelected(true);
            convertView.setPressed(true);
            convertView.setBackgroundResource(R.color.list_item_color_pressed);

        } else {
            convertView.setBackgroundResource(R.color.list_item_color_normal);
        }
        return convertView;
    }

    private class ViewHolder {
        TextView provinceView;

        public ViewHolder(View containerView) {
            this.provinceView = (TextView) containerView.findViewById(R.id.item_address_dialog_textView);
        }

        public void show(AreaBean.DataEntity item) {
            this.provinceView.setText(item.getName());
        }
    }

    public void setCurrentChoise(int currentChoise) {
        currentItem = currentChoise;
    }

    public int getCurrentItem() {return currentItem;}
}
