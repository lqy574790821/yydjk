package com.example.yydkj.gloab;

import android.app.Application;
import android.content.Context;
import android.os.Handler;



public class APP extends Application {
    public static Context context;
    public static Handler mainHandler;

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
        mainHandler = new Handler();
    }
}
