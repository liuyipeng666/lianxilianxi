package com.example.dadadada.mvvm.repository;

import androidx.lifecycle.LiveData;

import com.example.core.BaseRepository;

import com.example.dadadada.mvvm.model.FriendsTokenModel;
import com.example.dadadada.entity.entity.FriendsEntity;
import com.example.net.retrofit.BaseRespEntity;

import java.util.List;

public class FriendsTokenRepository extends BaseRepository<FriendsTokenModel> {
    @Override
    protected FriendsTokenModel createModel() {
        return new FriendsTokenModel();
    }

    public LiveData<BaseRespEntity<List<FriendsEntity>>> get(int userId) {
        return mModel.get(userId);
    }
}
