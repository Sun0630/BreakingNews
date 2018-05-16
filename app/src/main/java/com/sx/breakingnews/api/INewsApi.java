package com.sx.breakingnews.api;

import com.sx.breakingnews.bean.news.NewsContentBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Url;

/**
 * @Author Administrator
 * @Date 2018/5/11 0011 上午 9:44
 * @Description
 */

public interface INewsApi {
    String HOST = "http://toutiao.com/";


    /**
     * 获取新闻HTML内容
     * @param url https://m.toutiao.com/i6530252650288513540/info/
     * @return
     */
    @GET
    Observable<NewsContentBean> getNewsContent(@Url String url);

}
