package com.example.dadadada.mvvm.repository;

import androidx.lifecycle.LiveData;

import com.example.core.BaseRepository;
import com.example.dadadada.mvvm.model.UserModel;
import com.example.dadadada.mvvm.model.entity.UserEntity;
import com.example.net.retrofit.BaseRespEntity;

/**
 *
 */
public class UserRepository extends BaseRepository<UserModel> {

    @Override
    protected UserModel createModel() {
        return new UserModel();
    }

    public LiveData<BaseRespEntity<UserEntity>> getuser (int userid){

        return mModel.getuser(userid);

    }
}
