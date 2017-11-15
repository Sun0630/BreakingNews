package com.sx.breakingnews;

import android.app.Application;
import android.content.Context;

/**
 * @author Administrator
 * @Date 2017/11/15 0015 下午 4:52
 * @Description
 */

public class InitApp extends Application {


    public static Context appContext;

    @Override
    public void onCreate() {
        super.onCreate();
        appContext = getApplicationContext();
    }
}
