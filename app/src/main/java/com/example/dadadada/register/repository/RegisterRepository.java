package com.example.dadadada.register.repository;

import androidx.lifecycle.LiveData;

import com.example.core.BaseRepository;
import com.example.dadadada.register.model.RegisterModel;
import com.example.dadadada.register.model.entity.RegisterEntity;
import com.example.net.retrofit.BaseRespEntity;


public  class RegisterRepository extends BaseRepository<RegisterModel> {

    @Override
    protected RegisterModel createModel() {
        return new RegisterModel();
    }


    public LiveData<BaseRespEntity<RegisterEntity>> register(RegisterEntity userEntity) {
        return mModel.register(userEntity);
    }
}
