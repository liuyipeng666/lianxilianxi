package com.example.dadadada.mvvm.model;

import androidx.lifecycle.LiveData;

import com.example.core.IModel;
import com.example.dadadada.api.UserApi;
import com.example.dadadada.entity.CreateQunEntity;
import com.example.dadadada.entity.CreateQunFanEntity;
import com.example.net.retrofit.BaseRespEntity;
import com.example.net.retrofit.NetTools;

public class CreateQunModel implements IModel {

    public LiveData<BaseRespEntity<CreateQunFanEntity>> createee(CreateQunEntity entity){

        UserApi api = NetTools.getInstance().create(UserApi.class);

        return api.createee(entity);
    }


}
