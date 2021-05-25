package com.example.dadadada.mvvm.model;

import androidx.lifecycle.LiveData;

import com.example.core.IModel;
import com.example.dadadada.api.FriendsApi;
import com.example.dadadada.mvvm.model.entity.FriendListEntity;
import com.example.net.retrofit.BaseRespEntity;
import com.example.net.retrofit.NetTools;

import java.util.List;

public class FriendListModel implements IModel {
   public LiveData<BaseRespEntity<List<FriendListEntity>>> get(int userid){
       FriendsApi friendsApi = NetTools.getInstance().create(FriendsApi.class);
        return friendsApi.getList(userid);
    }
}
