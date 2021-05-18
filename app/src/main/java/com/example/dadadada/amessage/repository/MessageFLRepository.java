package com.example.dadadada.amessage.repository;

import androidx.lifecycle.LiveData;

import com.example.core.BaseRepository;
import com.example.dadadada.amessage.entity.MessageFLEntity;
import com.example.dadadada.amessage.model.MessageFLModel;
import com.example.net.retrofit.BaseRespEntity;

public class MessageFLRepository extends BaseRepository<MessageFLModel> {


    @Override
    protected MessageFLModel createModel() {
        return new MessageFLModel();
    }

    public LiveData<BaseRespEntity<MessageFLEntity>> getFL(){
        return mModel.getFL();
    }
}
