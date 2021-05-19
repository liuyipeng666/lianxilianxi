package com.example.dadadada.register.model;

import androidx.lifecycle.LiveData;

import com.example.dadadada.register.model.entity.FriendsEntity;
import com.example.net.retrofit.BaseRespEntity;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Query;

public interface FriendsApi {
    /**
     *  获取添加好友申请
     */

    @GET("/friend/findReqFriends")
    LiveData<BaseRespEntity<List<FriendsEntity>>> getFriendsToken(@Query("userid") int userid);
}
