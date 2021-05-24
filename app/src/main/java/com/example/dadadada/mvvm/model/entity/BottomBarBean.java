package com.example.dadadada.mvvm.model.entity;

import android.graphics.Bitmap;
import android.graphics.Rect;

public class BottomBarBean {
    private Bitmap bitmap;
    private Rect rect;

    public BottomBarBean() {
    }

    public BottomBarBean(Bitmap bitmap, Rect rect) {
        this.bitmap = bitmap;
        this.rect = rect;
    }

    @Override
    public String toString() {
        return "BottomBarBean{" +
                "bitmap=" + bitmap +
                ", rect=" + rect +
                '}';
    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }

    public Rect getRect() {
        return rect;
    }

    public void setRect(Rect rect) {
        this.rect = rect;
    }
}
