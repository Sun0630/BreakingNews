package com.sx.breakingnews.module.news.content;

import android.content.Intent;
import android.os.Bundle;

import com.sx.breakingnews.InitApp;
import com.sx.breakingnews.R;
import com.sx.breakingnews.bean.news.MultiNewsArticleDataBean;
import com.sx.breakingnews.module.base.BaseActivity;

/**
 * @author sunxin
 * @desc 新闻内容页面
 */
public class NewsContentActivity extends BaseActivity {


    private static final String TAG = "NewsContentActivity";
    private static final String IMG = "IMG";

    public static void launch(MultiNewsArticleDataBean bean){
        InitApp.appContext.startActivity(new Intent(InitApp.appContext,NewsContentActivity.class)
                .putExtra(TAG,bean)
                .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
    }

    public static void launch(MultiNewsArticleDataBean bean,String imgUrl){
        InitApp.appContext.startActivity(new Intent(InitApp.appContext,NewsContentActivity.class)
                .putExtra(TAG,bean)
                .putExtra(IMG,imgUrl)
                .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_content);

        Intent intent = getIntent();
        //显示一个Fragment加入到容器中
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container,
                        NewsContentFragment.newInstance(intent.getParcelableExtra(TAG),intent.getStringExtra(IMG)))
                .commit();
    }
}
