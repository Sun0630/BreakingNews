package com.sx.breakingnews.module.news;

import android.os.Bundle;
import android.view.View;

import com.sx.breakingnews.module.base.BaseListFragment;
import com.sx.breakingnews.module.news.article.INewsArtivle;

/**
 * @Author sunxin
 * @Date 2018/5/10 0010 上午 11:14
 * @Description 新闻文章列表页面
 */

public class NewsArticleView extends BaseListFragment<INewsArtivle.Presenter> implements INewsArtivle.View{

    public static final String TAG = "NewsArticleView";

    public static NewsArticleView newInstance(String categoryId) {
        Bundle bundle = new Bundle();
        bundle.putString(TAG, categoryId);
        NewsArticleView newsArticleView = new NewsArticleView();
        newsArticleView.setArguments(bundle);

        return newsArticleView;
    }

    @Override
    protected void fetchData() {
        super.fetchData();
        onLoadData();

    }

    @Override
    public void onLoadData() {

    }

    @Override
    public void onRefresh() {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView(View view) {

    }

    @Override
    public void setPresenter(INewsArtivle.Presenter presenter) {
        super.setPresenter(presenter);

    }
}
