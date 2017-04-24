package tomcat360.com.hyxfjr.view.myview;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.jiongbull.jlog.JLog;

import tomcat360.com.hyxfjr.R;

/**
 * Created by Administrator on 2017/4/13 0013.
 */

public class MineItemView extends RelativeLayout {

    private TextView tvTitle;
    private ImageView ivLeft;
    private TextView tvRight;

    public MineItemView(Context context) {
        this(context, null);
    }

    public MineItemView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context,attrs,defStyleAttr);
    }

    private void init(Context context, AttributeSet attrs, int defStyleAttr) {
        View itemView = View.inflate(getContext(), R.layout.item_mine, this);
        tvTitle = (TextView) itemView.findViewById(R.id.mine_item_title);
        tvRight = (TextView) itemView.findViewById(R.id.mine_item_right);
        ivLeft = (ImageView) itemView.findViewById(R.id.mine_item_left);

        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.MineItemView);

        String textRight = ta.getString(R.styleable.MineItemView_textRight);
        String title = ta.getString(R.styleable.MineItemView_title);
        int resourceId = ta.getResourceId(R.styleable.MineItemView_image, -1);
        tvRight.setText(textRight);
        tvTitle.setText(title);
        if (resourceId==-1){
            JLog.e("-1");
        }else {
            ivLeft.setImageResource(resourceId);
        }
        ta.recycle();
    }

    public MineItemView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public void setTitle(String title){
        tvTitle.setText(title);
    }

    public void setTextRight(String strRight){
        tvRight.setText(strRight);
    }
}
