package com.example.ishant.moviereview;

import android.app.Application;

/**
 * Created by ishant on 18/11/15.
 */
public class MyApplication extends Application {
    private static MyApplication singleInstance = null;

    public static MyApplication getInstance() {
        return singleInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        singleInstance = this;
    }
}
