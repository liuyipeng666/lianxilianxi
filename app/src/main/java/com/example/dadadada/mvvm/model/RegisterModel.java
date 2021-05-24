package com.example.dadadada.mvvm.model;

import androidx.lifecycle.LiveData;

import com.example.core.IModel;
import com.example.dadadada.api.UserApi;
import com.example.dadadada.entity.entity.RegisterEntity;
import com.example.dadadada.entity.entity.RegisterFanEntity;
import com.example.net.retrofit.BaseRespEntity;
import com.example.net.retrofit.NetTools;


public class RegisterModel implements IModel {

    public LiveData<BaseRespEntity<RegisterFanEntity>> register(RegisterEntity userEntity){

        UserApi api = NetTools.getInstance().create(UserApi.class);

        return api.register(userEntity);
    }
}
