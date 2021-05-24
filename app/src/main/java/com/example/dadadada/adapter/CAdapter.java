package com.example.dadadada.adapter;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.dadadada.R;
import com.example.dadadada.common.ConstactEntity;

import java.util.List;

public
class CAdapter extends BaseQuickAdapter<ConstactEntity, BaseViewHolder> {
    public CAdapter(int layoutResId, @Nullable List<ConstactEntity> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, ConstactEntity item) {
        helper.setText(R.id.c_text1,item.getName());
    }
}
