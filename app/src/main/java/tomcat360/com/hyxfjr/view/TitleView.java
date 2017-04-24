package tomcat360.com.hyxfjr.view;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


import java.lang.ref.WeakReference;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import tomcat360.com.hyxfjr.R;
import tomcat360.com.hyxfjr.mvp_m.G;

public class TitleView extends FrameLayout implements View.OnClickListener {
	/**
	 * 标题上方沉浸式空白栏
	 */
	@Bind(R.id.blank)
	LinearLayout blank;
	/**
	 * 左上角返回按钮
	 */
	@Bind(R.id.left_btn)
	ImageView mLeftBtn;

	@Bind(R.id.small_title_text)
	TextView mTitle;
	@Bind(R.id.left_btn1)
	ImageView hLeftBtn;
	@Bind(R.id.title_text)
	TextView bTitle;
	@Bind(R.id.right_text)
	TextView mRightText;
	@Bind(R.id.right_btn)
	ImageView mRightbtn;
	@Bind(R.id.title_view)
	LinearLayout titleView;

	private OnLeftButtonClickListener mOnLeftButtonClickListener;
	private OnRightButtonClickListener mOnRightButtonClickListener;
	private OnmTitleClickListener mTitleClickListener;

	private Activity activity;



	public interface OnLeftButtonClickListener {
		void onClick(View button);
	}

	public interface OnRightButtonClickListener {
		void onClick(View button);
	}

	public interface OnSortButtonClickListener {
		void onClick(View button);
	}

	public interface OnSelfLeftButtonClickListener {
		void onClick(View button);
	}


	public interface OnRTextClickListener {
		void onClick(View text);
	}

	public interface OnmTitleClickListener {
		void onClick(View text);
	}


	public void setLeftButton(OnLeftButtonClickListener listener) {
		mLeftBtn.setVisibility(View.VISIBLE);
		mOnLeftButtonClickListener = listener;
	}

	/**
	 * @param context
	 */
	public void clickLeftGoBack(final WeakReference<Activity> context) {
		mLeftBtn.setVisibility(View.VISIBLE);
		mOnLeftButtonClickListener = new OnLeftButtonClickListener() {
			@Override
			public void onClick(View button) {
				context.get().finish();
			}
		};
	}

	public void clickLeftGoBack(int imgResource,final WeakReference<Activity> context) {
		mLeftBtn.setVisibility(View.VISIBLE);
		mLeftBtn.setImageResource(imgResource);
		mOnLeftButtonClickListener = new OnLeftButtonClickListener() {
			@Override
			public void onClick(View button) {
				context.get().finish();
			}
		};
	}
	public void setRightButton(String str, OnRightButtonClickListener listener) {
		mRightText.setText(str);
		mRightText.setVisibility(View.VISIBLE);
		mRightbtn.setVisibility(View.GONE);
		mOnRightButtonClickListener = listener;
	}

	public void setRightButton(String str) {
		mRightText.setText(str);
	}

	public void setRightImageButton(int srcId, OnRightButtonClickListener listener) {
		mRightText.setVisibility(View.GONE);
		mRightbtn.setVisibility(View.VISIBLE);
		mRightbtn.setImageResource(srcId);
		mOnRightButtonClickListener = listener;
	}

	public TitleView(Context context) {
		this(context, null);
	}

	public TitleView(Context context, AttributeSet attrs) {
		this(context, attrs, 0);
	}

	public TitleView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		if (isInEditMode()) {
			return;
		}
		LayoutInflater inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		inflater.inflate(R.layout.title_view, this, true);
		ButterKnife.bind(this);
		if (G.SYSTEM_SDK_API < 19) {
			blank.setVisibility(View.GONE);
		} else {
			blank.setVisibility(View.VISIBLE);
		}
		mLeftBtn.setVisibility(View.INVISIBLE);
		mLeftBtn.setOnClickListener(this);
		mRightText.setVisibility(View.GONE);
		mRightText.setOnClickListener(this);
		mRightbtn.setVisibility(View.INVISIBLE);
		mRightbtn.setOnClickListener(this);
		hLeftBtn.setVisibility(View.GONE);
		hLeftBtn.setOnClickListener(this);
		mTitle.setVisibility(View.GONE);
		bTitle.setVisibility(View.INVISIBLE);
		mTitle.setOnClickListener(this);
	}

	public void setHeight(int height) {
		titleView.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,
				height));
	}


	// webview使用
	public void setwTitle(String text, Activity context, OnmTitleClickListener m) {
		mTitle.setVisibility(View.VISIBLE);
		mTitle.setText(text);
		activity = context;
		mTitleClickListener = m;

	}

	public void setTitle(int stringID, Activity context) {
		mTitle.setVisibility(View.VISIBLE);
		mTitle.setText(stringID);
		activity = context;
		mTitle.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				activity.finish();
			}
		});
	}

	public void setTitleColor() {
		mTitle.setTextColor(Color.rgb(0x00, 0x00, 0x00));
		titleView.setBackgroundColor(Color.rgb(0xf7, 0xf7, 0xf7));
		// mRightText.setTextColor(Color.rgb(0xff, 0xff, 0xff));
	}

	// 居中标题设置
	public void setBTitle(int stringID) {
		bTitle.setVisibility(View.VISIBLE);
		bTitle.setText(stringID);

	}

	// 居中标题设置
	public void setBTitle(String stringID) {
		bTitle.setVisibility(View.VISIBLE);
		bTitle.setText(stringID);

	}

	// 居中标题设置String
	public void setStringBTitle(String str) {
		bTitle.setVisibility(View.VISIBLE);
		bTitle.setText(str);
	}

	public void setBTitleColor() {
		bTitle.setTextColor(Color.rgb(0x00, 0x00, 0x00));
		// TextPaint tpPaint = bTitle.getPaint();
		// tpPaint.setFakeBoldText(true); // 加粗
		titleView.setBackgroundColor(Color.rgb(0xf7, 0xf7, 0xf7));
		// mRightText.setTextColor(Color.rgb(0xff, 0xff, 0xff));
	}

	/**
	 * 设置背景颜色
	 * @param color
     */
	public void setBackgroundColor(int color) {
		titleView.setBackgroundColor(color);
	}

	@OnClick({R.id.left_btn, R.id.small_title_text, R.id.right_text, R.id.right_btn})
	public void onClick(View view) {
		switch (view.getId()) {
			case R.id.left_btn:
				if (mOnLeftButtonClickListener != null)
					mOnLeftButtonClickListener.onClick(view);
				break;
			case R.id.small_title_text:
				if (mTitleClickListener != null)
					mTitleClickListener.onClick(view);
				break;
			case R.id.right_text:
			case R.id.right_btn:
				if (mOnRightButtonClickListener != null)
					mOnRightButtonClickListener.onClick(view);
				break;
		}
	}
}
