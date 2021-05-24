package com.example.dadadada.api;

import androidx.lifecycle.LiveData;

import com.example.dadadada.mvvm.model.entity.ActivityEntity;
import com.example.net.retrofit.BaseRespEntity;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ActivityApi {
    @GET("/active/findActiveByUser")
    LiveData<BaseRespEntity<List<ActivityEntity>>> getList(@Query("userid")int userid);
}
