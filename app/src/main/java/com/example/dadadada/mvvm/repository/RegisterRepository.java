package com.example.dadadada.mvvm.repository;

import androidx.lifecycle.LiveData;

import com.example.core.BaseRepository;
import com.example.dadadada.entity.entity.RegisterFanEntity;
import com.example.dadadada.mvvm.model.RegisterModel;
import com.example.dadadada.entity.entity.RegisterEntity;
import com.example.net.retrofit.BaseRespEntity;


public  class RegisterRepository extends BaseRepository<RegisterModel> {

    @Override
    protected RegisterModel createModel() {
        return new RegisterModel();
    }


    public LiveData<BaseRespEntity<RegisterFanEntity>> register(RegisterEntity userEntity) {
        return mModel.register(userEntity);
    }
}
