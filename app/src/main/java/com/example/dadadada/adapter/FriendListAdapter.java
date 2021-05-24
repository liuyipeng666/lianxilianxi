package com.example.dadadada.adapter;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.dadadada.R;
import com.example.dadadada.mvvm.model.entity.FriendListEntity;

import java.util.List;

public class FriendListAdapter extends BaseQuickAdapter<FriendListEntity, BaseViewHolder> {
    public FriendListAdapter(int layoutResId, @Nullable List<FriendListEntity> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, FriendListEntity item) {
        helper.setText(R.id.item_name, item.getNick() + "");
    }
}
