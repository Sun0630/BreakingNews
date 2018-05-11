package com.sx.breakingnews.utils;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.module.AppGlideModule;
import com.bumptech.glide.request.RequestOptions;
import com.sx.breakingnews.InitApp;

import static com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.withCrossFade;

/**
 * @Author Administrator
 * @Date 2018/5/11 0011 上午 11:51
 * @Description 图片加载封装
 */

public class ImageLoader extends AppGlideModule {

    /**
     * 加载带有默认图片
     *
     * @param context
     * @param url
     * @param imageView
     * @param defaultResId
     */
    public static void loadCenterCrop(Context context, String url, ImageView imageView, int defaultResId) {
        if (SettingUtils.getInstance().getIsNoPhotoMode() && NetWorkUtil.isMobileConnected(InitApp.appContext)) {
            imageView.setImageResource(defaultResId);
        } else {
            Glide
                    .with(context)
                    .load(url)
                    .transition(withCrossFade())
                    .apply(new RequestOptions().centerCrop())
                    .into(imageView);
        }
    }


    /**
     * 加载带有默认图片
     *
     * @param context
     * @param url
     * @param imageView
     * @param defaultResId
     */
    public static void loadCenterCrop(Context context, String url, ImageView imageView, int defaultResId, int errorResId) {
        if (SettingUtils.getInstance().getIsNoPhotoMode() && NetWorkUtil.isMobileConnected(InitApp.appContext)) {
            imageView.setImageResource(defaultResId);
        } else {
            Glide
                    .with(context)
                    .load(url)
                    .transition(withCrossFade())
                    .apply(new RequestOptions().centerCrop().error(errorResId))
                    .into(imageView);
        }
    }

    /**
     * 加载一般图片
     *
     * @param context
     * @param url
     * @param imageView
     */
    public static void loadNormal(Context context, String url, ImageView imageView) {
        Glide
                .with(context)
                .load(url)
                .into(imageView);
    }

}
