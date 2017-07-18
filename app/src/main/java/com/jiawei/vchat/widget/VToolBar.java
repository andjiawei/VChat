package com.jiawei.vchat.widget;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.TextView;

import com.jiawei.vchat.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by jiawei on 2017/7/17.
 */

public class VToolBar extends Toolbar {
    @BindView(R.id.tv_toolbar_title)
    TextView title;
    @BindView(R.id.toolbar_search)
    ImageView search;
    @BindView(R.id.toolbar_add)
    ImageView add;

    public VToolBar(Context context) {
        super(context);
        init();
    }

    public VToolBar(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public VToolBar(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.tool_bar,this);
        ButterKnife.bind(this);
        setContentInsetsRelative(0,0);
        title.setText("微信");
    }
}
