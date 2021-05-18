package com.example.dadadada.amessage.viewmodel;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;

import com.example.core.BaseViewModel;
import com.example.dadadada.amessage.entity.ReceiveMessageEntity;
import com.example.dadadada.amessage.entity.SendMessageEntity;
import com.example.dadadada.amessage.repository.SendMessageRepository;
import com.example.net.retrofit.BaseRespEntity;

public class SendMessageViewModel extends BaseViewModel<SendMessageRepository> {
    public SendMessageViewModel(LifecycleOwner _owner) {
        super(_owner);
    }

    @Override
    protected SendMessageRepository createRepository() {
        return new SendMessageRepository();
    }

    @Override
    protected void disConnectionView() {

    }

    @Override
    protected void connectionView() {

    }

    public LiveData<BaseRespEntity<SendMessageEntity>> getSend(ReceiveMessageEntity code){
        return mRepository.getSend(code);
    }
}
