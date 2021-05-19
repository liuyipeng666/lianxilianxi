package com.example.net.retrofit;


import android.util.Log;

import com.google.gson.internal.LinkedTreeMap;

import java.util.ArrayList;
import java.util.List;

public class BaseRespEntity<T> {
    private int code;
    private T data;
    private String msg;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "BaseRespEntity{" +
                "code=" + code +
                ", data=" + data +
                ", msg='" + msg + '\'' +
                '}';
    }

    public T getData(Class<?> _type){
        if(data instanceof List){
            List<Object> tragetList=new ArrayList<>();
            List<Object> tempList= (List<Object>) data;
            for (Object t: tempList) {
                if(t instanceof LinkedTreeMap){
                    String s = GsonUtils.getInstance().getGson().toJson(t);
                    Object o = GsonUtils.getInstance().getGson().fromJson(s, _type);
                    tragetList.add(o);
                }
            }
            data= (T) tragetList;

        }else {
            if( data instanceof  LinkedTreeMap){
                String s = GsonUtils.getInstance().getGson().toJson(data);
                Object o = GsonUtils.getInstance().getGson().fromJson(s, _type);
                data = (T) o;
            }
        }
        return data;
    }
}
