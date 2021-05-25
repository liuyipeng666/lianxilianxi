package com.example.dadadada.mvvm.repository;

import androidx.lifecycle.LiveData;

import com.example.core.BaseRepository;
import com.example.dadadada.mvvm.model.UserHeadModel;
import com.example.dadadada.mvvm.model.UserNameModel;
import com.example.dadadada.mvvm.model.entity.ChangeUserEntity;
import com.example.net.retrofit.BaseRespEntity;

/**
 *
 */
public class UserNameRepository extends BaseRepository<UserNameModel> {


    @Override
    protected UserNameModel createModel() {
        return new UserNameModel();
    }

    public LiveData<BaseRespEntity<ChangeUserEntity>> gethead (int id,String nick){
        return mModel.getname(id,nick);
    }
}
