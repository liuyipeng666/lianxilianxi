package com.example.dadadada.amessage.model;

import androidx.lifecycle.LiveData;

import com.example.core.IModel;
import com.example.dadadada.amessage.api.AMessageApi;
import com.example.dadadada.amessage.entity.ReceiveMsgEntity;
import com.example.net.retrofit.BaseRespEntity;
import com.example.net.retrofit.NetTools;

public class ReceiveMsgModel implements IModel {
    public LiveData<BaseRespEntity<ReceiveMsgEntity>> getReceive(ReceiveMsgEntity entity){
        AMessageApi.receiveMsg api = NetTools.getInstance().create(AMessageApi.receiveMsg.class);
        return api.get(entity);
    }
}
