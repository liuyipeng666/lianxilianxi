package com.example.dadadada.mvvm.viewmodel;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;

import com.example.core.BaseViewModel;
import com.example.dadadada.mvvm.model.entity.LoginEntity;
import com.example.dadadada.mvvm.repository.LoginRepository;
import com.example.net.retrofit.BaseRespEntity;

public class LoginViewModel  extends BaseViewModel<LoginRepository> {
    public LoginViewModel(LifecycleOwner _owner) {
        super(_owner);
    }

    @Override
    protected LoginRepository createRepository() {
        return new LoginRepository();
    }

    @Override
    protected void disConnectionView() {

    }

    @Override
    protected void connectionView() {

    }

    public LiveData<BaseRespEntity<LoginEntity>> logincmd(LoginEntity entity){

        return mRepository.login(entity);
    }
 }
