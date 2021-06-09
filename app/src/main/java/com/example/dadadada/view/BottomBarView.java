package com.example.dadadada.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;

import com.example.dadadada.R;
import com.example.dadadada.mvvm.model.entity.BottomBarBean;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class BottomBarView extends View {

    private Paint bitMapBigPaint;
    private Paint bitMapCommonPaint;
    private Paint roundBackPaint;

    private Bitmap friendsBitmap;
    private Bitmap friendsCircleBitmap;
    private Bitmap favouriteBitmap;
    private Bitmap emailBitmap;
    private Bitmap cameraBitmap;

    private BottomBarScrollType bottomBarScrollType = BottomBarScrollType.NONE;

    private int padding = 20;
    private int defultWidth = 300;
    private int defultHeight = 80;
    /**
     * bitmap图片的宽高
     */
    private int bitmapWidth;
    private int bitmapHeight;


    private int nowX = 0;

    /**
     * 点击事件时判断是否滑动了
     */
    private boolean isMove = false;

    private Map<Bitmap, Rect> rectMap;

    private Rect cameraRect, emailRect, friendsRect, friendsCircleRect, favouriteRect;

    //每次滑动的值
    private int moveNum;
    //记录滑动之前的值
    private int beforeX = 0;
    //记录滑动的个数
    private int scrollNum = 0;
    private List<BottomBarBean> list;
    private List<Rect> baseRectList;

    private BottomBarBean baseBottomBarBean;

    private int position = 0;

    public BottomBarView(Context context) {
        this(context, null);
    }

    public BottomBarView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public BottomBarView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        baseRectList = new ArrayList<>();
        baseBottomBarBean = new BottomBarBean();
        list = new ArrayList<>();

        bitMapBigPaint = new Paint();
        bitMapCommonPaint = new Paint();
        roundBackPaint = new Paint();
        roundBackPaint.setColor(getResources().getColor(R.color.zsq));
        roundBackPaint.setAntiAlias(true);
        roundBackPaint.setStyle(Paint.Style.FILL);

        cameraBitmap = BitmapFactory.decodeResource(this.getContext().getResources(), R.mipmap.ic_camera);
        emailBitmap = BitmapFactory.decodeResource(this.getContext().getResources(), R.mipmap.ic_email);
        favouriteBitmap = BitmapFactory.decodeResource(this.getContext().getResources(), R.mipmap.ic_favourite);
        friendsBitmap = BitmapFactory.decodeResource(this.getContext().getResources(), R.mipmap.ic_friends);
        friendsCircleBitmap = BitmapFactory.decodeResource(this.getContext().getResources(), R.mipmap.ic_friendscircle);

        rectMap = new LinkedHashMap<>();
    }

    /**
     * 测量方法
     *
     * @param widthMeasureSpec
     * @param heightMeasureSpec
     */
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int width = MeasureSpec.getSize(widthMeasureSpec);
        int height = MeasureSpec.getSize(heightMeasureSpec);
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int heigthMode = MeasureSpec.getMode(heightMeasureSpec);

        //如果是warpcontent的话
        if (widthMode == MeasureSpec.AT_MOST) {
            width = defultWidth + padding * (2 * 6);
        }
        if (heigthMode == MeasureSpec.AT_MOST) {
            height = defultHeight + padding * 2;
        }
        setMeasuredDimension(width + padding * (2 * 6), height + padding * 2);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawRoundRect(0, 0, getWidth(), getHeight(), bitmapWidth, getHeight() / 5, roundBackPaint);
