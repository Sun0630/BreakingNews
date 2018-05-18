package com.sx.breakingnews.module.news.content;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.ContentLoadingProgressBar;
import android.support.v4.widget.NestedScrollView;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.webkit.WebView;
import android.widget.ImageView;

import com.orhanobut.logger.Logger;
import com.sx.breakingnews.ErrorAction;
import com.sx.breakingnews.R;
import com.sx.breakingnews.bean.news.MultiNewsArticleDataBean;
import com.sx.breakingnews.module.base.BaseFragment;
import com.sx.breakingnews.utils.ImageLoader;
import com.sx.breakingnews.widget.helper.AppBarStateChangeListener;

/**
 * @Author Administrator
 * @Date 2018/5/14 0014 上午 9:54
 * @Description
 */

public class NewsContentFragment extends BaseFragment<INewsContent.Presenter> implements INewsContent.View {


    private static final String TAG = "NewsContentFragment";
    private static final String IMG = "img";
    private String mImgUrl;
    private Toolbar mToolbar;
    private WebView mWebView;
    private NestedScrollView mScrollView;
    private ContentLoadingProgressBar mProgressBar;
    private SwipeRefreshLayout mSwipeRefreshLayout;
    private Bundle mBundle;
    private MultiNewsArticleDataBean mDataBean;
    private INewsContent.Presenter presenter;
    private boolean mIsHasImage;
    private AppBarLayout mAppBarLayout;
    private CollapsingToolbarLayout mCollapsingToolbarLayout;
    private ImageView mImageView;
    private String mShareTitle;
    private String mMediaName;


    public static NewsContentFragment newInstance(Parcelable dataBean, String imgUrl) {
        NewsContentFragment instance = new NewsContentFragment();
        Bundle bundle = new Bundle();
        bundle.putString(IMG, imgUrl);
        bundle.putParcelable(TAG, dataBean);
        instance.setArguments(bundle);
        return instance;
    }

    @Override
    protected int attachLayoutId() {
        mBundle = getArguments();
        if (mBundle != null) {
            mImgUrl = (String) mBundle.get(IMG);
        }

        mIsHasImage = !TextUtils.isEmpty(mImgUrl);


        return mIsHasImage ? R.layout.fragment_news_content_img : R.layout.fragment_news_content;
    }

    @Override
    protected void initView(View view) {
        mToolbar = view.findViewById(R.id.toolbar);
        initToolBar(mToolbar, true, "");

        mWebView = view.findViewById(R.id.webview);
        initWebViewClient();

        mScrollView = view.findViewById(R.id.scrollView);

        mProgressBar = view.findViewById(R.id.pb_progress);
        mProgressBar.show();

        mSwipeRefreshLayout = view.findViewById(R.id.refresh_layout);

        mSwipeRefreshLayout.setOnRefreshListener(() -> {
            mSwipeRefreshLayout.post(()->mSwipeRefreshLayout.setRefreshing(true));
            presenter.doLoadData(mDataBean);
        });
        if (mIsHasImage) {
            //有图片
            mAppBarLayout = view.findViewById(R.id.app_bar_layout);
            mCollapsingToolbarLayout = view.findViewById(R.id.collaps_layout);
            mCollapsingToolbarLayout.setCollapsedTitleTextColor(Color.WHITE);
            mImageView = view.findViewById(R.id.iv_image);
        }

        setHasOptionsMenu(true);

    }

    /**
     * 初始化WebViewClient
     */
    private void initWebViewClient() {


    }


    @Override
    public void onPause() {
        super.onPause();
        if (mIsHasImage) {
            mAppBarLayout.setExpanded(false);
        }
    }

    @Override
    protected void initData() {
        if (mBundle == null) {
            return;
        }
        try {
            mDataBean = mBundle.getParcelable(TAG);
            presenter.doLoadData(mDataBean);
            mShareTitle = mDataBean.getTitle();
            mMediaName = mDataBean.getMedia_name();

        } catch (Exception e) {
            ErrorAction.print(e);
        }


        if (mIsHasImage) {
            ImageLoader
                    .loadCenterCrop(getActivity(), mImgUrl, mImageView, R.mipmap.error_image, R.mipmap.error_image);

            mAppBarLayout.addOnOffsetChangedListener(new AppBarStateChangeListener() {
                @Override
                protected void onStateChange(AppBarLayout layout, STATE state) {
                    Window window = null;
                    if (getActivity() != null && getActivity().getWindow() != null) {
                        window = getActivity().getWindow();
                    }

                    if (state == STATE.EXPANDE) {
                        //展开状态
                        mCollapsingToolbarLayout.setTitle("");
                        mToolbar.setBackgroundColor(Color.TRANSPARENT);
                    } else if (state == STATE.COLLAPSED) {
                        //折叠状态

                    } else {
                        //中间状态
                        mCollapsingToolbarLayout.setTitle(mMediaName);

                        mToolbar.setBackgroundColor(Color.BLUE);
                    }


                }
            });
        } else {
            mToolbar.setTitle(mMediaName);
        }


    }

    @Override
    public void onShowLoading() {
        mProgressBar.show();
    }

    @Override
    public void onHideLoading() {
        mProgressBar.hide();
        mSwipeRefreshLayout.post(() -> mSwipeRefreshLayout.setRefreshing(false));
    }

    @Override
    public void onShowNetWorkError() {
        Snackbar.make(mScrollView, R.string.networkerror, Snackbar.LENGTH_SHORT);
    }

    @Override
    public void setPresenter(INewsContent.Presenter presenter) {
        if (presenter == null) {
            this.presenter = new NewsContentPresenter(this);
        }
    }


    @Override
    public void onSetWebView(String url, boolean flag) {
        Logger.e(url + "--" + flag);
        //判断是否是头条的网站
        if (flag) {
            mWebView.loadDataWithBaseURL(null, url, "text/html", "UTF-8", null);
        }
    }


    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_browser, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                getActivity().onBackPressed();
                break;
            case R.id.action_open_comment:
                Snackbar.make(mToolbar, "打开评论", Snackbar.LENGTH_SHORT).show();
                break;
            case R.id.action_open_media_name:
                Snackbar.make(mToolbar, "打开头条号", Snackbar.LENGTH_SHORT).show();
                break;
            case R.id.action_share:
                Snackbar.make(mToolbar, "分享", Snackbar.LENGTH_SHORT).show();
                break;
            case R.id.action_open_in_browser:
                Snackbar.make(mToolbar, "打开浏览器", Snackbar.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
