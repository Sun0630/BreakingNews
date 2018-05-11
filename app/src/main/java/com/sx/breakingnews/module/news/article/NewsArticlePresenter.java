package com.sx.breakingnews.module.news.article;

import android.text.TextUtils;
import android.util.Log;

import com.google.gson.Gson;
import com.orhanobut.logger.Logger;
import com.sx.breakingnews.ErrorAction;
import com.sx.breakingnews.api.IMobileNewsApi;
import com.sx.breakingnews.bean.news.MultiNewsArticleBean;
import com.sx.breakingnews.bean.news.MultiNewsArticleDataBean;
import com.sx.breakingnews.http.RetrofitFactory;
import com.sx.breakingnews.utils.TimeUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * @Author Administrator
 * @Date 2018/5/10 0010 下午 1:40
 * @Description 新闻文章的presenter ，需要持有一个View对象，通过构造函数传入
 */

public class NewsArticlePresenter implements INewsArticle.Presenter {

    public static final String TAG = "NewsArticlePresenter";

    private INewsArticle.View mView;
    private String category;
    private String time;

    private List<MultiNewsArticleDataBean> datalist = new ArrayList<>();
    private Gson mGson = new Gson();
    private Random mRandom = new Random();

    public NewsArticlePresenter(INewsArticle.View view) {
        mView = view;
        this.time = TimeUtil.getCurrentTimeStamp();
    }



    @Override
    public void doShowNetError() {
        mView.onShowNoMore();
        mView.onShowNetWorkError();
        mView.onHideLoading();
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

        //释放内存
        if (datalist.size()>150){
            datalist.clear();
        }

        Logger.e("Category:" + this.category);

        //开始请求网络

        getRandom()
                .subscribeOn(Schedulers.io())
                .switchMap(multiNewsArticleBean -> {
                    List<MultiNewsArticleDataBean> dataList = new ArrayList<>();
                    for (MultiNewsArticleBean.DataBean dataBean : multiNewsArticleBean.getData()) {
                        dataList.add(mGson.fromJson(dataBean.getContent(), MultiNewsArticleDataBean.class));
                    }
                    return Observable.fromIterable(dataList);
                })
                .filter(dataBean -> {
                    time = String.valueOf(dataBean.getBehot_time());
                    if (TextUtils.isEmpty(dataBean.getSource())) {
                        return false;
                    }
                    try {
                        // 过滤头条问答新闻
                        if (dataBean.getSource().contains("头条问答")
                                || dataBean.getTag().contains("ad")
                                || dataBean.getSource().contains("悟空问答")) {
                            return false;
                        }
                        // 过滤头条问答新闻
                        if (dataBean.getRead_count() == 0 || TextUtils.isEmpty(dataBean.getMedia_name())) {
                            String title = dataBean.getTitle();
                            if (title.lastIndexOf("？") == title.length() - 1) {
                                return false;
                            }
                        }
                    } catch (NullPointerException e) {
                        ErrorAction.print(e);
                    }
                    // 过滤重复新闻(与上次刷新的数据比较)
                    for (MultiNewsArticleDataBean bean : datalist) {
                        if (bean.getTitle().equals(dataBean.getTitle())) {
                            return false;
                        }
                    }
                    return true;
                })
                .toList()
                .map(list -> {
                    // 过滤重复新闻(与本次刷新的数据比较,因为使用了2个请求,数据会有重复)
                    for (int i = 0; i < list.size() - 1; i++) {
                        for (int j = list.size() - 1; j > i; j--) {
                            if (list.get(j).getTitle().equals(list.get(i).getTitle())) {
                                list.remove(j);
                            }
                        }
                    }
                    return list;
                })
                .observeOn(AndroidSchedulers.mainThread())
//                .as(view.bindAutoDispose())
                .subscribe(list -> {
                    Log.e(TAG, "subscribe " + list.size());
                    if (null != list && list.size() > 0) {
                        doSetAdapter(list);
                    } else {
                        doShowNoMore();
                    }
                }, throwable -> {
                    doShowNetError();
                    ErrorAction.print(throwable);
                });

    }


    @Override
    public void doRefresh() {
        if (datalist.size() != 0){
            datalist.clear();
            time = TimeUtil.getCurrentTimeStamp();
        }
        mView.onShowLoading();
        onLoadData();
    }

    @Override
    public void doLoadMoreData() {
        onLoadData();
    }

    @Override
    public void doSetAdapter(List<MultiNewsArticleDataBean> dataBeans) {
        datalist.addAll(dataBeans);
        mView.onSetAdapter(datalist);
        mView.onHideLoading();
    }

    @Override
    public void doShowNoMore() {
        mView.onHideLoading();
        mView.onShowNoMore();
    }


    public Observable<MultiNewsArticleBean> getRandom() {
        int i = mRandom.nextInt(10);

        if (i % 2 == 0) {
            return RetrofitFactory
                    .getRetrofit()
                    .create(IMobileNewsApi.class)
                    .getNewsAritcle(this.category, this.time);
        } else {
            return RetrofitFactory
                    .getRetrofit()
                    .create(IMobileNewsApi.class)
                    .getNewsAritcle2(this.category, this.time);
        }
    }

}
