package com.example.dadadada.amessage.model;

import androidx.lifecycle.LiveData;

import com.example.core.IModel;
import com.example.dadadada.amessage.api.AMessageApi;
import com.example.dadadada.amessage.entity.ReadMsgEntity;
import com.example.net.retrofit.BaseRespEntity;
import com.example.net.retrofit.NetTools;

public class ReadMsgModel implements IModel {
    public LiveData<BaseRespEntity<ReadMsgEntity>> getRead(int id){
        AMessageApi.readMsg api = NetTools.getInstance().create(AMessageApi.readMsg.class);
        return api.get(id);
    }
}
