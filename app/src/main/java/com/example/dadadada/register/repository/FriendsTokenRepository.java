package com.example.dadadada.register.repository;

import androidx.lifecycle.LiveData;

import com.example.core.BaseRepository;
import com.example.dadadada.register.model.FriendsTokenModel;
import com.example.dadadada.register.model.entity.FriendsEntity;
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
