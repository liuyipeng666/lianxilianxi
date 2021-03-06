package com.example.dadadada.view;


import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.hardware.Camera;
import android.os.Build;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.lifecycle.Observer;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.amap.api.maps.AMap;
import com.amap.api.maps.MapView;
import com.amap.api.maps.model.MyLocationStyle;
import com.example.dadadada.R;

import com.example.dadadada.adapter.TraceListAdapter;

import com.example.dadadada.amessage.AMessageActivity;
import com.example.dadadada.common.SpUtils;


import com.example.dadadada.common.Trace;
import com.example.dadadada.mvvm.model.entity.ChangeUserEntity;
import com.example.dadadada.mvvm.viewmodel.LocationViewModel;
import com.example.net.retrofit.BaseRespEntity;
import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.example.dadadada.PermissionValus.ACCESS_COARSE_LOCATION;
import static com.example.dadadada.PermissionValus.ACCESS_FINE_LOCATION;
import static com.example.dadadada.PermissionValus.BROADCAST_PACKAGE_ADDED;
import static com.example.dadadada.PermissionValus.BROADCAST_PACKAGE_CHANGED;
import static com.example.dadadada.PermissionValus.BROADCAST_PACKAGE_INSTALL;
import static com.example.dadadada.PermissionValus.BROADCAST_PACKAGE_REPLACED;
import static com.example.dadadada.PermissionValus.CALL_PHONE;
import static com.example.dadadada.PermissionValus.CAMERA;
import static com.example.dadadada.PermissionValus.READ_CONTACTS;
import static com.example.dadadada.PermissionValus.READ_EXTERNAL_STORAGE;
import static com.example.dadadada.PermissionValus.RECEIVE_BOOT_COMPLETED;
import static com.example.dadadada.PermissionValus.WAKE_LOCK;
import static com.example.dadadada.PermissionValus.WRITE_CONTACTS;
import static com.example.dadadada.PermissionValus.WRITE_EXTERNAL_STORAGE;


public class MainActivity extends AppCompatActivity implements AMapLocationListener, UMShareListener {

    private ListView lv;
    private List<Trace> traceList = new ArrayList<>(10);
    private TraceListAdapter adapter;
    private MyLocationStyle myLocationStyle;
    private DrawerLayout drawerLayoutMain;
    private Switch drawerLocationSwitch;
    private TextView drawerShare;
    private TextView drawerSetting;
    private ImageView drawerDelete;
    private ImageView drawerHeadimg;
    private ImageView drawerCamera;
    private TextView drawerUsername;
    private TextView drawerIntroduce;
    private ImageView imgHeadMain;
    //声明mlocationClient对象
    public AMapLocationClient mlocationClient;
    //声明mLocationOption对象
    public AMapLocationClientOption mLocationOption = null;
    MapView mMapView = null;
    //初始化地图控制器对象
    AMap aMap;
    private String path = "";



    private ImageView ivPerson;
    private MapView map;
    private LinearLayout cebianKuang;
    private TextView drawerImgs;
    private TextView drawerCirculation;
    private TextView drawerLocation;
    private Switch drawerRemindSwitch;

    private static BottomBarView bottom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //动态权限
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.M) {
            requestPermissions(new String[]{
                    ACCESS_COARSE_LOCATION, ACCESS_FINE_LOCATION,
                    WAKE_LOCK,BROADCAST_PACKAGE_ADDED,
                    BROADCAST_PACKAGE_CHANGED,BROADCAST_PACKAGE_INSTALL,
                    BROADCAST_PACKAGE_REPLACED,RECEIVE_BOOT_COMPLETED,
                    READ_EXTERNAL_STORAGE,WRITE_EXTERNAL_STORAGE,
                    CAMERA,CALL_PHONE,READ_CONTACTS,WRITE_CONTACTS,
            }, 100);
        }
        initView();
        initData();
        //判断sp是否存在用户
        SharedPreferences tLapp = getSharedPreferences("TLapp", MODE_PRIVATE);
        String user = tLapp.getString("user", "空");
        String pass = tLapp.getString("pass", "空");
        if (user.equals("空") && !pass.equals("空")){

        }else{
            drawerUsername.setText(user);
        }
        //在activity执行onCreate时执行mMapView.onCreate(savedInstanceState)，创建地图
        // 此方法须覆写，虚拟机需要在很多情况下保存地图绘制的当前状态。
        mMapView.onCreate(savedInstanceState);
        if (aMap == null) {
            aMap = mMapView.getMap();
        }

        mapinit(true);
        imgHeadMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = SpUtils.name(MainActivity.this);
                if (username == null) {
                    startActivity(new Intent(MainActivity.this, LoginActivity.class));
                } else {
                    Toast.makeText(MainActivity.this, "登录了", Toast.LENGTH_SHORT).show();
                    //弹出侧边框
                    drawerLayoutMain.openDrawer(cebianKuang);
                }

            }
        });
        //初始化相机
        getCameraInstance();
