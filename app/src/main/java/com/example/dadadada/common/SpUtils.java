package com.example.dadadada.common;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import static android.content.Context.MODE_PRIVATE;

public class SpUtils {
    public static String name(Context context){


        SharedPreferences tLpp =context. getSharedPreferences("TLapp", MODE_PRIVATE);
        String username = tLpp.getString("username",null);
        Log.i("www", "onClick: drawhead mmm "+username);

        return username;
    }
    public static String token(Context context){


        SharedPreferences tLpp =context. getSharedPreferences("TLapp", MODE_PRIVATE);
        String token = tLpp.getString("token",null);
        Log.i("www", "onClick: sputils "+token);

        return token;
    }




}
