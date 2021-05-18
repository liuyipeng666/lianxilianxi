package com.example.dadadada.amessage.model;

import androidx.lifecycle.LiveData;

import com.example.core.IModel;
import com.example.dadadada.amessage.api.AMessageApi;
import com.example.dadadada.amessage.entity.ReceiveMessageEntity;
import com.example.dadadada.amessage.entity.SendMessageEntity;
import com.example.net.retrofit.BaseRespEntity;
import com.example.net.retrofit.NetTools;

public class SendMessageModel implements IModel {
    public LiveData<BaseRespEntity<SendMessageEntity>> getSend(ReceiveMessageEntity code){
        AMessageApi.sendMessageApi api = NetTools.getInstance().create(AMessageApi.sendMessageApi.class);
        return api.get(code);
    }
}
