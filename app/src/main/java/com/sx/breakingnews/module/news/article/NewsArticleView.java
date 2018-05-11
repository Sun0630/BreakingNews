package com.sx.breakingnews.module.news.article;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.sx.breakingnews.DiffCallback;
import com.sx.breakingnews.InitApp;
import com.sx.breakingnews.Register;
import com.sx.breakingnews.bean.Loading;
import com.sx.breakingnews.listener.OnLoadMoreListener;
import com.sx.breakingnews.module.base.BaseListFragment;

import java.util.List;

import me.drakeet.multitype.Items;
import me.drakeet.multitype.MultiTypeAdapter;

/**
 * @Author sunxin
 * @Date 2018/5/10 0010 上午 11:14
 * @Description 新闻文章列表页面
 */

public class NewsArticleView extends BaseListFragment<INewsArticle.Presenter> implements INewsArticle.View{

    public static final String TAG = "NewsArticleView";
    private String mCategoryId;


    public static NewsArticleView newInstance(String categoryId) {
        Bundle bundle = new Bundle();
        bundle.putString(TAG, categoryId);
        NewsArticleView newsArticleView = new NewsArticleView();
        newsArticleView.setArguments(bundle);

        return newsArticleView;
    }

    @Override
    protected void initView(View view) {
        super.initView(view);
        mAdapter = new MultiTypeAdapter(oldItems);
        Register.registerNewsArticleItem(mAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(InitApp.appContext,LinearLayoutManager.VERTICAL,false));
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.addOnScrollListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore() {
                canLoadMore = false;
                presenter.doLoadMoreData();
            }
        });
    }

    @Override
    protected void initData() {
        mCategoryId = getArguments().getString(TAG);
    }


    @Override
    protected void fetchData() {
        super.fetchData();
        onLoadData();
    }

    @Override
    public void onLoadData() {
        onShowLoading();
        //加载数据
        presenter.onLoadData(mCategoryId);
    }

    @Override
    public void onSetAdapter(List<?> list) {
        Items newItems = new Items(list);
        newItems.add(new Loading());
        DiffCallback.create(oldItems,newItems,mAdapter);
        oldItems.clear();
        oldItems.addAll(newItems);
        canLoadMore = true;
    }


    @Override
    public void setPresenter(INewsArticle.Presenter presenter) {
        if (presenter == null) {
            this.presenter = new NewsArticlePresenter(this);
        }
    }
}
