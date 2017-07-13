package com.jiawei.vchat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.jiawei.vchat.R;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * 主页的底部导航tab
 */
public class TabBar extends LinearLayout {

    @BindView(R.id.iv_icon)
    ImageView mIvIcon;
    @BindView(R.id.tv_icon_text)
    TextView mTvIcon;

//  private final ImageView icon;
//  private final View line;

    public TabBar(Context context) {
        this(context, null);
    }

    public TabBar(Context context, AttributeSet attrs) {
        this(context, attrs, -1);
    }

    public TabBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setOrientation(LinearLayout.VERTICAL);
        setGravity(Gravity.CENTER);
        LayoutInflater.from(getContext()).inflate(R.layout.tabbar, this);
        ButterKnife.bind(this);
//    icon = ((ImageView) findViewById(R.id.icon));
//    line = findViewById(R.id.line);
        if (attrs != null) {
            TypedArray a = context.getTheme().obtainStyledAttributes(attrs, R.styleable.TabBar, 0, 0);
            int drawableResource = a.getResourceId(R.styleable.TabBar_tbSrc, -1);
            String textResource = a.getString(R.styleable.TabBar_tbText);

            if (TextUtils.isEmpty(textResource)) {
                throw new RuntimeException("please define bottom text");
            }
            mTvIcon.setText(textResource);
            if (-1 != drawableResource) {
                mIvIcon.setImageResource(drawableResource);
            }

        }
    }

}
