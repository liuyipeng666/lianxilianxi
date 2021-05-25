package com.example.dadadada.mvvm.viewmodel;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;

import com.example.core.BaseViewModel;
import com.example.dadadada.mvvm.model.entity.FriendListEntity;
import com.example.dadadada.mvvm.repository.FriendListRepository;
import com.example.net.retrofit.BaseRespEntity;

import java.util.List;

public class FriendListViewModel extends BaseViewModel<FriendListRepository> {

    public FriendListViewModel(LifecycleOwner _owner) {
        super(_owner);
    }

    @Override
    protected FriendListRepository createRepository() {
        return new FriendListRepository();
    }

    @Override
    protected void disConnectionView() {

    }

    @Override
    protected void connectionView() {

    }

    public LiveData<BaseRespEntity<List<FriendListEntity>>> list(int userId) {
        return mRepository.getModel(userId);
    }
}
