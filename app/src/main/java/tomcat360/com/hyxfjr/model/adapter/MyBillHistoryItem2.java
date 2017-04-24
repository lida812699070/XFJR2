package tomcat360.com.hyxfjr.model.adapter;

import com.zhy.adapter.recyclerview.base.ItemViewDelegate;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import tomcat360.com.hyxfjr.R;
import tomcat360.com.hyxfjr.model.entity.MyBillHistory;

/**
 * Created by Administrator on 2017/4/20 0020.
 */

public class MyBillHistoryItem2 implements ItemViewDelegate<MyBillHistory> {
    @Override
    public int getItemViewLayoutId() {
        return R.layout.item_history_bill_2;
    }

    @Override
    public boolean isForViewType(MyBillHistory item, int position) {
        return item.getType() == 2;
    }

    @Override
    public void convert(ViewHolder holder, MyBillHistory chatMessage, int position) {
        holder.setText(R.id.tv_month_bill, chatMessage.getMonth());
        holder.setText(R.id.tv_time, chatMessage.getTime());
        holder.setText(R.id.tv_money, chatMessage.getMoney() + "");
    }
}