//        for(Map.Entry<Bitmap,Rect> entry : rectMap.entrySet()){
//            if( bottomBarScrollType==BottomBarScrollType.LEFTTORIGHT ){
//                int diff =  entry.getValue().right+(nowX%getWidth())-getWidth();//差值
//                canvas.drawBitmap(entry.getKey(),-(bitmapWidth-diff),getHeight()/2-bitmapHeight/2,bitMapCommonPaint);
//                canvas.drawBitmap(entry.getKey(),entry.getValue().left+(nowX%getWidth()),getHeight()/2-bitmapHeight/2,bitMapCommonPaint);
//            }else if( bottomBarScrollType==BottomBarScrollType.RIGHTTOLEFT ){
//                int diff =  entry.getValue().left-(nowX%getWidth())-getWidth();//差值
//                canvas.drawBitmap(entry.getKey(),-(bitmapWidth-diff),getHeight()/2-bitmapHeight/2,bitMapCommonPaint);
//                canvas.drawBitmap(entry.getKey(),entry.getValue().left+(nowX%getWidth()),getHeight()/2-bitmapHeight/2,bitMapCommonPaint);
//            }
//            else{
//                canvas.drawBitmap(entry.getKey(),entry.getValue().left+(nowX%getWidth()),getHeight()/2-bitmapHeight/2,bitMapCommonPaint);
//            }
//        }
//        Log.e("wyd", "onDraw: "+rectMap);
        for (Map.Entry<Bitmap, Rect> entry : rectMap.entrySet()) {
            if (bottomBarScrollType == BottomBarScrollType.LEFTTORIGHT) {
                //从左向右
                if (entry.getValue().right + moveNum > getWidth()) {
                    canvas.drawBitmap(entry.getKey(), (entry.getValue().right + moveNum) - getWidth() - bitmapWidth, entry.getValue().top, bitMapCommonPaint);
                }
                canvas.drawBitmap(entry.getKey(), entry.getValue().left + moveNum, entry.getValue().top, bitMapCommonPaint);
            } else if (bottomBarScrollType == BottomBarScrollType.RIGHTTOLEFT) {
                //从右向左
                if (entry.getValue().left + moveNum < 0) {
                    canvas.drawBitmap(entry.getKey(), getWidth() + (entry.getValue().left + moveNum), entry.getValue().top, bitMapCommonPaint);
                }
                canvas.drawBitmap(entry.getKey(), entry.getValue().left + moveNum, entry.getValue().top, bitMapCommonPaint);
            } else {
                //回归原位
                canvas.drawBitmap(entry.getKey(), entry.getValue().left, entry.getValue().top, bitMapCommonPaint);
            }

        }

