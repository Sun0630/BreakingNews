package com.sx.breakingnews.module.news;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.sx.breakingnews.Constant;
import com.sx.breakingnews.R;
import com.sx.breakingnews.adapter.base.BasePagerAdapter;
import com.sx.breakingnews.bean.news.NewsChannelBean;
import com.sx.breakingnews.database.dao.NewsChannelDao;
import com.sx.breakingnews.module.news.article.NewsArticleView;
import com.sx.breakingnews.module.news.channel.NewsChannelActivity;
import com.sx.breakingnews.module.wenda.WendaArticleView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Sunxin
 * @Date 2017/11/16 0016 上午 9:40
 * @Description
 */

public class NewsTabLayout extends Fragment {

    public static NewsTabLayout instance;
    private ViewPager mViewPager;
    private LinearLayout mLinearLayout;
    private NewsChannelDao mDao = new NewsChannelDao();
    private List<Fragment> mFragmentList;
    private List<String> mTitleList;
    private Map<String, Fragment> mMap = new HashMap<>();
    private TabLayout mTabLayout;
    private BasePagerAdapter mAdapter;

    public static NewsTabLayout getInstance() {
        if (instance == null) {
            instance = new NewsTabLayout();
        }
        return instance;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_news_tab, container, false);
        initView(view);
        initData();
        return view;
    }


    private void initView(View view) {
        mTabLayout = view.findViewById(R.id.tab_layout_news);
        mViewPager = view.findViewById(R.id.view_pager_news);
        ImageView add_channel_iv = view.findViewById(R.id.add_channel_iv);
        mLinearLayout = view.findViewById(R.id.header_layout);

        mTabLayout.setTabTextColors(R.color.cardview_shadow_end_color,R.color.colorAccent);
        mTabLayout.setSelectedTabIndicatorColor(getResources().getColor(R.color.colorAccent));
        mTabLayout.setupWithViewPager(mViewPager);
        mTabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);

        add_channel_iv.setOnClickListener(v -> startActivity(new Intent(getActivity(), NewsChannelActivity.class)));
    }

    private void initData() {
        initTabs();
        mAdapter = new BasePagerAdapter(getChildFragmentManager(), mFragmentList, mTitleList);
        mViewPager.setAdapter(mAdapter);
        mViewPager.setOffscreenPageLimit(15);


    }

    private void initTabs() {
        List<NewsChannelBean> channelList = mDao.query(1);
        mFragmentList = new ArrayList<>();
        mTitleList = new ArrayList<>();

        if (channelList.size() == 0) {
            mDao.addInitData();
            channelList = mDao.query(Constant.NEWS_CHANNEL_ENABLE);
        }

        for (NewsChannelBean bean : channelList) {
            String channelId = bean.getChannelId();

            Fragment fragment = null;

            switch (channelId) {
                case "question_and_answer":
                    if (mMap.containsKey(channelId)) {
                        mFragmentList.add(mMap.get(channelId));
                    } else {
                        //todo 问答页面
                        mFragmentList.add(new WendaArticleView());
                    }
                    break;
                default:
                    if (mMap.containsKey(channelId)) {
                        mFragmentList.add(mMap.get(channelId));
                    } else {
                        // 新闻页面
                        fragment = NewsArticleView.newInstance(channelId);
                        mFragmentList.add(fragment);
                    }

                    break;
            }

            mTitleList.add(bean.getChannelName());
            if (fragment != null) {
                mMap.put(channelId, fragment);
            }
        }

    }


}
