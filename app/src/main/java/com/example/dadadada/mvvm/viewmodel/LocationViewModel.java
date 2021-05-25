package com.example.dadadada.mvvm.viewmodel;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;

import com.example.core.BaseViewModel;
import com.example.dadadada.mvvm.model.entity.ChangeUserEntity;
import com.example.dadadada.mvvm.repository.LocationRepository;
import com.example.net.retrofit.BaseRespEntity;

/**
 *
 */
public class LocationViewModel extends BaseViewModel<LocationRepository> {


    public LocationViewModel(LifecycleOwner _owner) {
        super(_owner);
    }

    @Override
    protected LocationRepository createRepository() {
        return new LocationRepository();
    }

    @Override
    protected void disConnectionView() {

    }

    @Override
    protected void connectionView() {

    }

    public LiveData<BaseRespEntity<ChangeUserEntity>> locationsss(int id,int lat ,int lon){
        return mRepository.getlocation(id, lat, lon);
    }
}
