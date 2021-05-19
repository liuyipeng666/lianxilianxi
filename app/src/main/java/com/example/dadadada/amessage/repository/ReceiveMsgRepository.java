package com.example.dadadada.amessage.repository;

import androidx.lifecycle.LiveData;

import com.example.core.BaseRepository;
import com.example.dadadada.amessage.entity.ReceiveMsgEntity;
import com.example.dadadada.amessage.model.ReceiveMsgModel;
import com.example.net.retrofit.BaseRespEntity;

public class ReceiveMsgRepository extends BaseRepository<ReceiveMsgModel> {
    @Override
    protected ReceiveMsgModel createModel() {
        return new ReceiveMsgModel();
    }

    public LiveData<BaseRespEntity<ReceiveMsgEntity>> getReceive(ReceiveMsgEntity entity){
        return mModel.getReceive(entity);
    }
}
