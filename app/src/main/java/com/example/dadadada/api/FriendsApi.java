package com.example.dadadada.api;



import androidx.lifecycle.LiveData;

import com.example.dadadada.mvvm.model.entity.FriendsEntity;
import com.example.dadadada.mvvm.model.entity.FriendListEntity;
import com.example.net.retrofit.BaseRespEntity;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Query;

public interface FriendsApi {
    /**
     * 获取添加好友申请
     */

    @GET("/friend/findReqFriends")
    LiveData<BaseRespEntity<List<FriendsEntity>>> getFriendsToken(@Query("userid") int userid);

    /**
     * 根据用户id获取好友列表
     */
    @GET("/friend/findByUserid")
    LiveData<BaseRespEntity<List<FriendListEntity>>> getList(@Query("userid") int userid);

}
