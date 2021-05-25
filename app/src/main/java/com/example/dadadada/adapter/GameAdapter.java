package com.example.dadadada.adapter;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.dadadada.R;
import com.example.dadadada.entity.GameEntity;

import java.util.List;

public class GameAdapter extends BaseQuickAdapter<GameEntity, BaseViewHolder> {
    public GameAdapter(int layoutResId, @Nullable List<GameEntity> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, GameEntity item) {
        helper.setText(R.id.game_text,item.getName());
    }
}
