package com.sx.breakingnews.module.base;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.orhanobut.logger.Logger;
import com.sx.breakingnews.R;
import com.sx.breakingnews.bean.LoadingEnd;

import me.drakeet.multitype.Items;
import me.drakeet.multitype.MultiTypeAdapter;

/**
 * @Author Administrator
 * @Date 2018/5/10 0010 上午 11:20
 * @Description 列表Fragment的基类
 */

public abstract class BaseListFragment<T extends IBasePresenter> extends LazyLoadFragment<T> implements IBaseListView<T>, SwipeRefreshLayout.OnRefreshListener {


    protected RecyclerView mRecyclerView;
    protected SwipeRefreshLayout mSwipeRefreshLayout;
    protected MultiTypeAdapter mAdapter;

    protected Items oldItems = new Items();

    protected boolean canLoadMore = false;

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
    public void onShowLoading() {
        mSwipeRefreshLayout.post(() -> mSwipeRefreshLayout.setRefreshing(true));
    }

    @Override
    public void onHideLoading() {
        mSwipeRefreshLayout.post(() -> mSwipeRefreshLayout.setRefreshing(false));
    }

    @Override
    public void onShowNetWorkError() {
        Toast.makeText(getActivity(), "网络不给力", Toast.LENGTH_SHORT).show();
        mAdapter.setItems(new Items());
        mAdapter.notifyDataSetChanged();
        canLoadMore = false;
    }


    @Override
    public void onShowNoMore() {
        if (oldItems.size() > 0) {
            Items newItems = new Items(oldItems);
            newItems.remove(newItems.size()-1);
            newItems.add(new LoadingEnd());
            mAdapter.setItems(newItems);
            mAdapter.notifyDataSetChanged();
        } else {
            oldItems.add(new LoadingEnd());
            mAdapter.setItems(oldItems);
            mAdapter.notifyDataSetChanged();
        }
        canLoadMore = false;
    }

    @Override
    protected void fetchData() {
        Logger.e("fetchData");
    }


    @Override
    public void onRefresh() {
        LinearLayoutManager layoutManager = (LinearLayoutManager) mRecyclerView.getLayoutManager();
        int firstVisibleItemPosition = layoutManager.findFirstVisibleItemPosition();
        if (firstVisibleItemPosition == 0) {
            presenter.doRefresh();
        }
//        mRecyclerView.scrollToPosition(5);
        mRecyclerView.smoothScrollToPosition(0);
    }
}
