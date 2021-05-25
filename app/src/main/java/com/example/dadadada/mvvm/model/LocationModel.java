package com.example.dadadada.mvvm.model;

import androidx.lifecycle.LiveData;

import com.example.core.IModel;
import com.example.dadadada.api.UserApi;
import com.example.dadadada.mvvm.model.entity.ChangeUserEntity;
import com.example.net.retrofit.BaseRespEntity;
import com.example.net.retrofit.NetTools;

public
/**
 *
 */
class LocationModel implements IModel {

    public LiveData<BaseRespEntity<ChangeUserEntity>> getlocation(int id,int lat,int lon){
        UserApi userApi = NetTools.getInstance().create(UserApi.class);
        return userApi.getlocation(id, lat, lon);
    }

}
