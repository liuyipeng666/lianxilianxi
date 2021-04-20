package com.example.imagerloader;

import android.content.Context;

import com.example.imagerloader.base.ImgLoaderStrategy;
import com.example.imagerloader.impl.GlideStrategy;
import com.example.imagerloader.setting.ImageSetting;

public class ImageLoader {
    private ImgLoaderStrategy imgLoaderStrategy;

    //单例
    private volatile static ImageLoader instance = null;
    private ImageLoader() {
        //默认启动
        imgLoaderStrategy = new GlideStrategy();
    }
    public static ImageLoader getInstance(){
        if (null == instance){
            synchronized (ImageLoader.class){
                if (null == instance){
                    instance = new ImageLoader();
                }
            }
        }
        return instance;
    }

    /**
     * 加载图片
     * @param context
     * @param setting
     */
    public void loadImage(Context context, ImageSetting setting){
        if (null == imgLoaderStrategy){
            throw new NullPointerException("imgLoaderStrategy is null");
        }
        if (null == context){
            throw new IllegalArgumentException("context is null");
        }
        if (null == setting){
            throw new IllegalArgumentException("setting is null");
        }
        imgLoaderStrategy.loadImage(context,setting);
    }

    public void initStrategy(ImgLoaderStrategy _imgLoaderStrategy){
        this.imgLoaderStrategy = _imgLoaderStrategy;
    }

    public ImgLoaderStrategy getImgLoaderStrategy(){
        return this.imgLoaderStrategy;
    }
}
