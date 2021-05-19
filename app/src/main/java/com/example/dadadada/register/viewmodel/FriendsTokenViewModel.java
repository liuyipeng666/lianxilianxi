package com.example.dadadada.register.viewmodel;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;

import com.example.core.BaseViewModel;
import com.example.dadadada.register.model.entity.FriendsEntity;
import com.example.dadadada.register.repository.FriendsTokenRepository;
import com.example.net.retrofit.BaseRespEntity;

import java.util.List;

public class FriendsTokenViewModel extends BaseViewModel<FriendsTokenRepository> {
    public FriendsTokenViewModel(LifecycleOwner _owner) {
        super(_owner);
    }

    @Override
    protected FriendsTokenRepository createRepository() {
        return new FriendsTokenRepository();
    }

    @Override
    protected void disConnectionView() {

    }

    @Override
    protected void connectionView() {

    }

    public LiveData<BaseRespEntity<List<FriendsEntity>>> getFriendsToken(int userId) {
        return mRepository.get(userId);
    }
}
