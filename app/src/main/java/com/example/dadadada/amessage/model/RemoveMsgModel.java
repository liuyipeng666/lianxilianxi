package com.example.dadadada.amessage.model;

import androidx.lifecycle.LiveData;

import com.example.core.IModel;
import com.example.dadadada.amessage.api.AMessageApi;
import com.example.dadadada.amessage.entity.RemoveMsgEntity;
import com.example.net.retrofit.BaseRespEntity;
import com.example.net.retrofit.NetTools;

public class RemoveMsgModel implements IModel {
    public LiveData<BaseRespEntity<RemoveMsgEntity>> getRemove(int id){
        AMessageApi.removeMsg api = NetTools.getInstance().create(AMessageApi.removeMsg.class);
        return api.get(id);
    }
}
