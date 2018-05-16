package com.sx.breakingnews.widget.helper;

import android.support.design.widget.AppBarLayout;

/**
 * @Author Administrator
 * @Date 2018/5/16 0016 下午 5:19
 * @Description
 */

public abstract class AppBarStateChangeListener implements AppBarLayout.OnOffsetChangedListener {

    /**
     * 默认状态
     */
    private STATE currentState = STATE.IDLE;

    protected enum STATE{
        EXPANDE,COLLAPSED,IDLE
    }


    @Override
    public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
        if (verticalOffset == 0){
            //展开
            if (currentState!=STATE.EXPANDE){
                onStateChange(appBarLayout,STATE.EXPANDE);
            }
            currentState = STATE.EXPANDE;
        }else if (Math.abs(verticalOffset)>=appBarLayout.getTotalScrollRange()){
            //折叠
            if (currentState!=STATE.COLLAPSED){
                onStateChange(appBarLayout,STATE.COLLAPSED);
            }
            currentState = STATE.COLLAPSED;
        }else {
            //闲置
            if (currentState!=STATE.IDLE){
                onStateChange(appBarLayout,STATE.IDLE);
            }
            currentState=STATE.IDLE;
        }
    }

    /**
     * 状态改变
     * @param layout
     * @param state
     */
    protected abstract void onStateChange(AppBarLayout layout, STATE state);
}
