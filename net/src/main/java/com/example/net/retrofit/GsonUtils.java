package com.example.net.retrofit;

import com.google.gson.Gson;

public class GsonUtils {
    private Gson gson;

    private GsonUtils(){}
    //内部类单例模式
    private static class GsonUtilsHandler{
        private static GsonUtils instance=new GsonUtils();
    }

    public static GsonUtils getInstance(){
        return GsonUtilsHandler.instance;
    }


    public synchronized Gson getGson(){
        if(gson==null){
            gson=new Gson();
        }
        return gson;
    }



}
