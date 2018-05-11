package com.sx.breakingnews.utils;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.sx.breakingnews.InitApp;

/**
 * @Author Administrator
 * @Date 2018/5/11 0011 下午 12:51
 * @Description
 */

public class SettingUtils {

    private SharedPreferences setting = PreferenceManager.getDefaultSharedPreferences(InitApp.appContext);

    public static SettingUtils getInstance() {
        return SettingUtilsInstance.INSTANCE;
    }

    /**
     * 获取字体大小
     */
    public int getTextSize() {
        return setting.getInt("textsize", 16);
    }


    /**
     * 静态内部类实现单例模式
     */
    public static final class SettingUtilsInstance {
        private static final SettingUtils INSTANCE = new SettingUtils();
    }


    /**
     * 是否开启无图模式
     *
     * @return
     */
    public boolean getIsNoPhotoMode() {
        return setting.getBoolean("switch_noPhotoMode", false) && NetWorkUtil.isMobileConnected(InitApp.appContext);
    }

}
