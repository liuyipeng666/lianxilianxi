package com.example.net;

public
class ZLogManager {

    private static ZLogManager instance=new ZLogManager();
    private ZLogManager(){}
    public static ZLogManager getInstance(){
        return instance;
    }

    private ZLog zlog;
    public void init(ZLog _log){
        if (_log==null){
            zlog=new ZLog.Builder().setLogType(LogType.LOGCAT)
                    .setLevel(LogLevel.DEBUG)
                    .setTag("dadada").build();
        }
        else{
            zlog=_log;
        }
    }

    public void d(String log){
        zlog.d(log);
    }

    public void i(String log){
        zlog.i(log);
    }

    public void w(String log){
        zlog.w(log);
    }

    public void e(String log){
        zlog.e(log);
    }

}
