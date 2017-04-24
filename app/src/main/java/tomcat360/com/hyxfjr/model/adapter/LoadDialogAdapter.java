package tomcat360.com.hyxfjr.model.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

import tomcat360.com.hyxfjr.R;

/**
 * Created by Administrator on 2017/4/15 0015.
 */

public class LoadDialogAdapter extends BaseAdapter {

    private LayoutInflater mInflater;
    private List<String> mData;

    public LoadDialogAdapter(Context context, List<String> mData) {
        this.mInflater = LayoutInflater.from(context);
        this.mData = mData;
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return mData.size();
    }

    @Override
    public Object getItem(int i) {
        return mData.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder = null;
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.item_load_dialog, null);
            holder = new ViewHolder();

            convertView.setTag(holder);

        } else {

            holder = (ViewHolder) convertView.getTag();
        }


        return convertView;
    }

    public final class ViewHolder {
    }

}
