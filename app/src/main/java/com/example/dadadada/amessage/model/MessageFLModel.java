package com.example.dadadada.amessage.model;

import androidx.lifecycle.LiveData;

import com.example.core.IModel;
import com.example.dadadada.amessage.api.AMessageApi;
import com.example.dadadada.amessage.entity.MessageFLEntity;
import com.example.net.retrofit.BaseRespEntity;
import com.example.net.retrofit.NetTools;

public class MessageFLModel implements IModel {
    public LiveData<BaseRespEntity<MessageFLEntity>> getFL(){
        AMessageApi.MessageFLApi api = NetTools.getInstance().create(AMessageApi.MessageFLApi.class);
        return api.get();
    }
}
