package com.sx.breakingnews.module.news.article;

import com.sx.breakingnews.bean.news.MultiNewsArticleDataBean;
import com.sx.breakingnews.module.base.IBaseListView;
import com.sx.breakingnews.module.base.IBasePresenter;

import java.util.List;

/**
 * @Author Administrator
 * @Date 2018/5/10 0010 上午 11:45
 * @Description
 */

public interface INewsArticle {

    interface View extends IBaseListView<Presenter>{

        /**
         * 请求数据
         */
        void onLoadData();

        /**
         * 刷新
         */
        void onRefresh();
    }


    interface Presenter extends IBasePresenter{
        /**
         * 请求数据
         * @param category
         */
        void onLoadData(String... category);

        /**
         * 请求更多数据
         */
        void doLoadMoreData();

        /**
         * 设置适配器
         * @param dataBeans
         */
        void doSetAdapter(List<MultiNewsArticleDataBean> dataBeans);

        /**
         * 加载完毕
         */
        void doShowNoMore();


    }


}
