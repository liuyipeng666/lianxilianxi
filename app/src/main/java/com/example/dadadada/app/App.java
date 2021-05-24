package com.example.dadadada.app;


import android.app.Application;
import android.content.Context;

import androidx.multidex.MultiDex;

import com.example.imagerloader.ImageLoader;
import com.example.imagerloader.impl.GlideStrategy;
import com.example.net.LogLevel;
import com.example.net.LogType;
import com.example.net.ZLog;
import com.example.net.ZLogManager;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.socialize.PlatformConfig;
import com.uuzuche.lib_zxing.activity.ZXingLibrary;

public class App extends Application {
    private Context context;
    @Override
    public void onCreate() {
        super.onCreate();
        ZLog zlog = new ZLog.Builder()
                .setLogType(LogType.LOGCAT)
                .setLevel(LogLevel.DEBUG)
                .setTag("1234")
                .build();
        ZXingLibrary.initDisplayOpinion(this);
        context=getApplicationContext();
        ImageLoader.getInstance().initStrategy(new GlideStrategy());
        ZLogManager.getInstance().init(zlog);
        MultiDex.install(App.this);

        UMConfigure.init(this,"5a12384aa40fa3551f0001d1","umeng",UMConfigure.DEVICE_TYPE_PHONE,"");

        PlatformConfig.setWeixin("wxdc1e388c3822c80b", "3baf1193c85774b3fd9d18447d76cab0");
        //豆瓣RENREN平台目前只能在服务器端配置
        PlatformConfig.setSinaWeibo("3921700954", "04b48b094faeb16683c32669824ebdad","http://sns.whalecloud.com");
        PlatformConfig.setYixin("yxc0614e80c9304c11b0391514d09f13bf");
        PlatformConfig.setQQZone("100424468", "c7394704798a158208a74ab60104f0ba");
        PlatformConfig.setTwitter("3aIN7fuF685MuZ7jtXkQxalyi", "MK6FEYG63eWcpDFgRYw4w9puJhzDl0tyuqWjZ3M7XJuuG7mMbO");
        PlatformConfig.setAlipay("2015111700822536");
        PlatformConfig.setLaiwang("laiwangd497e70d4", "d497e70d4c3e4efeab1381476bac4c5e");
        PlatformConfig.setPinterest("1439206");
        PlatformConfig.setKakao("e4f60e065048eb031e235c806b31c70f");
        PlatformConfig.setDing("dingoalmlnohc0wggfedpk");
        PlatformConfig.setVKontakte("5764965","5My6SNliAaLxEm3Lyd9J");
        PlatformConfig.setDropbox("oz8v5apet3arcdy","h7p2pjbzkkxt02a");
    }
}
