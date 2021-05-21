package com.example.dadadada.api;

import androidx.lifecycle.LiveData;

import com.example.dadadada.mvvm.model.entity.LoginEntity;
import com.example.dadadada.mvvm.model.entity.LoginFanEntity;
import com.example.dadadada.mvvm.model.entity.RegisterEntity;
import com.example.net.retrofit.BaseRespEntity;

import retrofit2.http.Body;
import retrofit2.http.POST;

public interface UserApi {
    @POST("/user/register")
    LiveData<BaseRespEntity<RegisterEntity>> register(@Body RegisterEntity entity);

    @POST("/user/login")
    LiveData<BaseRespEntity<LoginFanEntity>> login(@Body LoginEntity entity);



}
