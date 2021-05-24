package com.example.dadadada.mvvm.repository;

import androidx.lifecycle.LiveData;

import com.example.core.BaseRepository;
import com.example.dadadada.mvvm.model.ActivityModel;
import com.example.dadadada.mvvm.model.entity.ActivityEntity;
import com.example.net.retrofit.BaseRespEntity;

import java.util.List;

public class ActivityRepository extends BaseRepository<ActivityModel> {
    @Override
    protected ActivityModel createModel() {
        return new ActivityModel();
    }

    public LiveData<BaseRespEntity<List<ActivityEntity>>> getRepository(int userid) {
        return mModel.getActivityModel(userid);
    }
}
