package com.example.dadadada.amessage.model;

import androidx.lifecycle.LiveData;

import com.example.core.IModel;
import com.example.dadadada.amessage.api.AMessageApi;
import com.example.dadadada.amessage.entity.MessageUserEntity;
import com.example.net.retrofit.BaseRespEntity;
import com.example.net.retrofit.NetTools;

public class MessageUserModel implements IModel {
    public LiveData<BaseRespEntity<MessageUserEntity>> getUser(){
        AMessageApi.MessageUserApi api = NetTools.getInstance().create(AMessageApi.MessageUserApi.class);
        return api.get();
    }
}
