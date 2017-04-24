package tomcat360.com.hyxfjr.model.adapter;

import com.zhy.adapter.recyclerview.base.ItemViewDelegate;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import tomcat360.com.hyxfjr.R;
import tomcat360.com.hyxfjr.model.entity.MyBillHistory;

/**
 * Created by zhy on 16/6/22.
 */
public class MyBillHistoryItem1 implements ItemViewDelegate<MyBillHistory> {

    @Override
    public int getItemViewLayoutId() {
        return R.layout.item_history_bill_1;
    }

    @Override
    public boolean isForViewType(MyBillHistory item, int position) {
        return item.getType() == 1;
    }

    @Override
    public void convert(ViewHolder holder, MyBillHistory chatMessage, int position) {
        holder.setText(R.id.tv_year, chatMessage.getYear());
    }
}