package com.sx.breakingnews;

import android.app.Application;
import android.content.Context;

import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.FormatStrategy;
import com.orhanobut.logger.Logger;
import com.orhanobut.logger.PrettyFormatStrategy;

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
        initLogger();
    }

    private void initLogger() {
        FormatStrategy formatStrategt = PrettyFormatStrategy
                .newBuilder()
                .showThreadInfo(true)
                .tag("Breaking")
                .build();

        Logger.addLogAdapter(new AndroidLogAdapter(formatStrategt) {
            @Override public boolean isLoggable(int priority, String tag) {
                return BuildConfig.DEBUG;
            }
        });
    }
}
