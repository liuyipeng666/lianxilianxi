package com.example.dadadada.common;

import android.content.Context;
import android.content.SharedPreferences;

import static android.content.Context.MODE_PRIVATE;

public class SpUtils {
    public static String name(Context context){


        SharedPreferences tLpp =context. getSharedPreferences("TLapp", MODE_PRIVATE);
        String username = tLpp.getString("username",null);

        return username;
    }
    public static String token(Context context){


        SharedPreferences tLpp =context. getSharedPreferences("TLapp", MODE_PRIVATE);
        String token = tLpp.getString("token",null);

        return token;
    }

    public static void clearr(Context context){
        SharedPreferences tLpp =context. getSharedPreferences("TLapp", MODE_PRIVATE);
        tLpp.edit().clear().commit();

    }
    public static String id(Context context){
        SharedPreferences tLpp =context. getSharedPreferences("TLapp", MODE_PRIVATE);
        String id = tLpp.getString("id",null);

        return id;

    }

}
