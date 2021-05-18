package com.example.dadadada.register.model;

import androidx.lifecycle.LiveData;

import com.example.dadadada.register.model.entity.RegisterEntity;
import com.example.net.retrofit.BaseRespEntity;

import retrofit2.http.Body;
import retrofit2.http.POST;


public interface RegisterApi {

    @POST("api/user/register")
    LiveData<BaseRespEntity<RegisterEntity>> register(@Body RegisterEntity entity);
}
