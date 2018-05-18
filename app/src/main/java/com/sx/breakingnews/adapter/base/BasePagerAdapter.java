package com.sx.breakingnews.adapter.base;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author Administrator
 * @Date 2018/5/11 0011 上午 8:46
 * @Description ViewPagerAdapter
 */

public class BasePagerAdapter extends FragmentStatePagerAdapter {

    private List<Fragment> mFragmentList;
    private List<String> mTitleList;

    public BasePagerAdapter(FragmentManager fm, List<Fragment> fragmentList, List<String> titleList) {
        super(fm);
        mFragmentList = fragmentList;
        mTitleList = titleList;
    }

    public BasePagerAdapter(FragmentManager fm, List<Fragment> fragmentList, String[] titleList) {
        super(fm);
        mFragmentList = fragmentList;
        mTitleList = new ArrayList<>(Arrays.asList(titleList));
    }

    @Override
    public Fragment getItem(int position) {
        return mFragmentList.get(position);
    }

    @Override
    public int getCount() {
        return mTitleList.size();
    }

    @Override
    public int getItemPosition(@NonNull Object object) {
        return PagerAdapter.POSITION_NONE;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mTitleList.get(position);
    }

    public void recreateItems(List<Fragment> fragmentList, List<String> titleList) {
        this.mFragmentList = fragmentList;
        this.mTitleList = titleList;
        notifyDataSetChanged();
    }
}
