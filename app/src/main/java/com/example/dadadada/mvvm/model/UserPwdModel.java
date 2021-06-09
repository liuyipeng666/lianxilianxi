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
public class UserPwdModel implements IModel {

    public LiveData<BaseRespEntity<ChangeUserEntity>> getpwd(int id,String pwd){
        UserApi userApi = NetTools.getInstance().create(UserApi.class);
        return userApi.getpwd(id,pwd);
    }

}
