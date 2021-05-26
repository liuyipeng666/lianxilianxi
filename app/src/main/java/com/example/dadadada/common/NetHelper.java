package com.example.dadadada.common;

import java.util.concurrent.Executors;

public class NetHelper {
    public static void doTask(Runnable command){
        Executors.newCachedThreadPool().execute(command);
    }
}
