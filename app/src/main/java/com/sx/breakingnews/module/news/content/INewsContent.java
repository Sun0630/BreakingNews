package com.sx.breakingnews.module.news.content;

import com.sx.breakingnews.bean.news.MultiNewsArticleDataBean;
import com.sx.breakingnews.module.base.IBasePresenter;
import com.sx.breakingnews.module.base.IBaseView;

/**
 * @Author Administrator
 * @Date 2018/5/14 0014 上午 9:55
 * @Description
 */

public interface INewsContent {

    interface View extends IBaseView<Presenter> {
        /**
         * 设置网页连接
         * @param url
         * @param flag
         */
        void onSetWebView(String url,boolean flag);
    }

    interface Presenter extends IBasePresenter{
        /**
         * 请求数据
         * @param dataBean
         */
        void doLoadData(MultiNewsArticleDataBean dataBean);
    }


}
