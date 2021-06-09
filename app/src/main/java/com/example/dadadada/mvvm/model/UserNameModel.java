package com.example.dadadada.mvvm.model;

import androidx.lifecycle.LiveData;

import com.example.core.IModel;
import com.example.dadadada.api.UserApi;
import com.example.dadadada.mvvm.model.entity.ChangeUserEntity;
import com.example.net.retrofit.BaseRespEntity;
import com.example.net.retrofit.NetTools;

/**
 *
 */
public class UserNameModel implements IModel {

    public LiveData<BaseRespEntity<ChangeUserEntity>> getname(int id,String nick){
        UserApi userApi = NetTools.getInstance().create(UserApi.class);
        return userApi.getname(id,nick);
    }

}
