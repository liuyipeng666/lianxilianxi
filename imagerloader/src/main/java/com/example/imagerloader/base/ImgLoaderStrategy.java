package com.example.imagerloader.base;

import android.content.Context;

import com.example.imagerloader.setting.ImageSetting;

public interface ImgLoaderStrategy<Setting extends ImageSetting> {
    /**
     * 加载图片
     * @param context
     * @param setting
     */
    void loadImage(Context context,Setting setting);
}
