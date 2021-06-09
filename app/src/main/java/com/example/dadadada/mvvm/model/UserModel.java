package com.example.dadadada.mvvm.model;


import androidx.lifecycle.LiveData;

import com.example.core.IModel;
import com.example.dadadada.api.UserApi;
import com.example.dadadada.mvvm.model.entity.UserEntity;
import com.example.net.retrofit.BaseRespEntity;
import com.example.net.retrofit.NetTools;

/**
 *
 */
public class UserModel implements IModel {

    public LiveData<BaseRespEntity<UserEntity>> getuser(int userid){
        UserApi userApi=NetTools.getInstance().create(UserApi.class);
        return userApi.getuser(userid);
    }

}
