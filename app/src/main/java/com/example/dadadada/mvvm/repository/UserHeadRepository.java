package com.example.dadadada.mvvm.repository;

import androidx.lifecycle.LiveData;

import com.example.core.BaseRepository;
import com.example.dadadada.mvvm.model.UserHeadModel;
import com.example.dadadada.mvvm.model.entity.ChangeUserEntity;
import com.example.net.retrofit.BaseRespEntity;

/**
 *
 */
public class UserHeadRepository extends BaseRepository<UserHeadModel> {


    @Override
    protected UserHeadModel createModel() {
        return new UserHeadModel();
    }

    public LiveData<BaseRespEntity<ChangeUserEntity>> gethead (String headimg, int id){
        return mModel.gethead(headimg,id);
    }
}
