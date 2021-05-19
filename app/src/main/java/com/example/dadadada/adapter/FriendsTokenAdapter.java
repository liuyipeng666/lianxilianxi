package com.example.dadadada.adapter;


import android.view.View;
import android.widget.ImageView;

import androidx.annotation.Nullable;

import com.amap.api.maps.model.Circle;
import com.amap.api.maps.model.CircleOptions;
import com.amap.api.services.traffic.CircleTrafficQuery;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.dadadada.R;
import com.example.dadadada.register.model.entity.FriendsEntity;

import java.util.List;

public class FriendsTokenAdapter extends BaseQuickAdapter<FriendsEntity, BaseViewHolder> {


    public FriendsTokenAdapter(int layoutResId, @Nullable List<FriendsEntity> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, FriendsEntity item) {
        ImageView imageView = helper.getView(R.id.item_img);

        Glide.with(mContext)
                .load(item.getHeadimg())
                .apply(new RequestOptions().circleCrop())
                .into(imageView);
        helper.setText(R.id.item_name, item.getNick() + "");
    }
}
