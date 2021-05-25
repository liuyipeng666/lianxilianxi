package com.example.dadadada.api;

import androidx.lifecycle.LiveData;

import com.example.dadadada.mvvm.model.entity.ChangeUserEntity;
import com.example.dadadada.mvvm.model.entity.LoginEntity;
import com.example.dadadada.mvvm.model.entity.LoginFanEntity;
import com.example.dadadada.mvvm.model.entity.RegisterCodeEntity;
import com.example.dadadada.mvvm.model.entity.RegisterEntity;
import com.example.dadadada.mvvm.model.entity.UserEntity;
import com.example.net.retrofit.BaseRespEntity;

import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Query;

public interface UserApi {
    @POST("/user/register")
    LiveData<BaseRespEntity<RegisterEntity>> register(@Body RegisterEntity entity);

    @POST("/user/login")
    LiveData<BaseRespEntity<LoginFanEntity>> login(@Body LoginEntity entity);

    @GET("/user/getUserById")
    LiveData<BaseRespEntity<UserEntity>> getuser(@Query("id")int id);

    @PUT("/user/modifyHeadimg")
    LiveData<BaseRespEntity<ChangeUserEntity>> gethead(@Query("headimg")String headimg, @Query("id")int id);

    @PUT("/user/modifyNick")
    LiveData<BaseRespEntity<ChangeUserEntity>> getname(@Query("id")int id, @Query("nick")String nick);

    @PUT("/user/modifyPwd")
    LiveData<BaseRespEntity<ChangeUserEntity>> getpwd(@Query("id")int id, @Query("pwd")String pwd);

    @PUT("/user/uploadLocation")
    LiveData<BaseRespEntity<ChangeUserEntity>> getlocation(@Query("id")int id, @Query("lat")int lat,@Query("lon")int lon);

    @PUT("/user/verificationCode")
    LiveData<BaseRespEntity<RegisterCodeEntity>> getcode(@Query("phoneNumber")String phonenumber);
}
