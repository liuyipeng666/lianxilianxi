package com.example.net;

public
interface IZLog {
    void d(String log);
    void i(String log);
    void w(String log);

    void e(String log);

    void setTag(String tag);
    void setLogLevel(int level);
}
