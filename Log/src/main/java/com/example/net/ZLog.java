package com.example.net;

import com.example.net.impl.ConsoleLog;
import com.example.net.impl.LogCatLog;
import com.example.net.impl.NetLog;

public
class ZLog {

    private IZLog zlog=null;

    private LogType mLogTYpe;
    private int mLogLevel;
    private String mTag;

    private ZLog(LogType _logType, int _logLevel, String _tag){
        this.mLogTYpe=_logType;
        this.mLogLevel=_logLevel;
        this.mTag=_tag;

        setLogType(this.mLogTYpe);
        setLogLevel(this.mLogLevel);
        setTag(this.mTag);
    }

    /**
     * 设置Log的类型
     * @param _type
     */
    private void setLogType(LogType _type){
        switch (_type){
            case LOGCAT:
                zlog=new LogCatLog();
                break;
            case CONSOLE:
                zlog=new ConsoleLog();
                break;
            case NET:
                zlog=new NetLog();
                break;
        }
    }

    /**
     * 设置Tag
     * @param _tag
     */
    private void setTag(String _tag){
        zlog.setTag(_tag);
    }

    /**
     * 设置日志等级
     * @param _logLevel
     */
    private void setLogLevel(int _logLevel){
        zlog.setLogLevel(_logLevel);
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

    public static final class Builder{
        private LogType mType;
        private int mLevel;
        private String mTag;

        public Builder setLogType(LogType _type){
            mType=_type;
            return this;
        }

        public Builder setLevel(int _level){
            mLevel=_level;
            return this;
        }

        public Builder setTag(String _tag){
            mTag=_tag;
            return this;
        }

        public ZLog build(){
            return new ZLog(mType,mLevel,mTag);
        }
    }

}
