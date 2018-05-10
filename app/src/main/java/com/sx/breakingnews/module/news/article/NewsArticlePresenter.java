package com.sx.breakingnews.module.news.article;

import android.text.TextUtils;

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
import io.reactivex.ObservableSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import io.reactivex.schedulers.Schedulers;

/**
 * @Author Administrator
 * @Date 2018/5/10 0010 下午 1:40
 * @Description 新闻文章的presenter ，需要持有一个View对象，通过构造函数传入
 */

public class NewsArticlePresenter implements INewsArtivle.Presenter {

    public static final String TAG = "NewsArticlePresenter";

    private INewsArtivle.View mView;
    private String category;
    private String time;

    private List<MultiNewsArticleDataBean> datalist = new ArrayList<>();
    private Gson mGson = new Gson();
    private Random mRandom = new Random();

    public NewsArticlePresenter(INewsArtivle.View view) {
        mView = view;
        this.time = TimeUtil.getCurrentTimeStamp();
    }

    @Override
    public void doRefresh() {

    }

    @Override
    public void doShowNetError() {
        mView.onShowNoMore();
        mView.onShowNetWorkError();
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

        //开始请求网络

        getRandom()
                .subscribeOn(Schedulers.io())
                //转换操作，转换出来的每一个新数据都会取代掉前一个数据
                .switchMap(new Function<MultiNewsArticleBean, ObservableSource<MultiNewsArticleDataBean>>() {
                    @Override
                    public ObservableSource<MultiNewsArticleDataBean> apply(MultiNewsArticleBean bean) throws Exception {
                        for (MultiNewsArticleBean.DataBean dataBean : bean.getData()) {
                            datalist.add(mGson.fromJson(dataBean.getContent(), MultiNewsArticleDataBean.class));
                        }
                        //这个操作符可遍历可迭代的数据
                        return Observable.fromIterable(datalist);
                    }
                })
                .filter(new Predicate<MultiNewsArticleDataBean>() {
                    @Override
                    public boolean test(MultiNewsArticleDataBean dataBean) throws Exception {
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
                    }
                })
                .toList()
                .map(beans -> {
                    //过滤重复新闻，与本次刷新的数据比较，因为使用了2个网络请求，数据会有重复
                    for (int i = 0; i < beans.size() - 1; i++) {
                        for (int j = beans.size() - 1; j > i; j--) {
                            if (beans.get(j).getTitle().equals(beans.get(i).getTitle())) {
                                beans.remove(j);
                            }
                        }
                    }
                    return beans;
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(beans -> {
                    if (null != beans && beans.size() > 0) {
                        Logger.e(beans.toString());
                        doSetAdapter(beans);
                    } else {
                        doShowNoMore();
                    }
                }, throwable -> {
                    doShowNetError();
                    ErrorAction.print(throwable);
                });

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
