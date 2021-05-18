package com.example.dadadada.amessage.viewmodel;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;

import com.example.core.BaseViewModel;
import com.example.dadadada.amessage.entity.MessageFLEntity;
import com.example.dadadada.amessage.repository.MessageFLRepository;
import com.example.net.retrofit.BaseRespEntity;

public class MessageFLViewModel extends BaseViewModel<MessageFLRepository> {
    public MessageFLViewModel(LifecycleOwner _owner) {
        super(_owner);
    }

    @Override
    protected MessageFLRepository createRepository() {
        return new MessageFLRepository();
    }

    @Override
    protected void disConnectionView() {

    }

    @Override
    protected void connectionView() {

    }

    public LiveData<BaseRespEntity<MessageFLEntity>> getViewModel(){
        return mRepository.getFL();
    }
}
