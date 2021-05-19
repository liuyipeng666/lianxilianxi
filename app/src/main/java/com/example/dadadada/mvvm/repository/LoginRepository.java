package com.example.dadadada.mvvm.repository;

import androidx.lifecycle.LiveData;

import com.example.core.BaseRepository;
import com.example.dadadada.mvvm.model.LoginModel;
import com.example.dadadada.mvvm.model.entity.LoginEntity;
import com.example.net.retrofit.BaseRespEntity;

public class LoginRepository extends BaseRepository<LoginModel> {

    @Override
    protected LoginModel createModel() {
        return new LoginModel();
    }

    public LiveData<BaseRespEntity<LoginEntity>> login(LoginEntity entity){
        return mModel.login(entity);
    }
}
