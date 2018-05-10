package com.sx.breakingnews.module.news.article;

import com.sx.breakingnews.ErrorAction;

/**
 * @Author Administrator
 * @Date 2018/5/10 0010 下午 1:40
 * @Description 新闻文章的presenter ，需要持有一个View对象，通过构造函数传入
 */

public class NewsArticlePresenter implements INewsArtivle.Presenter {

    public static final String TAG = "NewsArticlePresenter";

    private INewsArtivle.View mView;
    private String category;

    public NewsArticlePresenter(INewsArtivle.View view) {
        mView = view;
    }

    @Override
    public void doRefresh() {

    }

    @Override
    public void doShowNetError() {

    }

    @Override
    public void onLoadData(String... category) {
        //获取数据
        try {
            if (category == null) {
                this.category = category[0];
            }
        } catch (Exception e) {
            ErrorAction.print(e);
        }





    }

    @Override
    public void doLoadMoreData() {

    }

    @Override
    public void doSetAdapter() {

    }

    @Override
    public void doShowNoMore() {

    }


}
