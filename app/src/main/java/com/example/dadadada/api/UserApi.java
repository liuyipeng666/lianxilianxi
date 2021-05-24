package com.example.dadadada.api;

import androidx.lifecycle.LiveData;

import com.example.dadadada.entity.CreateQunEntity;
import com.example.dadadada.entity.CreateQunFanEntity;
import com.example.dadadada.entity.entity.LoginEntity;
import com.example.dadadada.entity.entity.LoginFanEntity;
import com.example.dadadada.entity.entity.RegisterEntity;
import com.example.dadadada.entity.entity.RegisterFanEntity;
import com.example.net.retrofit.BaseRespEntity;

import retrofit2.http.Body;
import retrofit2.http.POST;

public interface UserApi {
    @POST("/user/register")
    LiveData<BaseRespEntity<RegisterFanEntity>> register(@Body RegisterEntity entity);

    @POST("/user/login")
    LiveData<BaseRespEntity<LoginFanEntity>> login(@Body LoginEntity entity);


    @POST("/group/createGroup")
    LiveData<BaseRespEntity<CreateQunFanEntity>> createee(@Body CreateQunEntity entity);


}
