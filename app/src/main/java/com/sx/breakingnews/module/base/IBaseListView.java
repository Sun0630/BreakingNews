package com.sx.breakingnews.module.base;

import java.util.List;

/**
 * @Author Administrator
 * @Date 2018/4/13 0013 下午 2:24
 * @Description
 */

public interface IBaseListView<T> extends IBaseView<T> {

    /**
     * 显示加载动画
     */
    @Override
    void onShowLoading();

    /**
     * 隐藏加载动画
     */
    @Override
    void onHideLoading();

    /**
     * 显示网络错误
     */
    @Override
    void onShowNetWorkError();

    /**
     * 设置presenter
     *
     * @param presenter
     */
    @Override
    void setPresenter(T presenter);

    /**
     * 设置适配器
     *
     * @param list
     */
    void onSetAdapter(List<?> list);

    /**
     * 加载完毕
     */
    void onShowNoMore();

}
