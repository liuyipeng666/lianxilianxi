package com.example.dadadada.amessage.viewmodel;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;

import com.example.core.BaseViewModel;
import com.example.dadadada.amessage.entity.ReceiveMsgEntity;
import com.example.dadadada.amessage.repository.ReceiveMsgRepository;
import com.example.net.retrofit.BaseRespEntity;

public class ReceiveMsgViewModel extends BaseViewModel<ReceiveMsgRepository> {
    public ReceiveMsgViewModel(LifecycleOwner _owner) {
        super(_owner);
    }

    @Override
    protected ReceiveMsgRepository createRepository() {
        return new ReceiveMsgRepository();
    }

    @Override
    protected void disConnectionView() {

    }

    @Override
    protected void connectionView() {

    }

    public LiveData<BaseRespEntity<ReceiveMsgEntity>> getReceive(ReceiveMsgEntity entity){
        return mRepository.getReceive(entity);
    }
}
