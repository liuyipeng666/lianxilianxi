package com.example.dadadada.common;

import android.content.Context;
import android.widget.Toast;

public class MsgUtils {

    public static void showMsg(Context context,String msg){
        Toast.makeText(context,msg,Toast.LENGTH_SHORT).show();
    }
}
