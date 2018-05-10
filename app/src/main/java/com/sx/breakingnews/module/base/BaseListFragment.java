package com.sx.breakingnews.module.base;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.sx.breakingnews.R;

import java.util.List;

/**
 * @Author Administrator
 * @Date 2018/5/10 0010 上午 11:20
 * @Description 列表Fragment的基类
 */

public class BaseListFragment<T extends IBasePresenter> extends LazyLoadFragment<T> implements IBaseListView<T>, SwipeRefreshLayout.OnRefreshListener {


    private RecyclerView mRecyclerView;
    private SwipeRefreshLayout mSwipeRefreshLayout;

    @Override
    protected int attachLayoutId() {
        return R.layout.fragment_list;
    }


    @Override
    protected void initView(View view) {
        mRecyclerView = view.findViewById(R.id.recycler_view);
        mSwipeRefreshLayout = view.findViewById(R.id.refresh_layout);

        mRecyclerView.setHasFixedSize(true);
//        mSwipeRefreshLayout.setColorSchemeColors();
        mSwipeRefreshLayout.setOnRefreshListener(this);
    }


    @Override
    protected void initData() {

    }


    @Override
    public void onShowLoading() {
        mSwipeRefreshLayout.post(() -> mSwipeRefreshLayout.setRefreshing(true));
    }

    @Override
    public void onHideLoading() {
        mSwipeRefreshLayout.post(new Runnable() {
            @Override
            public void run() {
                mSwipeRefreshLayout.setRefreshing(false);
            }
        });
    }

    @Override
    public void onShowNetWorkError() {
        Toast.makeText(getActivity(), "网络不给力", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void setPresenter(T presenter) {

    }

    @Override
    public void onSetAdapter(List<?> list) {

    }

    @Override
    public void onShowNoMore() {

    }

    @Override
    protected void fetchData() {

    }


    @Override
    public void onRefresh() {

    }
}
