package com.example.dadadada.mvvm.viewmodel;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;

import com.example.core.BaseViewModel;
import com.example.dadadada.mvvm.model.entity.ChangeUserEntity;
import com.example.dadadada.mvvm.repository.UserHeadRepository;
import com.example.dadadada.mvvm.repository.UserPwdRepository;
import com.example.net.retrofit.BaseRespEntity;

public class UserPwdViewModel extends BaseViewModel<UserPwdRepository>{


    public UserPwdViewModel(LifecycleOwner _owner) {
        super(_owner);
    }

    @Override
    protected UserPwdRepository createRepository() {
        return new UserPwdRepository();
    }

    @Override
    protected void disConnectionView() {

    }

    @Override
    protected void connectionView() {

    }

    public LiveData<BaseRespEntity<ChangeUserEntity>> headsss(int id,String pwd){
        return mRepository.getpwd(id,pwd);
    }
}
