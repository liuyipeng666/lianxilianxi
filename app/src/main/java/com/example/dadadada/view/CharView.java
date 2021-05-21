package com.example.dadadada.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;



public class CharView extends ViewGroup {
    private int viewWidth, viewHeight = 0;
    private int x, y = 0;

    public CharView(Context context) {
        super(context);
    }

    public CharView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CharView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        measureChildren(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View view = getChildAt(i);
            int measuredWidth = view.getMeasuredWidth();
            int measuredHeight = view.getMeasuredHeight();
            if (x + measuredWidth > viewWidth) {
                x = 0;
                y = y + measuredHeight;
            }
            layout(x,y,x+measuredWidth,y+measuredHeight);
            x=x+measuredWidth;
        }
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        viewWidth = w;
        viewHeight = h;

    }
}
