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
public class UserHeadModel implements IModel {

    public LiveData<BaseRespEntity<ChangeUserEntity>> gethead(String headimg,int id){
        UserApi userApi = NetTools.getInstance().create(UserApi.class);
        return userApi.gethead(headimg,id);
    }

}
