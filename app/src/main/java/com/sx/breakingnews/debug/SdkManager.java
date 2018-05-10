package com.sx.breakingnews.debug;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * @Author sunxin
 * @Date 2018/5/10 0010 下午 3:43
 * @Description
 */

public class SdkManager {
    /**
     * 为OkHttp设置Log拦截器
     * @param builder
     * @return
     */
    public static OkHttpClient.Builder initInterceptor(OkHttpClient.Builder builder){
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        builder.addInterceptor(httpLoggingInterceptor);
        return builder;
    }
}
