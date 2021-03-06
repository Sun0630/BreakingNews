package com.sx.breakingnews.module.base;

import android.arch.lifecycle.Lifecycle;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.uber.autodispose.AutoDispose;
import com.uber.autodispose.AutoDisposeConverter;
import com.uber.autodispose.android.lifecycle.AndroidLifecycleScopeProvider;

/**
 * @Author Administrator
 * @Date 2018/5/10 0010 上午 11:23
 * @Description
 */

public abstract class BaseFragment<T extends IBasePresenter> extends Fragment implements IBaseView<T>{

    protected T presenter;

    @Nullable

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(attachLayoutId(), container, false);
        initView(view);
        initData();
        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setPresenter(presenter);
    }


    public void initToolBar(Toolbar toolbar, boolean homeAsUpEnable, String title){
        ((BaseActivity)getActivity()).initToolBar(toolbar,homeAsUpEnable,title);
    }


    /**
     * 绑定视图ID
     *
     * @return
     */
    protected abstract int attachLayoutId();


    /**
     * 初始化视图
     *
     * @param view
     */
    protected abstract void initView(View view);


    /**
     * 初始化数据
     */
    protected abstract void initData();


    /**
     * 绑定生命周期
     */
    @Override
    public <X> AutoDisposeConverter<X> bindAutoDispose() {
        return AutoDispose.autoDisposable(AndroidLifecycleScopeProvider
                .from(this, Lifecycle.Event.ON_DESTROY));
    }

}
