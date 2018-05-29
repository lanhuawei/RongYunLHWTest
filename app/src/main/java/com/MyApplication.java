package com;

import android.app.Application;

import io.rong.imkit.RongIM;

/**
 * Created by Ivan.L on  2018/5/28 .
 *
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        RongIM.init(this);
    }
}
