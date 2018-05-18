package com.sx.breakingnews.adapter.news;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.sx.breakingnews.R;
import com.sx.breakingnews.bean.news.NewsChannelBean;

import java.util.List;

/**
 * @Author Administrator
 * @Date 2018/5/18 0018 上午 11:44
 * @Description 频道Adapter
 */

public class NewsChannelAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    /**
     * 我的频道 标题部分
     */
    public static final int TYPE_MY_CHANNEL_HEADER = 0;
    /**
     * 我的频道
     */
    public static final int TYPE_MY = 1;
    /**
     * 其他频道 标题部分
     */
    public static final int TYPE_OTHER_CHANNEL_HEADER = 2;
    /**
     * 其他频道
     */
    public static final int TYPE_OTHER = 3;


    private final Context mContext;
    private final ItemTouchHelper mHelper;
    /**
     * 我的频道列表
     */
    private final List<String> mMyItems;
    /**
     * 其他频道列表
     */
    private final List<NewsChannelBean> mOtherItems;
    private LayoutInflater mInflater;

    /**
     * 判断是否是编辑模式
     */
    private boolean isEditMode = false;

    public NewsChannelAdapter(Context context, ItemTouchHelper helper, List<String> myItems, List<NewsChannelBean> otherItems) {
        mInflater = LayoutInflater.from(context);
        mContext = context;
        mHelper = helper;
        mMyItems = myItems;
        mOtherItems = otherItems;
    }


    @Override
    public int getItemViewType(int position) {
        //标题
        if (position == 0) {
            return TYPE_MY_CHANNEL_HEADER;
            // 我的频道
        } else if (position > 0 && position < mMyItems.size() + 1) {
            return TYPE_MY;
            // 其他部分的标题
        } else if (position == mMyItems.size() + 1) {
            return TYPE_OTHER_CHANNEL_HEADER;
        } else {
            return TYPE_OTHER;
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        switch (viewType) {
            case TYPE_MY_CHANNEL_HEADER:
                view = LayoutInflater.from(mContext).inflate(R.layout.item_channel_my_header, parent, false);
                MyChannelViewHolder myChannelViewHolder = new MyChannelViewHolder(view);
                return myChannelViewHolder;
            case TYPE_MY:
                view = mInflater.inflate(R.layout.item_channel_my, parent, false);
                MyViewHolder myViewHolder = new MyViewHolder(view);

                return myViewHolder;
            case TYPE_OTHER_CHANNEL_HEADER:
                return null;
            case TYPE_OTHER:
                return null;
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof MyChannelViewHolder) {
           MyChannelViewHolder myChannelViewHolder =  ((MyChannelViewHolder) holder);
           myChannelViewHolder.setData();

        } else if (holder instanceof MyViewHolder) {
            MyViewHolder myViewHolder = (MyViewHolder) holder;
            myViewHolder.mTextView.setText(mMyItems.get(position - 1));
        }
    }


    @Override
    public int getItemCount() {
        //加上两个头部
//        return mMyItems.size() + mOtherItems.size() + 2;
        return 1 + mMyItems.size();
    }

    /**
     * 头部的ViewHolder
     */
    class MyChannelViewHolder extends RecyclerView.ViewHolder {

        private TextView tvBtnEdit;

        public MyChannelViewHolder(View itemView) {
            super(itemView);
            tvBtnEdit = itemView.findViewById(R.id.tv_btn_edit);
        }

        public void setData() {
            tvBtnEdit.setOnClickListener(view -> {
                if (!isEditMode) {
                    //是编辑模式
                    tvBtnEdit.setText("完成");
                } else {
                    //不是
                    tvBtnEdit.setText("编辑");
                }
            });
        }
    }


    /**
     * 我的频道的ViewHolder
     */
    class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView mTextView;
        private ImageView mImageView;

        public MyViewHolder(View itemView) {
            super(itemView);
            mTextView = itemView.findViewById(R.id.tv);
            mImageView = itemView.findViewById(R.id.img_edit);
        }
    }


}
