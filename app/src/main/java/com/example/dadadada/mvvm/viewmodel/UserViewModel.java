package com.example.dadadada.mvvm.viewmodel;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;

import com.example.core.BaseViewModel;
import com.example.dadadada.mvvm.model.entity.UserEntity;
import com.example.dadadada.mvvm.repository.UserRepository;
import com.example.net.retrofit.BaseRespEntity;

/**
 *
 */
public class UserViewModel extends BaseViewModel<UserRepository> {

    public UserViewModel(LifecycleOwner _owner) {
        super(_owner);
    }

    @Override
    protected UserRepository createRepository() {
        return new UserRepository();
    }

    @Override
    protected void disConnectionView() {

    }

    @Override
    protected void connectionView() {

    }


    public LiveData<BaseRespEntity<UserEntity>> usersss(int userid){
        return mRepository.getuser(userid);
    }

}
