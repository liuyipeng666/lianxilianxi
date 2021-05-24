package com.example.dadadada.friend.api;

import androidx.lifecycle.LiveData;

import com.example.dadadada.friend.entity.FriendCodeEntity;
import com.example.net.retrofit.BaseRespEntity;

import retrofit2.http.POST;

public interface FriendApi {
    interface addFriend{
        @POST("/friend/addFriend")
        LiveData<BaseRespEntity<FriendCodeEntity>> get();
    }
}
