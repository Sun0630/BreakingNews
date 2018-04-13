package com.sx.breakingnews.database.dao;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.sx.breakingnews.Constant;
import com.sx.breakingnews.InitApp;
import com.sx.breakingnews.R;
import com.sx.breakingnews.bean.news.NewsChannelBean;
import com.sx.breakingnews.database.DatabaseHelper;
import com.sx.breakingnews.database.table.NewsChannelTable;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Administrator
 * @Date 2018/4/13 0013 上午 11:27
 * @Description 新闻频道数据库操作类
 */

public class NewsChannelDao {


    private SQLiteDatabase db;

    public NewsChannelDao() {
        db = DatabaseHelper.getDatabase();
    }


    public void addInitData() {
        String categoryId[] = InitApp.appContext.getResources().getStringArray(R.array.mobile_news_id);
        String categoryName[] = InitApp.appContext.getResources().getStringArray(R.array.mobile_news_name);
        for (int i = 0; i < 8; i++) {
            add(categoryId[i], categoryName[i], Constant.NEWS_CHANNEL_ENABLE, i);
        }
        for (int i = 8; i < categoryId.length; i++) {
            add(categoryId[i], categoryName[i], Constant.NEWS_CHANNEL_DISABLE, i);
        }
    }

    private boolean add(String channelId, String channelName, int isEnable, int position) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(NewsChannelTable.ID, channelId);
        contentValues.put(NewsChannelTable.NAME, channelName);
        contentValues.put(NewsChannelTable.IS_ENABLE, isEnable);
        contentValues.put(NewsChannelTable.POSITION, position);
        long result = db.insert(NewsChannelTable.TABLENAME, null, contentValues);
        return result != -1;

    }


    public List<NewsChannelBean> query(int isEnable) {
        Cursor cursor = db.query(NewsChannelTable.TABLENAME, null, NewsChannelTable.IS_ENABLE + "=?", new String[]{isEnable + ""}, null, null, null);
        List<NewsChannelBean> list = new ArrayList<>();
        while (cursor.moveToNext()) {
            NewsChannelBean bean = new NewsChannelBean();
            bean.setChannelId(cursor.getString(NewsChannelTable.ID_ID));
            bean.setChannelName(cursor.getString(NewsChannelTable.ID_NAME));
            bean.setIsEnable(cursor.getInt(NewsChannelTable.ID_ISENABLE));
            bean.setPosition(cursor.getInt(NewsChannelTable.ID_POSITION));
            list.add(bean);
        }
        cursor.close();
        return list;
    }


}
