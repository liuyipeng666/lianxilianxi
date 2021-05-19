package com.example.dadadada.amessage.repository;

import androidx.lifecycle.LiveData;

import com.example.core.BaseRepository;
import com.example.dadadada.amessage.entity.RemoveMsgEntity;
import com.example.dadadada.amessage.model.RemoveMsgModel;
import com.example.net.retrofit.BaseRespEntity;

public class RemoveMsgRepository extends BaseRepository<RemoveMsgModel> {
    @Override
    protected RemoveMsgModel createModel() {
        return new RemoveMsgModel();
    }

    public LiveData<BaseRespEntity<RemoveMsgEntity>> get(int id){
        return mModel.getRemove(id);
    }
}
