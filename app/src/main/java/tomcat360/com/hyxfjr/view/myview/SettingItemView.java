package tomcat360.com.hyxfjr.view.myview;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import tomcat360.com.hyxfjr.R;

/**
 * Created by Administrator on 2017/4/16 0016.
 */

public class SettingItemView extends RelativeLayout {
    private TextView tvTitle;

    public SettingItemView(Context context) {
        this(context, null);
    }

    public SettingItemView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context,attrs,defStyleAttr);
    }

    private void init(Context context, AttributeSet attrs, int defStyleAttr) {
        View itemView = View.inflate(getContext(), R.layout.view_setting_item, this);
        tvTitle = (TextView) itemView.findViewById(R.id.setting_item_title);
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.SettingItemView);
        String title = ta.getString(R.styleable.SettingItemView_titleSettingItem);
        tvTitle.setText(title);
        ta.recycle();
    }

    public SettingItemView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public void setTitle(String title){
        tvTitle.setText(title);
    }

}
