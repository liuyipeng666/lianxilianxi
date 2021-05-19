package com.example.dadadada.register.model;

import androidx.lifecycle.LiveData;

import com.example.core.IModel;
import com.example.dadadada.register.model.entity.RegisterEntity;
import com.example.net.retrofit.BaseRespEntity;
import com.example.net.retrofit.NetTools;


public class RegisterModel implements IModel {

    public LiveData<BaseRespEntity<RegisterEntity>> register(RegisterEntity userEntity){

        RegisterApi api = NetTools.getInstance().create(RegisterApi.class);

        return api.register(userEntity);
    }
}
