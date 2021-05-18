package com.example.net.impl;

import android.util.Log;

import com.example.log.BuildConfig;
import com.example.net.IZLog;
import com.example.net.LogLevel;

public class LogCatLog implements IZLog {

    private  String DEFAULT_TAG="hahaha";
    private int logLevel= LogLevel.DEBUG;
    @Override
    public void d(String log) {
        if (BuildConfig.isDebug&&LogLevel.DEBUG>=logLevel){
            Log.d(getTag(),log);
        }
    }

    @Override
    public void i(String log) {
        if (BuildConfig.isDebug&&LogLevel.INFO>=logLevel){
            Log.i(getTag(),log);
        }
    }

    @Override
    public void w(String log) {
        if (BuildConfig.isDebug&&LogLevel.WARNNING>=logLevel){
            Log.w(getTag(),log);
        }
    }

    @Override
    public void e(String log) {
        if (BuildConfig.isDebug&&LogLevel.ERROR>=logLevel){
            Log.e(getTag(),log);
        }
    }

    /**
     * 设置TAG
     * @param tag
     */
    @Override
    public void setTag(String tag) {
        DEFAULT_TAG=tag;
    }

    /**
     * 设置日志输出等级
     * @param level
     */
    @Override
    public void setLogLevel(int level) {
        logLevel=level;
    }




    private String getTag(){
        return DEFAULT_TAG;
    }
}
