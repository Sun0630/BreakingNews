package com.sx.breakingnews;

import android.support.annotation.NonNull;

import io.reactivex.functions.Consumer;

/**
 * @Author Administrator
 * @Date 2018/5/10 0010 下午 2:29
 * @Description 错误打印
 */

public class ErrorAction {

    @NonNull
    public static Consumer<Throwable> error(){
        return throwable -> {
            if (BuildConfig.DEBUG){
                throwable.printStackTrace();
            }
        };
    }


    public static void print(@NonNull Throwable throwable){
        if (BuildConfig.DEBUG){
            throwable.printStackTrace();
        }
    }


}