//        ivPerson.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(MainActivity.this, LianXiRenActivity.class);
//                startActivity(intent);
//
//            }
//        });

    }

    @Override
    public void onLocationChanged(AMapLocation amapLocation) {
        if (amapLocation != null) {
            if (amapLocation.getErrorCode() == 0) {
                //定位成功回调信息，设置相关消息
                amapLocation.getLocationType();//获取当前定位结果来源，如网络定位结果，详见定位类型表
                double latitude = amapLocation.getLatitude();//获取纬度
                double longitude = amapLocation.getLongitude();//获取经度
                //  Log.d("123", "获取经度:"+longitude + "获取纬度" + latitude);
                amapLocation.getAccuracy();//获取精度信息
                //获取经纬度上传位置
                SharedPreferences tLapp = getSharedPreferences("TLapp", MODE_PRIVATE);
                int id = Integer.parseInt(tLapp.getString("id",""));
                LocationViewModel locationViewModel = new LocationViewModel(MainActivity.this);
                int lat = (int) latitude;
                int lon = (int) longitude;
                locationViewModel.locationsss(id,lat,lon).observe(MainActivity.this, new Observer<BaseRespEntity<ChangeUserEntity>>() {
                    @Override
                    public void onChanged(BaseRespEntity<ChangeUserEntity> changeUserEntityBaseRespEntity) {
                        if (changeUserEntityBaseRespEntity.getMsg().equals("请求成功")) {
                            Toast.makeText(MainActivity.this, "位置上传成功", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                Date date = new Date(amapLocation.getTime());
                df.format(date);//定位时间
            } else {
                //显示错误信息ErrCode是错误码，errInfo是错误信息，详见错误码表。
                Log.e("AmapError", "location Error, ErrCode:"
                        + amapLocation.getErrorCode() + ", errInfo:"
                        + amapLocation.getErrorInfo());
            }
        }
    }

    private void mapinit(boolean isChecked) {
        myLocationStyle = new MyLocationStyle();//初始化定位蓝点样式类myLocationStyle.myLocationType(MyLocationStyle.LOCATION_TYPE_LOCATION_ROTATE);//连续定位、且将视角移动到地图中心点，定位点依照设备方向旋转，并且会跟随设备移动。（1秒1次定位）如果不设置myLocationType，默认也会执行此种模式。
        myLocationStyle.interval(2000); //设置连续定位模式下的定位间隔，只在连续定位模式下生效，单次定位模式下不会生效。单位为毫秒。
        aMap.setMyLocationStyle(myLocationStyle);//设置定位蓝点的Style
        //aMap.getUiSettings().setMyLocationButtonEnabled(true);设置默认定位按钮是否显示，非必需设置。
        aMap.setMyLocationEnabled(isChecked);// 设置为true表示启动显示定位蓝点，false表示隐藏定位蓝点并不进行定位，默认是false。
        aMap.setMyLocationEnabled(isChecked);// 设置为true表示启动显示定位蓝点，false表示隐藏定位蓝点并不进行定位，默认是false。
        aMap.getUiSettings().setMyLocationButtonEnabled(true);//设置默认定位按钮是否显示，非必需设置。
        mlocationClient = new AMapLocationClient(this);
        //初始化定位参数
//        mLocationOption = new AMapLocationClientOption();
        //设置定位监听
        mlocationClient.setLocationListener(this);
        //设置定位模式为高精度模式，Battery_Saving为低功耗模式，Device_Sensors是仅设备模式
//        mLocationOption.setLocationMode(AMapLocationClientOption.AMapLocationMode.Hight_Accuracy);
//        //设置定位间隔,单位毫秒,默认为2000ms
//        mLocationOption.setInterval(10000);
//        mlocationClient.setLocationOption(mLocationOption);
        // 此方法为每隔固定时间会发起一次定位请求，为了减少电量消耗或网络流量消耗，
        // 注意设置合适的定位时间的间隔（最小间隔支持为1000ms），并且在合适时间调用stopLocation()方法来取消定位请求
        // 在定位结束后，在合适的生命周期调用onDestroy()方法
        // 在单次定位情况下，定位无论成功与否，都无需调用stopLocation()方法移除请求，定位sdk内部会移除
        //启动定位
        mlocationClient.startLocation();
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
        //关闭侧滑
        drawerDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayoutMain.closeDrawer(Gravity.LEFT);
            }
        });
        //相机
        drawerCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, CameraActivity.class);
                startActivity(intent);
            }
        });
        //分享
        drawerShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new ShareAction(MainActivity.this)
                        .withText("分享成功")
                        .setDisplayList(SHARE_MEDIA.SINA, SHARE_MEDIA.QQ, SHARE_MEDIA.WEIXIN, SHARE_MEDIA.QZONE)
                        .setCallback(MainActivity.this)
                        .open();
            }
        });

        //设置
        drawerSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SettingActivity.class);
                startActivity(intent);
            }
        });

        //跳转登录页面
        drawerUsername.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(drawerUsername.getText().equals("未登录")){
                    Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                    startActivity(intent);
                }
            }
        });

        //展开侧拉
        //打开侧滑
        imgHeadMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayoutMain.openDrawer(Gravity.LEFT);
            }
        });

        //是否定位
        //打开定位
        drawerLocationSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                mapinit(isChecked);
            }
        });

        String username = SpUtils.name(MainActivity.this);
        if(username!=null){
            drawerUsername.setText(""+username);
        }



        bottom.setmOnBottomBarClickListener(new BottomBarView.OnBottomBarClickListener() {
            @Override
            public void onCLick(int position) {
                switch (position) {
                    case 1:
                        startActivity(new Intent(MainActivity.this, MyAcitivityActivity.class));
                        break;
                    case 2:
                        startActivity(new Intent(MainActivity.this, LianXiRenActivity.class));
                        break;
                    case 3:
                        startActivity(new Intent(MainActivity.this, AMessageActivity.class));
                        break;
                    case 4:
                        Toast.makeText(MainActivity.this, "朋友圈", Toast.LENGTH_SHORT).show();
                        break;
                    case 5:
                        Toast.makeText(MainActivity.this, "照相机", Toast.LENGTH_SHORT).show();
                        break;

                }
            }
        });

    }

    @SuppressLint("SimpleDateFormat")
    private String createName() {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        String format = simpleDateFormat.format(date);
        return "IMG" + format + ".jpg";
    }

    @Override
    protected void onStart() {
        super.onStart();
        String username = SpUtils.name(MainActivity.this);
        if (username != null) {
            drawerUsername.setText("" + username);
        }else{
            drawerUsername.setText("未登录");
        }
    }

    //访问相机
    /** A safe way to get an instance of the Camera object. */
    public static Camera getCameraInstance(){
        Camera c = null;
        try {
            c = Camera.open(); // attempt to get a Camera instance
        }
        catch (Exception e){
            // Camera is not available (in use or does not exist)
        }
        return c; // returns null if camera is unavailable
    }

    private void initView() {
        mMapView = (MapView) findViewById(R.id.map);
        lv = (ListView) findViewById(R.id.lv);
        drawerLayoutMain = (DrawerLayout) findViewById(R.id.drawerLayout_main);
        drawerLocationSwitch = (Switch) findViewById(R.id.drawer_location_switch);
        drawerShare = (TextView) findViewById(R.id.drawer_share);
        drawerSetting = (TextView) findViewById(R.id.drawer_setting);
        drawerDelete = (ImageView) findViewById(R.id.drawer_delete);
        drawerHeadimg = (ImageView) findViewById(R.id.drawer_headimg);
        drawerCamera = (ImageView) findViewById(R.id.drawer_camera);
        drawerUsername = (TextView) findViewById(R.id.drawer_username);
        drawerIntroduce = (TextView) findViewById(R.id.drawer_introduce);
        imgHeadMain = (ImageView) findViewById(R.id.img_head_main);
        map = (MapView) findViewById(R.id.map);
        cebianKuang = (LinearLayout) findViewById(R.id.cebian_kuang);
        drawerImgs = (TextView) findViewById(R.id.drawer_imgs);
        drawerCirculation = (TextView) findViewById(R.id.drawer_circulation);
        drawerLocation = (TextView) findViewById(R.id.drawer_location);
        drawerRemindSwitch = (Switch) findViewById(R.id.drawer_remind_switch);
        bottom = (BottomBarView) findViewById(R.id.bottom);
    }


    @Override
    public void onSaveInstanceState(@NonNull Bundle outState, @NonNull PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        //在activity执行onSaveInstanceState时执行mMapView.onSaveInstanceState (outState)，保存地图当前的状态
        mMapView.onSaveInstanceState(outState);
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
    public void onStart(SHARE_MEDIA share_media) {

    }

    @Override
    public void onResult(SHARE_MEDIA share_media) {

    }

    @Override
    public void onError(SHARE_MEDIA share_media, Throwable throwable) {

    }

    @Override
    public void onCancel(SHARE_MEDIA share_media) {
        Toast.makeText(this, "你取消了分享", Toast.LENGTH_SHORT).show();
    }

}