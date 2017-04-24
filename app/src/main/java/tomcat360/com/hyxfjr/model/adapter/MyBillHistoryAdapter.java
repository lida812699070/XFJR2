package tomcat360.com.hyxfjr.model.adapter;

import android.content.Context;

import com.zhy.adapter.recyclerview.MultiItemTypeAdapter;

import java.util.List;

import tomcat360.com.hyxfjr.model.entity.MyBillHistory;

/**
 * Created by zhy on 15/9/4.
 */
public class MyBillHistoryAdapter extends MultiItemTypeAdapter<MyBillHistory>
{
    public MyBillHistoryAdapter(Context context, List<MyBillHistory> datas)
    {
        super(context, datas);

        addItemViewDelegate(new MyBillHistoryItem2());
        addItemViewDelegate(new MyBillHistoryItem1());
    }
}