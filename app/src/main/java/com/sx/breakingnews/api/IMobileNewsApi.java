package com.sx.breakingnews.api;

import com.sx.breakingnews.bean.news.MultiNewsArticleBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * @Author Administrator
 * @Date 2018/5/10 0010 下午 4:09
 * @Description
 */

public interface IMobileNewsApi {

    /**
     * 获取个性化新闻
     * @param category
     * @param maxBeHotTime
     * @return
     */
    @GET("http://is.snssdk.com/api/news/feed/v62/?iid=5034850950&device_id=6096495334&refer=1&count=20&aid=13")
    Observable<MultiNewsArticleBean> getNewsAritcle(
            @Query("category") String category,
            @Query("max_behot_time") String maxBeHotTime
    );


    /**
     * 获取个性化新闻
     * @param category
     * @param maxBeHotTime
     * @return
     */
    @GET("http://lf.snssdk.com/api/news/feed/v62/?iid=12507202490&device_id=37487219424&refer=1&count=20&aid=13")
    Observable<MultiNewsArticleBean> getNewsAritcle2(
            @Query("category") String category,
            @Query("max_behot_time") String maxBeHotTime
    );


}
