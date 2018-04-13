package com.sx.breakingnews.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.sx.breakingnews.InitApp;
import com.sx.breakingnews.database.table.NewsChannelTable;

/**
 * @Author Administrator
 * @Date 2018/4/13 0013 上午 11:29
 * @Description 数据库
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "BREAKINGNEWS";
    private static final int DB_VERSION = 1;
    private static DatabaseHelper instance = null;
    private static SQLiteDatabase db;

    public DatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public static synchronized DatabaseHelper getInstance() {
        if (instance == null) {
            return new DatabaseHelper(InitApp.appContext, DB_NAME, null, DB_VERSION);
        }
        return instance;
    }


    /**
     * 获取数据库
     *
     * @return
     */
    public static synchronized SQLiteDatabase getDatabase() {
        if (db == null) {
            db = getInstance().getWritableDatabase();
        }
        return db;
    }

    /**
     * 关闭数据库
     */
    public static synchronized void closeDatabase() {
        if (db != null) {
            db.close();
        }
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(NewsChannelTable.CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
