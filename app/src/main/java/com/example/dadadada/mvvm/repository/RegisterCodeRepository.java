package com.example.dadadada.mvvm.repository;

import androidx.lifecycle.LiveData;

import com.example.core.BaseRepository;
import com.example.dadadada.mvvm.model.RegisterCodeMdoel;
import com.example.dadadada.mvvm.model.entity.ChangeUserEntity;
import com.example.dadadada.mvvm.model.entity.RegisterCodeEntity;
import com.example.net.retrofit.BaseRespEntity;

/**
 *
 */
public class RegisterCodeRepository extends BaseRepository<RegisterCodeMdoel> {

    @Override
    protected RegisterCodeMdoel createModel() {
        return new RegisterCodeMdoel();
    }

    public LiveData<BaseRespEntity<RegisterCodeEntity>> getcode(String phonenumber){
        return mModel.getcode(phonenumber);
    }
}
