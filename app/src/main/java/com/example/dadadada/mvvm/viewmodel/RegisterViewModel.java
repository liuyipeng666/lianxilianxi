package com.example.dadadada.mvvm.viewmodel;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;

import com.example.core.BaseViewModel;
import com.example.dadadada.entity.entity.RegisterEntity;
import com.example.dadadada.entity.entity.RegisterFanEntity;
import com.example.dadadada.mvvm.repository.RegisterRepository;
import com.example.net.retrofit.BaseRespEntity;

public class RegisterViewModel extends BaseViewModel<RegisterRepository> {

    public RegisterViewModel(LifecycleOwner _owner) {
        super(_owner);
    }

    @Override
    protected RegisterRepository createRepository() {
        return new RegisterRepository();
    }

    @Override
    protected void disConnectionView() {

    }

    @Override
    protected void connectionView() {

    }

    public LiveData<BaseRespEntity<RegisterFanEntity>> loginCmd(RegisterEntity userEntity) {
        return mRepository.register(userEntity);
    }
}
