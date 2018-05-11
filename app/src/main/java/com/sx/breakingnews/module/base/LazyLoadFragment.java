package com.sx.breakingnews.module.base;

import android.os.Bundle;
import android.support.annotation.Nullable;

/**
 * @Author Administrator
 * @Date 2018/5/10 0010 上午 11:22
 * @Description Fragment 懒加载
 */

public abstract class LazyLoadFragment<T extends IBasePresenter> extends BaseFragment<T> {


    /**
     * 是否加载过数据
     */
    protected boolean mIsDataInitiated;
    /**
     * 是否初始化过布局
     */
    protected boolean mIsViewInflate;
    /**
     * 是否对用户可见
     */
    protected boolean mIsVisibleToUser;

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        mIsVisibleToUser = isVisibleToUser;
        if (mIsVisibleToUser) {
            /**
             * 准备获取数据
             */
            prepareFetchData();
        }
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mIsViewInflate = true;
        prepareFetchData();
    }

    private void prepareFetchData() {
        prepareFetchData(false);
    }

    private void prepareFetchData(boolean forceUpdate) {
        if (mIsVisibleToUser && mIsViewInflate && (!mIsDataInitiated || forceUpdate)) {
            fetchData();
            mIsDataInitiated = true;
        }
    }

    /**
     * 获取数据
     */
    protected abstract void fetchData();
}
