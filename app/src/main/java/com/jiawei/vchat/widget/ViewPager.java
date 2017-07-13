package com.jiawei.vchat.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * 可设置是否启用翻页的 ViewPager
 */
public class ViewPager extends android.support.v4.view.ViewPager {

  private boolean isPagingEnabled = true;

  public ViewPager(Context context) {
    super(context);
  }

  public ViewPager(Context context, AttributeSet attrs) {
    super(context, attrs);
  }

  @Override public boolean onTouchEvent(MotionEvent event) {
    return this.isPagingEnabled && super.onTouchEvent(event);
  }

  @Override public boolean onInterceptTouchEvent(MotionEvent event) {
    return this.isPagingEnabled && super.onInterceptTouchEvent(event);
  }

  /**
   * 设置 ViewPager 是否启用翻页
   */
  public void setPagingEnabled(boolean b) {
    this.isPagingEnabled = b;
  }
}