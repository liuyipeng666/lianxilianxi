package com.example.dadadada.register.model;

import androidx.lifecycle.LiveData;

import com.example.core.IModel;
import com.example.dadadada.register.model.entity.FriendsEntity;
import com.example.net.retrofit.BaseRespEntity;
import com.example.net.retrofit.NetTools;

import java.util.List;

public class FriendsTokenModel implements IModel {
    public LiveData<BaseRespEntity<List<FriendsEntity>>>get(int userId){
        FriendsApi api= NetTools.getInstance().create(FriendsApi.class);
        return  api.getFriendsToken(userId);
    }
}
