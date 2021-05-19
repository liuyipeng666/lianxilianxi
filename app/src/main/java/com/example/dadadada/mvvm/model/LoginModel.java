package com.example.dadadada.mvvm.model;

import androidx.lifecycle.LiveData;

import com.example.core.IModel;
import com.example.dadadada.api.UserApi;
import com.example.dadadada.mvvm.model.entity.LoginEntity;
import com.example.net.retrofit.BaseRespEntity;
import com.example.net.retrofit.NetTools;

public class LoginModel implements IModel {

    public LiveData<BaseRespEntity<LoginEntity>> login(LoginEntity entity){
        UserApi api = NetTools.getInstance().create(UserApi.class);

        return api.login(entity);
    }
}
