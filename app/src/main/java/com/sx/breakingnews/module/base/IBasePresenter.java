package com.sx.breakingnews.module.base;

/**
 * @Author Administrator
 * @Date 2018/4/13 0013 下午 2:22
 * @Description P 层 顶层接口
 */

public interface IBasePresenter {


    /**
     * 刷新数据
     */
    void doRefresh();

    /**
     * 显示网络错误
     */
    void doShowNetWorkError();

}
