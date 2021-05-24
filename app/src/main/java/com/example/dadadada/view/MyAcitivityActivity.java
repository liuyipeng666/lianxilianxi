package com.example.dadadada.view;

import android.app.Activity;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dadadada.R;
import com.example.dadadada.adapter.ActivityAdapter;
import com.example.dadadada.mvvm.model.entity.ActivityEntity;
import com.example.dadadada.mvvm.viewmodel.ActivityViewModel;
import com.example.net.retrofit.BaseRespEntity;

import java.util.List;

public class MyAcitivityActivity extends AppCompatActivity {

    private RecyclerView rv;
    private ActivityAdapter activityAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acitivity);
        initView();
        initData();
    }

    private void initData() {
        ActivityViewModel activityViewModel = new ActivityViewModel(this);
        activityViewModel.getViewModel(1).observe(this, new Observer<BaseRespEntity<List<ActivityEntity>>>() {
            @Override
            public void onChanged(BaseRespEntity<List<ActivityEntity>> listBaseRespEntity) {
                List<ActivityEntity> data = listBaseRespEntity.getData(ActivityEntity.class);
                activityAdapter = new ActivityAdapter(R.layout.item_activity, data);
                rv.setAdapter(activityAdapter);
                rv.setLayoutManager(new LinearLayoutManager(MyAcitivityActivity.this));
            }
        });
    }

    private void initView() {
        rv = (RecyclerView) findViewById(R.id.rv);

    }
}