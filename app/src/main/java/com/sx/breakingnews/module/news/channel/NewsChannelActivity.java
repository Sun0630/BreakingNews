package com.sx.breakingnews.module.news.channel;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

import com.sx.breakingnews.Constant;
import com.sx.breakingnews.R;
import com.sx.breakingnews.adapter.news.NewsChannelAdapter;
import com.sx.breakingnews.bean.news.NewsChannelBean;
import com.sx.breakingnews.database.dao.NewsChannelDao;
import com.sx.breakingnews.module.base.BaseActivity;
import com.sx.breakingnews.widget.helper.ItemDragHelperCallback;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author sunxin
 * @Date 2018/5/17 0017 下午 3:15
 * @Description 新闻频道选择
 */

public class NewsChannelActivity extends BaseActivity {

    private RecyclerView mRecyclerView;

    private NewsChannelDao mDao = new NewsChannelDao();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_channel);
        initView();
        initData();
    }

    private void initView() {
        initToolBar(findViewById(R.id.toolbar),true,getString(R.string.item_title_drag));
        mRecyclerView = findViewById(R.id.recycler_view);
    }

    private void initData() {
        //有可用条目和不可用条目，从数据库中查询
        List<NewsChannelBean> enableItems = mDao.query(Constant.NEWS_CHANNEL_ENABLE);
        List<NewsChannelBean> disableItems = mDao.query(Constant.NEWS_CHANNEL_DISABLE);

        List<String> items = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            items.add("hhh");
        }

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,4);
        mRecyclerView.setLayoutManager(gridLayoutManager);
        ItemDragHelperCallback callback = new ItemDragHelperCallback();
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(callback);
        itemTouchHelper.attachToRecyclerView(mRecyclerView);

        NewsChannelAdapter adapter = new NewsChannelAdapter(this,itemTouchHelper,items,disableItems);
        mRecyclerView.setAdapter(adapter);



    }
}
