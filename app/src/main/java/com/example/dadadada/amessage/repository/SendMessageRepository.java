package com.example.dadadada.amessage.repository;

import androidx.lifecycle.LiveData;

import com.example.core.BaseRepository;
import com.example.dadadada.amessage.entity.ReceiveMessageEntity;
import com.example.dadadada.amessage.entity.SendMessageEntity;
import com.example.dadadada.amessage.model.SendMessageModel;
import com.example.net.retrofit.BaseRespEntity;

public class SendMessageRepository extends BaseRepository<SendMessageModel> {
    @Override
    protected SendMessageModel createModel() {
        return new SendMessageModel();
    }

    public LiveData<BaseRespEntity<SendMessageEntity>> getSend(ReceiveMessageEntity code){
        return mModel.getSend(code);
    }
}
