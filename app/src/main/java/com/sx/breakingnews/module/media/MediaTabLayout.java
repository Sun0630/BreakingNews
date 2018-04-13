package com.sx.breakingnews.module.media;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * @author Sunxin
 * @Date 2017/11/16 0016 上午 9:40
 * @Description
 */

public class MediaTabLayout extends Fragment {

    public static MediaTabLayout instance;

    public static MediaTabLayout getInstance() {
        if (instance == null) {
            instance = new MediaTabLayout();
        }
        return instance;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        TextView textView = new TextView(getActivity());
        textView.setText("Media");
        return textView;
    }
}
