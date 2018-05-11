package com.sx.breakingnews.viewbinder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sx.breakingnews.R;
import com.sx.breakingnews.bean.LoadingEnd;

import me.drakeet.multitype.ItemViewBinder;

/**
 * @Author Administrator
 * @Date 2018/5/11 0011 下午 3:04
 * @Description
 */
public class LoadingEndViewBinder extends ItemViewBinder<LoadingEnd, LoadingEndViewBinder.ViewHolder> {

    @NonNull
    @Override
    protected ViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        View root = inflater.inflate(R.layout.item_loading_end, parent, false);
        return new ViewHolder(root);
    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder holder, @NonNull LoadingEnd loadingEnd) {

    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        ViewHolder(View itemView) {
            super(itemView);
        }
    }
}
