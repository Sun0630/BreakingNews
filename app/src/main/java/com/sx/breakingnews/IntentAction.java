package com.sx.breakingnews;

import android.content.Context;
import android.content.Intent;

/**
 * @Author Administrator
 * @Date 2018/5/11 0011 下午 2:17
 * @Description
 */

public class IntentAction {


    public static void send(Context context,String shareText){
        Intent shareIntent = new Intent()
                .setAction(Intent.ACTION_SEND)
                .setType("text/plain")
                .putExtra(Intent.EXTRA_TEXT,shareText);

        context.startActivity(Intent.createChooser(shareIntent,"分享"));
    }
}
