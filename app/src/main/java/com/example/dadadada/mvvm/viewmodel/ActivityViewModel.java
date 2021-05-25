package com.example.dadadada.mvvm.viewmodel;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;

import com.example.core.BaseViewModel;
import com.example.dadadada.mvvm.model.entity.ActivityEntity;
import com.example.dadadada.mvvm.repository.ActivityRepository;
import com.example.net.retrofit.BaseRespEntity;

import java.util.List;

public class ActivityViewModel extends BaseViewModel<ActivityRepository> {
    public ActivityViewModel(LifecycleOwner _owner) {
        super(_owner);
    }

    @Override
    protected ActivityRepository createRepository() {
        return new ActivityRepository();
    }

    @Override
    protected void disConnectionView() {

    }

    @Override
    protected void connectionView() {

    }

    public LiveData<BaseRespEntity<List<ActivityEntity>>> getViewModel(int userid) {
        return mRepository.getRepository(userid);
    }
}
