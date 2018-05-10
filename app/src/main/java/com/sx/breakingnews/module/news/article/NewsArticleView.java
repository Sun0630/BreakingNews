package com.sx.breakingnews.module.news.article;

import android.os.Bundle;
import android.view.View;

import com.sx.breakingnews.module.base.BaseListFragment;

/**
 * @Author sunxin
 * @Date 2018/5/10 0010 上午 11:14
 * @Description 新闻文章列表页面
 */

public class NewsArticleView extends BaseListFragment<INewsArtivle.Presenter> implements INewsArtivle.View{

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
    public void onRefresh() {

    }



    @Override
    public void setPresenter(INewsArtivle.Presenter presenter) {
        if (presenter == null) {
            presenter = new NewsArticlePresenter(this);
        }
    }
}
