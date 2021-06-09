package com.example.dadadada.mvvm.repository;

import androidx.lifecycle.LiveData;

import com.example.core.BaseRepository;
import com.example.dadadada.mvvm.model.LocationModel;
import com.example.dadadada.mvvm.model.entity.ChangeUserEntity;
import com.example.net.retrofit.BaseRespEntity;

public
/**
 *
 */
class LocationRepository extends BaseRepository<LocationModel> {

    @Override
    protected LocationModel createModel() {
        return new LocationModel();
    }

    public LiveData<BaseRespEntity<ChangeUserEntity>> getlocation(int id,int lat,int lon){
        return mModel.getlocation(id, lat, lon);
    }
}
