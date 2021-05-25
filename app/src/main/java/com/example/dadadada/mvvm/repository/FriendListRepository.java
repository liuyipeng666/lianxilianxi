package com.example.dadadada.mvvm.repository;

import androidx.lifecycle.LiveData;

import com.example.core.BaseRepository;
import com.example.dadadada.mvvm.model.entity.FriendListEntity;
import com.example.dadadada.mvvm.model.entity.FriendsEntity;
import com.example.dadadada.mvvm.model.FriendListModel;
import com.example.net.retrofit.BaseRespEntity;

import java.util.List;

public class FriendListRepository extends BaseRepository<FriendListModel> {
    @Override
    protected FriendListModel createModel() {
        return new FriendListModel();
    }

    public LiveData<BaseRespEntity<List<FriendListEntity>>> getModel(int userId) {
        return mModel.get(userId);
    }
}
