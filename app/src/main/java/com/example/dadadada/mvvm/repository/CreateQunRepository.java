package com.example.dadadada.mvvm.repository;

import androidx.lifecycle.LiveData;

import com.example.core.BaseRepository;
import com.example.dadadada.entity.CreateQunEntity;
import com.example.dadadada.entity.CreateQunFanEntity;
import com.example.dadadada.mvvm.model.CreateQunModel;
import com.example.net.retrofit.BaseRespEntity;

public
class CreateQunRepository extends BaseRepository<CreateQunModel> {
    @Override
    protected CreateQunModel createModel() {
        return new CreateQunModel();
    }


    public LiveData<BaseRespEntity<CreateQunFanEntity>> createee(CreateQunEntity entity){


        return mModel.createee(entity);
    }
}
