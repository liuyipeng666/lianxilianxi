package com.example.dadadada.mvvm.viewmodel;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;

import com.example.core.BaseViewModel;
import com.example.dadadada.entity.CreateQunEntity;
import com.example.dadadada.entity.CreateQunFanEntity;
import com.example.dadadada.mvvm.repository.CreateQunRepository;
import com.example.net.retrofit.BaseRespEntity;

public class CreateQunViewModel extends BaseViewModel<CreateQunRepository> {
    public CreateQunViewModel(LifecycleOwner _owner) {
        super(_owner);
    }

    @Override
    protected CreateQunRepository createRepository() {
        return new CreateQunRepository();
    }

    @Override
    protected void disConnectionView() {

    }

    @Override
    protected void connectionView() {

    }

    public LiveData<BaseRespEntity<CreateQunFanEntity>> createqun(CreateQunEntity entity){

        return mRepository.createee(entity);
    }
}
