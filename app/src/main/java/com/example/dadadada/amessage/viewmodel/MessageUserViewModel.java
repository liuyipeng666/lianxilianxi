package com.example.dadadada.amessage.viewmodel;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;

import com.example.core.BaseViewModel;
import com.example.dadadada.amessage.entity.MessageUserEntity;
import com.example.dadadada.amessage.repository.MessageUserRepository;
import com.example.net.retrofit.BaseRespEntity;

public class MessageUserViewModel extends BaseViewModel<MessageUserRepository> {
    public MessageUserViewModel(LifecycleOwner _owner) {
        super(_owner);
    }

    @Override
    protected MessageUserRepository createRepository() {
        return new MessageUserRepository();
    }

    @Override
    protected void disConnectionView() {

    }

    @Override
    protected void connectionView() {

    }

    public LiveData<BaseRespEntity<MessageUserEntity>> getUser(){
        return mRepository.getUser();
    }
}
