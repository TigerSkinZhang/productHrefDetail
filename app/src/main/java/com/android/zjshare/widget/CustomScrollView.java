package com.android.zjshare.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;

/**
 * for productdetail
 * solve：recycler卡顿 渐变导航
 */
public class CustomScrollView extends ScrollView {

    public Callbacks mCallbacks;

    public CustomScrollView(Context context) {
        super(context);
    }

    public CustomScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);
        if (mCallbacks != null) {
            mCallbacks.onScrollChanged(l, t, oldl, oldt);
        }
    }
    public void setOnScrollChanged(Callbacks onScrollChanged) {
        this.mCallbacks = onScrollChanged;
    }
    //定义接口用于回调
    public interface Callbacks {
        void onScrollChanged(int x, int y, int oldx, int oldy);
    }

}