//        canvas.drawBitmap(favouriteBitmap,favouriteRect.left,getHeight()/2-friendsBitmap.getHeight()/2,bitMapCommonPaint);
//        canvas.drawBitmap(friendsBitmap,friendsRect.left,getHeight()/2-friendsBitmap.getHeight()/2,bitMapCommonPaint);
//        canvas.drawBitmap(emailBitmap,emailRect.left,getHeight()/2-friendsBitmap.getHeight()/2,bitMapCommonPaint);
//        canvas.drawBitmap(friendsCircleBitmap,friendsCircleRect.left,getHeight()/2-friendsBitmap.getHeight()/2,bitMapCommonPaint);
//        canvas.drawBitmap(cameraBitmap,cameraRect.left,getHeight()/2-friendsBitmap.getHeight()/2,bitMapCommonPaint);

    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        bitmapWidth = (w - padding * 6) / 5;
        bitmapHeight = h - padding * 2;

        //当布局测量完成，我们对bitmap进行设置大小
        favouriteBitmap = imageScale(favouriteBitmap, bitmapWidth, bitmapHeight);
        emailBitmap = imageScale(emailBitmap, bitmapWidth, bitmapHeight);
        friendsBitmap = imageScale(friendsBitmap, bitmapWidth, bitmapHeight);
        friendsCircleBitmap = imageScale(friendsCircleBitmap, bitmapWidth, bitmapHeight);
        cameraBitmap = imageScale(cameraBitmap, bitmapWidth, bitmapHeight);

        for (int q = 0; q < 5; q++) {
            int left = bitmapWidth * q + padding * (q + 1);
            Rect rect = new Rect(left, padding, left + bitmapWidth, bitmapHeight + padding);
            switch (q) {
                case 0:
                    favouriteRect = rect;
                    rectMap.put(favouriteBitmap, favouriteRect);
                    list.add(new BottomBarBean(favouriteBitmap, favouriteRect));
                    baseRectList.add(favouriteRect);
                    break;
                case 1:
                    friendsRect = rect;
                    rectMap.put(friendsBitmap, friendsRect);
                    list.add(new BottomBarBean(friendsBitmap, friendsRect));
                    baseRectList.add(friendsRect);

                    break;
                case 2:
                    emailRect = rect;
                    rectMap.put(emailBitmap, emailRect);
                    list.add(new BottomBarBean(emailBitmap, emailRect));
                    baseRectList.add(emailRect);
                    break;
                case 3:
                    friendsCircleRect = rect;
                    rectMap.put(friendsCircleBitmap, friendsCircleRect);
                    list.add(new BottomBarBean(friendsCircleBitmap, friendsCircleRect));
                    baseRectList.add(friendsCircleRect);
                    break;
                case 4:
                    cameraRect = rect;
                    rectMap.put(cameraBitmap, cameraRect);
                    list.add(new BottomBarBean(cameraBitmap, cameraRect));
                    baseRectList.add(cameraRect);
                    break;
            }

        }

    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {

        int x = (int) event.getX();
        int y = (int) event.getY();

        switch (event.getAction()) {
            case MotionEvent.ACTION_UP:

            case MotionEvent.ACTION_CANCEL:
                //每次滑动抬起之后重新归零
                /**
                 * 在这里判断向左滑还是向右滑，最后调换map集合的位置就可以了
                 * 用滑动的绝对值来判断是向左滑或向右滑几个位置，根据这几个位置来变化map集合就可以了
                 */
                if (moveNum > 0) {
                    bottomBarScrollType = BottomBarScrollType.LEFTTORIGHT;
                } else {
                    bottomBarScrollType = BottomBarScrollType.RIGHTTOLEFT;
                }
                scrollNum = Math.abs(moveNum) / (bitmapWidth + padding);
//                Log.d("wyd", "onTouchEvent: scrollNum->"+scrollNum);
                if (scrollNum != 0) {
                    if (scrollNum >= 5) {
                        scrollNum = 5;
                    }
                    changeMap();
                }
                beforeX = 0;
                moveNum = 0;
                bottomBarScrollType = BottomBarScrollType.NONE;
                /**
                 * onClick
                 * 1->favourite
                 * 2->friend
                 * 3->email
                 * 4->friendCircle
                 * 5->camera
                 */
                if (mOnBottomBarClickListener != null && !isMove) {
                    for (Map.Entry<Bitmap, Rect> entry : rectMap.entrySet()) {
                        if (entry.getValue().contains(x, y)) {
                            if (entry.getKey() == cameraBitmap) {
//                                Log.d("123", "onTouchEvent: camera");
                                mOnBottomBarClickListener.onCLick(5);
                            } else if (entry.getKey() == favouriteBitmap) {
//                                Log.d("www", "onTouchEvent: favourite");
                                mOnBottomBarClickListener.onCLick(1);
                            } else if (entry.getKey() == friendsBitmap) {
//                                Log.d("www", "onTouchEvent: friend");
                                mOnBottomBarClickListener.onCLick(2);
                            } else if (entry.getKey() == emailBitmap) {
//                                Log.d("www", "onTouchEvent: email");
                                mOnBottomBarClickListener.onCLick(3);
                            } else if (entry.getKey() == friendsCircleBitmap) {
//                                Log.d("www", "onTouchEvent: friendCircle");
                                mOnBottomBarClickListener.onCLick(4);

                            }
                            break;
                        }
                    }
                }
                break;
            case MotionEvent.ACTION_MOVE:
                isMove = true;
                if (beforeX != 0) {
                    moveNum += x - beforeX;
                    if (moveNum > 0) {
                        bottomBarScrollType = BottomBarScrollType.LEFTTORIGHT;
                    } else {
                        bottomBarScrollType = BottomBarScrollType.RIGHTTOLEFT;
                    }
                }
                beforeX = x;
                break;
            case MotionEvent.ACTION_DOWN:
                isMove = false;
                break;

        }

        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            invalidate();//主线程
        } else {
            postInvalidate();//子线程
        }

        return true;
    }

    private void changeMap() {
        position = 0;
        if (bottomBarScrollType == BottomBarScrollType.LEFTTORIGHT) {
            //从左到右
            /**
             * 先通过滑动距离将bitmap排序出来，然后跟实际位置的rect一一对应
             */
            for (Map.Entry<Bitmap, Rect> entry : rectMap.entrySet()) {
                baseBottomBarBean = new BottomBarBean(entry.getKey(), entry.getValue());
                list.remove((position + scrollNum) % 5);
                list.add((position + scrollNum) % 5, baseBottomBarBean);
                position++;
            }
//            Log.d("wyd", "changeMap: "+list);
            rectMap.clear();
            for (int q = 0; q < list.size(); q++) {
                rectMap.put(list.get(q).getBitmap(), baseRectList.get(q));
            }

        } else {
            /**
             * 先通过滑动距离将bitmap排序出来，然后跟实际位置的rect一一对应
             */
            //从右到左
            for (Map.Entry<Bitmap, Rect> entry : rectMap.entrySet()) {
                baseBottomBarBean = new BottomBarBean(entry.getKey(), entry.getValue());
                if (position - scrollNum >= 0) {
                    list.remove(position - scrollNum);
                    list.add((position - scrollNum), baseBottomBarBean);
                } else {
                    list.remove(position - scrollNum + 5);
                    list.add((position - scrollNum + 5), baseBottomBarBean);
                }
                position++;

            }
            rectMap.clear();
            position = 0;
//            Log.d("wyd", "changeMap(list): "+list);
            for (int q = 0; q < list.size(); q++) {
                rectMap.put(list.get(q).getBitmap(), baseRectList.get(q));
            }
//            for(Map.Entry<Bitmap,Rect> entry : rectMap.entrySet()){
//                if( scrollNum<=0 ){
//                    rectMap.put(entry.getKey(),list.get(position).getRect());
//                    position++;
//                }else{
//                    rectMap.put(entry.getKey(),list.get(list.size()-scrollNum).getRect());
//                    Log.e("TAG", "changeMap: "+entry.getKey()+"****"+list.get(list.size()-scrollNum).getRect());
//                    scrollNum--;
//                }
//                //****
////                rectMap.put(entry.getKey(),list.get(position).getRect());
////                position++;
//            }
//            Log.d("wyd", "changeMap(map): "+rectMap);
        }
    }

    /**
     * 调整图片大小
     *
     * @param bitmap 源
     * @param dst_w  输出宽度
     * @param dst_h  输出高度
     * @return
     */
    public static Bitmap imageScale(Bitmap bitmap, int dst_w, int dst_h) {
        int src_w = bitmap.getWidth();
        int src_h = bitmap.getHeight();
        float scale_w = ((float) dst_w) / src_w;
        float scale_h = ((float) dst_h) / src_h;
        Matrix matrix = new Matrix();
        matrix.postScale(scale_w, scale_h);
        Bitmap dstbmp = Bitmap.createBitmap(bitmap, 0, 0, src_w, src_h, matrix, true);
        return dstbmp;
    }

    public OnBottomBarClickListener mOnBottomBarClickListener;

    public void setmOnBottomBarClickListener(OnBottomBarClickListener mOnBottomBarClickListener) {
        this.mOnBottomBarClickListener = mOnBottomBarClickListener;
    }

    public interface OnBottomBarClickListener {
        void onCLick(int position);
    }

}
