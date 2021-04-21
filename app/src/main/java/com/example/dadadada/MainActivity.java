package com.example.dadadada;


import android.os.Bundle;
import android.os.PersistableBundle;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.amap.api.maps.AMap;
import com.amap.api.maps.MapView;
import com.example.net.ZLogManager;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    MapView mMapView = null;
    //初始化地图控制器对象
    AMap aMap;
    private ListView lv;
    private List<Trace> traceList = new ArrayList<>(10);
    private TraceListAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toast.makeText(this, "曹蓝之简直是太牛了", Toast.LENGTH_SHORT).show();
        ZLogManager.getInstance().i("哒哒哒");


        mMapView = (MapView) findViewById(R.id.map);
        //在activity执行onCreate时执行mMapView.onCreate(savedInstanceState)，创建地图

        mMapView.onCreate(savedInstanceState);// 此方法须覆写，虚拟机需要在很多情况下保存地图绘制的当前状态。
        if (aMap == null) {
            aMap = mMapView.getMap();
        }
        initView();
        initData();
    }

    private void initData() {
        // 模拟一些假的数据
        traceList.add(new Trace("2019/12/19 16:30:00", "活动A     已参加（5/10）人                              下午三点 西二旗餐厅聚会...       "));
        traceList.add(new Trace("2019/12/19 19:30:00", "活动A     已参加（5/10）人                              下午三点 西二旗餐厅聚会...       "));
        traceList.add(new Trace("2019/12/12 14:30:00", "活动A     已参加（5/10）人                              下午三点 西二旗餐厅聚会...       "));
        traceList.add(new Trace("2019/12/12 14:30:00", "活动A     已参加（5/10）人                              下午三点 西二旗餐厅聚会...       "));
        traceList.add(new Trace("2019/12/12 14:30:00", "活动A     已参加（5/10）人                              下午三点 西二旗餐厅聚会...       "));
        traceList.add(new Trace("2019/12/12 14:30:00", "活动A     已参加（5/10）人                              下午三点 西二旗餐厅聚会...       "));
        traceList.add(new Trace("2019/12/12 14:30:00", "活动A     已参加（5/10）人                              下午三点 西二旗餐厅聚会...       "));
        traceList.add(new Trace("2019/12/12 14:30:00", "活动A     已参加（5/10）人                              下午三点 西二旗餐厅聚会...       "));
        traceList.add(new Trace("2019/12/12 14:30:00", "活动A     已参加（5/10）人                              下午三点 西二旗餐厅聚会...       "));
        adapter = new TraceListAdapter(this, traceList);
        lv.setAdapter(adapter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //在activity执行onDestroy时执行mMapView.onDestroy()，销毁地图
        mMapView.onDestroy();
    }

    @Override
    protected void onResume() {
        super.onResume();
        //在activity执行onResume时执行mMapView.onResume ()，重新绘制加载地图
        mMapView.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        //在activity执行onPause时执行mMapView.onPause ()，暂停地图的绘制
        mMapView.onPause();
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState, @NonNull PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        //在activity执行onSaveInstanceState时执行mMapView.onSaveInstanceState (outState)，保存地图当前的状态
        mMapView.onSaveInstanceState(outState);

    }

    private void initView() {
        lv = (ListView) findViewById(R.id.lv);
    }
}