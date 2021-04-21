package com.example.dadadada;


import android.app.Application;

import com.example.net.LogLevel;
import com.example.net.LogType;
import com.example.net.ZLog;
import com.example.net.ZLogManager;

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        ZLog zlog = new ZLog.Builder()
                .setLogType(LogType.LOGCAT)
                .setLevel(LogLevel.DEBUG)
                .setTag("1234")
                .build();

        ZLogManager.getInstance().init(zlog);
    }
}
