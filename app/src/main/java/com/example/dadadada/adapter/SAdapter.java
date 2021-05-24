package com.example.dadadada.adapter;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.dadadada.R;

import java.util.List;

public
class SAdapter extends BaseQuickAdapter<String, BaseViewHolder> {

    public SAdapter(int layoutResId, @Nullable List<String> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
        helper.setText(R.id.xyz_text,item);
    }
}
