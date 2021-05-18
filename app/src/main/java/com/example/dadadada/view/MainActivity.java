package com.example.dadadada.view;


import android.os.Bundle;
import android.os.PersistableBundle;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import com.amap.api.maps.AMap;
import com.amap.api.maps.MapView;
import com.example.dadadada.R;

public class MainActivity extends AppCompatActivity {
    MapView mMapView = null;
    //初始化地图控制器对象
    AMap aMap;
    private MapView map;
    private ImageView drawerDelete;
    private ImageView drawerHeadimg;
    private ImageView drawerCamera;
    private TextView drawerUsername;
    private TextView drawerIntroduce;
    private TextView drawerImgs;
    private TextView drawerCirculation;
    private TextView drawerLocation;
    private Switch drawerLocationSwitch;
    private Switch drawerRemindSwitch;
    private TextView drawerShare;
    private TextView drawerSetting;
    private DrawerLayout drawer;
    private RelativeLayout redian;
    private ImageView xiaodui;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mMapView = (MapView) findViewById(R.id.map);
        //在activity执行onCreate时执行mMapView.onCreate(savedInstanceState)，创建地图

        mMapView.onCreate(savedInstanceState);// 此方法须覆写，虚拟机需要在很多情况下保存地图绘制的当前状态。
        if (aMap == null) {
            aMap = mMapView.getMap();
        }
        initView();


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
        map = (MapView) findViewById(R.id.map);
        drawerDelete = (ImageView) findViewById(R.id.drawer_delete);
        drawerHeadimg = (ImageView) findViewById(R.id.drawer_headimg);
        drawerCamera = (ImageView) findViewById(R.id.drawer_camera);
        drawerUsername = (TextView) findViewById(R.id.drawer_username);
        drawerIntroduce = (TextView) findViewById(R.id.drawer_introduce);
        drawerImgs = (TextView) findViewById(R.id.drawer_imgs);
        drawerCirculation = (TextView) findViewById(R.id.drawer_circulation);
        drawerLocation = (TextView) findViewById(R.id.drawer_location);
        drawerLocationSwitch = (Switch) findViewById(R.id.drawer_location_switch);
        drawerRemindSwitch = (Switch) findViewById(R.id.drawer_remind_switch);
        drawerShare = (TextView) findViewById(R.id.drawer_share);
        drawerSetting = (TextView) findViewById(R.id.drawer_setting);
    }
}