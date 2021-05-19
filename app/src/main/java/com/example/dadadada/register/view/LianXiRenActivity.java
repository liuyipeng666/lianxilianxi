package com.example.dadadada.register.view;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dadadada.R;
import com.example.dadadada.adapter.FriendsTokenAdapter;
import com.example.dadadada.register.model.entity.FriendsEntity;
import com.example.dadadada.register.viewmodel.FriendsTokenViewModel;
import com.example.net.retrofit.BaseRespEntity;

import java.util.ArrayList;
import java.util.List;

public class LianXiRenActivity extends AppCompatActivity {

private int aa;
    private RecyclerView rv;
    private List<FriendsEntity> mList = new ArrayList<>();
    private FriendsTokenAdapter friendsTokenAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lian_xi_ren);

        initView();
        initData();
    }

    private void initData() {
//        FriendsEntity friendsEntity = new FriendsEntity();
        FriendsTokenViewModel friendsTokenViewModel = new FriendsTokenViewModel(this);
        friendsTokenViewModel.getFriendsToken(1).observe(this, new Observer<BaseRespEntity<List<FriendsEntity>>>() {
            @Override
            public void onChanged(BaseRespEntity<List<FriendsEntity>> listBaseRespEntity) {
                List<FriendsEntity> data = listBaseRespEntity.getData();
                Log.d("123", "onChanged: "+data.size());
                friendsTokenAdapter = new FriendsTokenAdapter(R.layout.item_friendstoken, data);
                rv.setAdapter(friendsTokenAdapter);
                rv.setLayoutManager(new LinearLayoutManager(LianXiRenActivity.this));
            }
        });
    }


    private void initView() {
        rv = (RecyclerView) findViewById(R.id.rv);

    }
}