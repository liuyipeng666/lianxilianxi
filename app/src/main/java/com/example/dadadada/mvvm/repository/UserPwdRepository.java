package com.example.dadadada.mvvm.repository;

import androidx.lifecycle.LiveData;

import com.example.core.BaseRepository;
import com.example.dadadada.mvvm.model.UserHeadModel;
import com.example.dadadada.mvvm.model.UserNameModel;
import com.example.dadadada.mvvm.model.UserPwdModel;
import com.example.dadadada.mvvm.model.entity.ChangeUserEntity;
import com.example.net.retrofit.BaseRespEntity;

/**
 *
 */
public class UserPwdRepository extends BaseRepository<UserPwdModel> {


    @Override
    protected UserPwdModel createModel() {
        return new UserPwdModel();
    }

    public LiveData<BaseRespEntity<ChangeUserEntity>> getpwd (int id,String pwd){
        return mModel.getpwd(id,pwd);
    }
}
