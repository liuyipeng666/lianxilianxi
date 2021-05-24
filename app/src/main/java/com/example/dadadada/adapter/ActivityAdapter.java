package com.example.dadadada.adapter;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.dadadada.R;
import com.example.dadadada.mvvm.model.entity.ActivityEntity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class ActivityAdapter extends BaseQuickAdapter<ActivityEntity, BaseViewHolder> {
    public ActivityAdapter(int layoutResId, @Nullable List<ActivityEntity> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, ActivityEntity item) {
        helper.setText(R.id.item_starttime, item.getStarttime() + "");

    }

}
