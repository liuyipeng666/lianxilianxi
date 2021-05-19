package com.example.dadadada.amessage.repository;

import androidx.lifecycle.LiveData;

import com.example.core.BaseRepository;
import com.example.dadadada.amessage.entity.MessageUserEntity;
import com.example.dadadada.amessage.model.MessageUserModel;
import com.example.net.retrofit.BaseRespEntity;

public class MessageUserRepository extends BaseRepository<MessageUserModel> {
    @Override
    protected MessageUserModel createModel() {
        return new MessageUserModel();
    }

    public LiveData<BaseRespEntity<MessageUserEntity>> getUser(){
        return mModel.getUser();
    }
}
