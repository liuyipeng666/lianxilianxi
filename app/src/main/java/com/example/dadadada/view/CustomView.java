package com.example.dadadada.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

import com.example.dadadada.R;

public class CustomView extends ViewGroup {
    /**
     * 起始x,y坐标
     */
    private int x=150;
    private int  y = 0;
    /**
     * 当前viewGroup的宽高
     */
    private int layoutWidth, layoutHeight = 0;
    /**
     * 如果x超出viewGroup的宽
     */
    private int yStep = 100;
    private int xSpace,ySpace=0;
    public CustomView(Context context) {
        super(context);
    }

    public CustomView(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.CustomView);
        xSpace = typedArray.getInteger(R.styleable.CustomView_xSpace, 0);
        ySpace = typedArray.getInteger(R.styleable.CustomView_ySpace, 0);
        typedArray.recycle();
    }

    public CustomView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        measureChildren(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        layoutWidth = w;
        layoutHeight = h;
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        //  获取当前ViewGroup中的子控件个数
        int childCount = getChildCount();
        //循环遍历
        for (int i = 0; i < childCount; i++) {
            //根据索引获取具体的View
            View view = getChildAt(i);
            //layout方法传递 4个参数  左上右下
            int viewWidth = view.getMeasuredWidth()/2;
            int viewHeight = view.getMeasuredHeight()/2;

            //如果当前的x不大于viewGroup的宽  x累加   否则 x=0 y累加
            if ((x + viewWidth+xSpace)> layoutWidth) {
                x=0;
                y = y + viewHeight+(ySpace);
            }

            view.layout(x+xSpace, y+ySpace,x+viewWidth+xSpace, y+viewHeight+ySpace);
            x=x+viewWidth+xSpace;
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }
}
