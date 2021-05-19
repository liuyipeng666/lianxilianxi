package com.example.dadadada.amessage.repository;

import androidx.lifecycle.LiveData;

import com.example.core.BaseRepository;
import com.example.dadadada.amessage.entity.ReadMsgEntity;
import com.example.dadadada.amessage.model.ReadMsgModel;
import com.example.net.retrofit.BaseRespEntity;

public class ReadMsgRepository extends BaseRepository<ReadMsgModel> {
    @Override
    protected ReadMsgModel createModel() {
        return new ReadMsgModel();
    }

    public LiveData<BaseRespEntity<ReadMsgEntity>> get(int id){
        return mModel.getRead(id);
    }
}
