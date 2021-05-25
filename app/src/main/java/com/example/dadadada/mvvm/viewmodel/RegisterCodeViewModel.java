package com.example.dadadada.mvvm.viewmodel;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;

import com.example.core.BaseViewModel;
import com.example.dadadada.mvvm.model.entity.ChangeUserEntity;
import com.example.dadadada.mvvm.model.entity.RegisterCodeEntity;
import com.example.dadadada.mvvm.repository.RegisterCodeRepository;
import com.example.net.retrofit.BaseRespEntity;

/**
 *
 */
public class RegisterCodeViewModel extends BaseViewModel<RegisterCodeRepository> {

    public RegisterCodeViewModel(LifecycleOwner _owner) {
        super(_owner);
    }

    @Override
    protected RegisterCodeRepository createRepository() {
        return new RegisterCodeRepository();
    }

    @Override
    protected void disConnectionView() {

    }

    @Override
    protected void connectionView() {

    }

    public LiveData<BaseRespEntity<RegisterCodeEntity>> codesss(String phonenumber){
        return mRepository.getcode(phonenumber);
    }
}
