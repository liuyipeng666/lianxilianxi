package com.example.dadadada.mvvm.model;

import androidx.lifecycle.LiveData;

import com.example.core.IModel;
import com.example.dadadada.api.ActivityApi;
import com.example.dadadada.mvvm.model.entity.ActivityEntity;
import com.example.net.retrofit.BaseRespEntity;
import com.example.net.retrofit.NetTools;

import java.util.List;

public class ActivityModel implements IModel {
    public LiveData<BaseRespEntity<List<ActivityEntity>>> getActivityModel(int userid) {
        ActivityApi activityApi = NetTools.getInstance().create(ActivityApi.class);
        return activityApi.getList(userid);
    }
}
