package com.example.dadadada.register.viewmodel;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;

import com.example.core.BaseViewModel;
import com.example.dadadada.register.model.entity.RegisterEntity;
import com.example.dadadada.register.repository.RegisterRepository;
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

    public LiveData<BaseRespEntity<RegisterEntity>> loginCmd(RegisterEntity userEntity) {
        return mRepository.register(userEntity);
    }
}
