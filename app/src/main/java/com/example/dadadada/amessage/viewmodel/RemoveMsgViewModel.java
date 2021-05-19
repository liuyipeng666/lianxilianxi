package com.example.dadadada.amessage.viewmodel;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;

import com.example.core.BaseViewModel;
import com.example.dadadada.amessage.entity.RemoveMsgEntity;
import com.example.dadadada.amessage.repository.RemoveMsgRepository;
import com.example.net.retrofit.BaseRespEntity;

public class RemoveMsgViewModel extends BaseViewModel<RemoveMsgRepository> {
    public RemoveMsgViewModel(LifecycleOwner _owner) {
        super(_owner);
    }

    @Override
    protected RemoveMsgRepository createRepository() {
        return new RemoveMsgRepository();
    }

    @Override
    protected void disConnectionView() {

    }

    @Override
    protected void connectionView() {

    }

    public  LiveData<BaseRespEntity<RemoveMsgEntity>> getRemove(int id){
        return mRepository.get(id);
    }
}
