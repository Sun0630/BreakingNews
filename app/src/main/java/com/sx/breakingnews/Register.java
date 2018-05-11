package com.sx.breakingnews;

import com.sx.breakingnews.bean.Loading;
import com.sx.breakingnews.bean.LoadingEnd;
import com.sx.breakingnews.bean.news.MultiNewsArticleDataBean;
import com.sx.breakingnews.viewbinder.LoadingEndViewBinder;
import com.sx.breakingnews.viewbinder.LoadingViewBinder;
import com.sx.breakingnews.viewbinder.news.NewsArticleImgViewBinder;
import com.sx.breakingnews.viewbinder.news.NewsArticleTextViewBinder;
import com.sx.breakingnews.viewbinder.news.NewsArticleVideoViewBinder;

import me.drakeet.multitype.MultiTypeAdapter;

/**
 * @Author Administrator
 * @Date 2018/5/11 0011 上午 11:01
 * @Description 多类型条目注册
 */

public class Register {

    public static void registerNewsArticleItem(MultiTypeAdapter adapter) {
        //一个类型对应多个ItemViewBinder
        adapter
                .register(MultiNewsArticleDataBean.class)
                .to(
                        new NewsArticleImgViewBinder(),
                        new NewsArticleTextViewBinder(),
                        new NewsArticleVideoViewBinder()
                )
                .withClassLinker((position, dataBean) -> {
                    if (dataBean.isHas_video()) {

                        return NewsArticleVideoViewBinder.class;
                    }

                    if (null != dataBean.getLarge_image_list() && dataBean.getLarge_image_list().size() > 0) {
                        return NewsArticleImgViewBinder.class;
                    }

                    return NewsArticleTextViewBinder.class;
                });

        //加载中
        adapter.register(Loading.class,new LoadingViewBinder());

        //加载到底部
        adapter.register(LoadingEnd.class,new LoadingEndViewBinder());

    }

}
