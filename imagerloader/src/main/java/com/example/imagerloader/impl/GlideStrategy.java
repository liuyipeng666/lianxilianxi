package com.example.imagerloader.impl;

import android.content.Context;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.example.imagerloader.base.ImgLoaderStrategy;
import com.example.imagerloader.setting.NormalImageSetting;

public class GlideStrategy implements ImgLoaderStrategy<NormalImageSetting> {
    @Override
    public void loadImage(Context context, NormalImageSetting setting) {
        RequestOptions requestOptions = null;
        if (setting.getImRadius()>0){
            requestOptions = RequestOptions.bitmapTransform(new RoundedCorners(setting.getImRadius()));
        }
        else{
            requestOptions = new RequestOptions();
        }

        if (setting.getmPlaceholder()>0){
            requestOptions.placeholder(setting.getmPlaceholder());
            requestOptions.error(setting.getmPlaceholder());
        }

        Glide.with(context).load(setting.getmUrl()).apply(requestOptions).into(setting.getmView());
    }
}
