package com.example.dadadada.mvvm.viewmodel;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;

import com.example.core.BaseViewModel;
import com.example.dadadada.mvvm.model.entity.ChangeUserEntity;
import com.example.dadadada.mvvm.repository.UserHeadRepository;
import com.example.net.retrofit.BaseRespEntity;

public class UserHeadViewModel extends BaseViewModel<UserHeadRepository>{


    public UserHeadViewModel(LifecycleOwner _owner) {
        super(_owner);
    }

    @Override
    protected UserHeadRepository createRepository() {
        return new UserHeadRepository();
    }

    @Override
    protected void disConnectionView() {

    }

    @Override
    protected void connectionView() {

    }

    public LiveData<BaseRespEntity<ChangeUserEntity>> headsss(String headimg, int id){
        return mRepository.gethead(headimg,id);
    }
}
