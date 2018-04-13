package com.sx.breakingnews.module.base;

/**
 * @Author Administrator
 * @Date 2018/4/13 0013 下午 2:19
 * @Description V 层 顶层接口
 */

public interface IBaseView<T> {

    /**
     * 显示加载动画
     */
    void onShowLoading();

    /**
     * 隐藏加载动画
     */
    void onHideLoading();

    /**
     * 显示网络错误
     */
    void onShowNetWorkError();

    /**
     * 设置presenter
     * @param presenter
     */
    void setPresenter(T presenter);

}
