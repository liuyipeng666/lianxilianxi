package com.example.dadadada.mvvm.viewmodel;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;

import com.example.core.BaseViewModel;
import com.example.dadadada.mvvm.model.entity.ChangeUserEntity;
import com.example.dadadada.mvvm.repository.UserHeadRepository;
import com.example.dadadada.mvvm.repository.UserNameRepository;
import com.example.net.retrofit.BaseRespEntity;

public class UserNameViewModel extends BaseViewModel<UserNameRepository>{


    public UserNameViewModel(LifecycleOwner _owner) {
        super(_owner);
    }

    @Override
    protected UserNameRepository createRepository() {
        return new UserNameRepository();
    }

    @Override
    protected void disConnectionView() {

    }

    @Override
    protected void connectionView() {

    }

    public LiveData<BaseRespEntity<ChangeUserEntity>> headsss(int id,String nick){
        return mRepository.gethead(id,nick);
    }
}
