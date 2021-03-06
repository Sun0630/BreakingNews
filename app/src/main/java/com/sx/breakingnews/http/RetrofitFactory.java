package com.sx.breakingnews.http;

import com.franmontiel.persistentcookiejar.ClearableCookieJar;
import com.franmontiel.persistentcookiejar.PersistentCookieJar;
import com.franmontiel.persistentcookiejar.cache.SetCookieCache;
import com.franmontiel.persistentcookiejar.persistence.SharedPrefsCookiePersistor;
import com.sx.breakingnews.BuildConfig;
import com.sx.breakingnews.InitApp;
import com.sx.breakingnews.api.INewsApi;
import com.sx.breakingnews.debug.SdkManager;
import com.sx.breakingnews.utils.NetWorkUtil;

import java.io.File;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @Author Administrator
 * @Date 2018/5/10 0010 下午 2:41
 * @Description 网络引擎封装
 */

public class RetrofitFactory {
    private volatile static Retrofit sRetrofit;
    /**
     * 缓存机制
     * 在响应请求之后在 data/data/<包名>/cache 下建立一个response 文件夹，保持缓存数据。
     * 这样我们就可以在请求的时候，如果判断到没有网络，自动读取缓存的数据。
     * 同样这也可以实现，在我们没有网络的情况下，重新打开App可以浏览的之前显示过的内容。
     * 也就是：判断网络，有网络，则从网络获取，并保存到缓存中，无网络，则从缓存中获取。
     * https://werb.github.io/2016/07/29/%E4%BD%BF%E7%94%A8Retrofit2+OkHttp3%E5%AE%9E%E7%8E%B0%E7%BC%93%E5%AD%98%E5%A4%84%E7%90%86/
     */
    private static final Interceptor cacheControlInterceptor = chain -> {
        Request request = chain.request();
        if (!NetWorkUtil.isNetworkConnected(InitApp.appContext)) {
            request = request.newBuilder().cacheControl(CacheControl.FORCE_CACHE).build();
        }

        Response originalResponse = chain.proceed(request);
        if (NetWorkUtil.isNetworkConnected(InitApp.appContext)) {
            // 有网络时 设置缓存为默认值
            String cacheControl = request.cacheControl().toString();
            return originalResponse.newBuilder()
                    .header("Cache-Control", cacheControl)
                    // 清除头信息，因为服务器如果不支持，会返回一些干扰信息，不清除下面无法生效
                    .removeHeader("Pragma")
                    .build();
        } else {
            // 无网络时 设置超时为1周
            int maxStale = 60 * 60 * 24 * 7;
            return originalResponse.newBuilder()
                    .header("Cache-Control", "public, only-if-cached, max-stale=" + maxStale)
                    .removeHeader("Pragma")
                    .build();
        }
    };

    public static Retrofit getRetrofit() {
        if (sRetrofit == null) {
            synchronized (RetrofitFactory.class) {
                if (sRetrofit == null) {

                    Cache cache = new Cache(new File(InitApp.appContext.getCacheDir(), "breakingCache"), 1024 * 1024 * 50);

                    //持久化cookie
                    ClearableCookieJar cookieJar = new PersistentCookieJar(new SetCookieCache(), new SharedPrefsCookiePersistor(InitApp.appContext));


                    OkHttpClient.Builder builder = new OkHttpClient.Builder()
                            .cache(cache)
                            .cookieJar(cookieJar)
                            .addInterceptor(cacheControlInterceptor)
                            .writeTimeout(15, TimeUnit.SECONDS)
                            .readTimeout(15, TimeUnit.SECONDS)
                            .retryOnConnectionFailure(true);


                    //Log拦截器
                    if (BuildConfig.DEBUG) {
                        builder = SdkManager.initInterceptor(builder);
                    }

                    sRetrofit = new Retrofit.Builder()
                            .baseUrl(INewsApi.HOST)
                            .client(builder.build())
                            .addConverterFactory(GsonConverterFactory.create())
                            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                            .build();
                }
            }

        }
        return sRetrofit;
    }
}
