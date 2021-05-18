package com.example.dadadada.amessage.api;

import androidx.lifecycle.LiveData;

import com.example.dadadada.amessage.entity.MessageFLEntity;
import com.example.dadadada.amessage.entity.ReceiveMessageEntity;
import com.example.dadadada.amessage.entity.SendMessageEntity;
import com.example.net.retrofit.BaseRespEntity;

import java.util.List;

import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface AMessageApi {

    interface MessageFLApi{
        @GET("/msg/findMsgsByUser")
        LiveData<BaseRespEntity<MessageFLEntity>> get();
    }
    interface sendMessageApi{
        @POST("/msg/sendMsg")
        LiveData<BaseRespEntity<SendMessageEntity>> get(@Body ReceiveMessageEntity entity);
    }
}
