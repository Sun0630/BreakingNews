package com.sx.breakingnews;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.sx.breakingnews.module.base.BaseActivity;
import com.sx.breakingnews.module.media.MediaTabLayout;
import com.sx.breakingnews.module.news.NewsTabLayout;
import com.sx.breakingnews.module.photo.PhotoTabLayout;
import com.sx.breakingnews.module.video.VideoTabLayout;


/**
 * @author sunxin
 */
public class MainActivity extends BaseActivity implements NavigationView.OnNavigationItemSelectedListener {

    private static final int FRAGMENT_NEWS = 0;
    private static final int FRAGMENT_PHOTO = 1;
    private static final int FRAGMENT_VIDEO = 2;
    private static final int FRAGMENT_MEDIA = 3;
    private Toolbar toolbar;
    private BottomNavigationView bottomNavigationView;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private long exitTime = 0;
    private FragmentTransaction ft;
    private NewsTabLayout newsTabLayout;
    private PhotoTabLayout photoTabLayout;
    private VideoTabLayout videoTabLayout;
    private MediaTabLayout mediaTabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        //第一次进入显示新闻
        showFragment(FRAGMENT_NEWS);

    }

    private void initView() {
        toolbar = findViewById(R.id.toolbar);
        bottomNavigationView = findViewById(R.id.navitation_bottom);
        toolbar.inflateMenu(R.menu.menu_activity_main);
        toolbar.setTitle(R.string.title_news);
        setSupportActionBar(toolbar);
        drawerLayout = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        //同步状态
        toggle.syncState();

        navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        //设置navigationview
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    //新闻
                    case R.id.action_news:
                        showFragment(FRAGMENT_NEWS);
                        break;
                    //图片
                    case R.id.action_photo:
                        showFragment(FRAGMENT_PHOTO);
                        break;
                    //视频
                    case R.id.action_video:
                        showFragment(FRAGMENT_VIDEO);
                        break;
                    //头条号
                    case R.id.action_media:
                        showFragment(FRAGMENT_MEDIA);
                        break;
                }
                return true;
            }
        });

    }

    private void showFragment(int index) {
        ft = getSupportFragmentManager().beginTransaction();
        hideFragment(ft);
        switch (index) {
            case FRAGMENT_NEWS:
                toolbar.setTitle(R.string.title_news);
                /**
                 * 如果Fragment为空，就新建一个实例
                 * 如果不为空，就将它从栈中显示出来
                 */
                if (newsTabLayout == null) {
                    newsTabLayout = NewsTabLayout.getInstance();
                    ft.add(R.id.container, newsTabLayout, NewsTabLayout.class.getSimpleName());
                } else {
                    ft.show(newsTabLayout);
                }

                break;
            case FRAGMENT_PHOTO:
                toolbar.setTitle(R.string.title_photo);
                if (photoTabLayout == null) {
                    photoTabLayout = PhotoTabLayout.getInstance();
                    ft.add(R.id.container,photoTabLayout, PhotoTabLayout.class.getSimpleName());
                }else {
                    ft.show(photoTabLayout);
                }
                break;
            case FRAGMENT_VIDEO:
                toolbar.setTitle(R.string.title_video);
                if (videoTabLayout == null) {
                    videoTabLayout = VideoTabLayout.getInstance();
                    ft.add(R.id.container,videoTabLayout,VideoTabLayout.class.getSimpleName());
                }else {
                    ft.show(videoTabLayout);
                }
                break;
            case FRAGMENT_MEDIA:
                toolbar.setTitle(R.string.title_media);
                if (mediaTabLayout == null) {
                    mediaTabLayout = MediaTabLayout.getInstance();
                    ft.add(R.id.container,mediaTabLayout,MediaTabLayout.class.getSimpleName());
                }else {
                    ft.show(mediaTabLayout);
                }
                break;
            default:
                break;

        }

        ft.commit();
    }

    /**
     * 如果不为空就先隐藏
     * @param ft
     */
    private void hideFragment(FragmentTransaction ft) {
        if (newsTabLayout != null){
            ft.hide(newsTabLayout);
        }
        if (photoTabLayout != null) {
            ft.hide(photoTabLayout);
        }
        if (videoTabLayout != null) {
            ft.hide(videoTabLayout);
        }
        if (mediaTabLayout != null) {
            ft.hide(mediaTabLayout);
        }
    }

    @Override
    public void onBackPressed() {
        long currentTime = System.currentTimeMillis();
        if ((currentTime - exitTime) < 2000) {
            super.onBackPressed();
        } else {
            Toast.makeText(this, "再按一次退出程序", Toast.LENGTH_SHORT).show();
            exitTime = currentTime;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_activity_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_search) {
            //跳转到搜索界面
            Toast.makeText(this, "搜索", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            //切换模式
            case R.id.nav_switch_night_mode:
                break;
            //设置
            case R.id.nav_setting:
                break;
            //分享
            case R.id.nav_share:
                break;
        }
        return true;
    }
}
