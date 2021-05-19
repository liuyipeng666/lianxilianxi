package com.example.dadadada.amessage.api;

import androidx.lifecycle.LiveData;

import com.example.dadadada.amessage.entity.MessageFLEntity;
import com.example.dadadada.amessage.entity.MessageUserEntity;
import com.example.dadadada.amessage.entity.ReceiveMsgEntity;
import com.example.dadadada.amessage.entity.SendMessageEntity;
import com.example.dadadada.amessage.entity.ReadMsgEntity;
import com.example.dadadada.amessage.entity.RemoveMsgEntity;
import com.example.net.retrofit.BaseRespEntity;

import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;

public interface AMessageApi {

    /**
     * 消息分类
     */
    interface MessageFLApi{
        @GET("/msg/findMsgsByUser")
        LiveData<BaseRespEntity<MessageFLEntity>> get();
    }

    /**
     * 与指定用户的聊天记录
     */
    interface MessageUserApi{
        @GET("/msg/findMsgsByUser")
        LiveData<BaseRespEntity<MessageUserEntity>> get();
    }

    /**
     * 修改消息状态
     */
    interface readMsg{
        @PUT("/msg/readMsg")
        LiveData<BaseRespEntity<ReadMsgEntity>> get(int id);
    }

    /**
     * 接收消息
     */
    interface receiveMsg{
        @POST("/msg/receiveMsg")
        LiveData<BaseRespEntity<ReceiveMsgEntity>> get(@Body ReceiveMsgEntity entity);
    }

    /**
     * 删除消息
     */
    interface removeMsg{
        @DELETE("/msg/removeMsg")
        LiveData<BaseRespEntity<RemoveMsgEntity>> get(Integer id);
    }

    /**
     * 发送消息
     */
    interface sendMessageApi{
        @POST("/msg/sendMsg")
        LiveData<BaseRespEntity<SendMessageEntity>> get(@Body ReceiveMsgEntity entity);
    }
}
