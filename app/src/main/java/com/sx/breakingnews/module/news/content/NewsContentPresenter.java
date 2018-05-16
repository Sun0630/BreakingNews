package com.sx.breakingnews.module.news.content;

import com.orhanobut.logger.Logger;
import com.sx.breakingnews.ErrorAction;
import com.sx.breakingnews.api.INewsApi;
import com.sx.breakingnews.bean.news.MultiNewsArticleDataBean;
import com.sx.breakingnews.bean.news.NewsContentBean;
import com.sx.breakingnews.http.RetrofitFactory;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * @Author Administrator
 * @Date 2018/5/16 0016 下午 4:09
 * @Description
 */

public class NewsContentPresenter implements INewsContent.Presenter {


    private INewsContent.View mView;
    private String mHtml;


    public NewsContentPresenter(INewsContent.View view) {
        mView = view;
    }

    @Override
    public void doLoadData(MultiNewsArticleDataBean dataBean) {
        String url = dataBean.getUrl();
        Logger.e("url->" + url);
        //http://toutiao.com/group/6555708452012818958/
        // 将上面的url转换成下面的url
        //https://m.toutiao.com/i6530252650288513540/info/

        String api = url.replace("www.", "")
                .replace("toutiao", "m.toutiao")
                .replace("group/", "i") + "info/";

        Observable
                .just(api)
                .subscribeOn(Schedulers.io())
                .switchMap(newsUrl -> RetrofitFactory
                        .getRetrofit()
                        .create(INewsApi.class)
                        .getNewsContent(newsUrl))
                .map(this::getHtml)
                .observeOn(AndroidSchedulers.mainThread())
                .as(mView.bindAutoDispose())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(String s) {
                        mView.onSetWebView(s, true);
                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.onSetWebView(null, false);
                        ErrorAction.print(e);
                    }

                    @Override
                    public void onComplete() {
                        doShowNetError();
                    }
                });


    }


    private String getHtml(NewsContentBean newsContentBean) {
        String title = newsContentBean.getData().getTitle();
        String content = newsContentBean.getData().getContent();
        if (content != null) {
            String css = "<link rel=\"stylesheet\" href=\"file:///android_asset/toutiao_light.css\" type=\"text/css\">";
            //是否开启夜间模式
//            if (SettingUtil.getInstance().getIsNightMode()) {
//                css = css.replace("toutiao_light", "toutiao_dark");
//            }

            mHtml = "<!DOCTYPE html>\n" +
                    "<html lang=\"en\">\n" +
                    "<head>\n" +
                    "    <meta charset=\"UTF-8\">" +
                    css +
                    "<body>\n" +
                    "<article class=\"article-container\">\n" +
                    "    <div class=\"article__content article-content\">" +
                    "<h1 class=\"article-title\">" +
                    title +
                    "</h1>" +
                    content +
                    "    </div>\n" +
                    "</article>\n" +
                    "</body>\n" +
                    "</html>";

            return mHtml;
        } else {
            return null;
        }
    }


    @Override
    public void doRefresh() {

    }

    @Override
    public void doShowNetError() {
        mView.onHideLoading();
        mView.onShowNetWorkError();
    }


}
