package com.sx.breakingnews.viewbinder.news;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.jakewharton.rxbinding2.view.RxView;
import com.sx.breakingnews.ErrorAction;
import com.sx.breakingnews.IntentAction;
import com.sx.breakingnews.R;
import com.sx.breakingnews.bean.news.MultiNewsArticleDataBean;
import com.sx.breakingnews.utils.ImageLoader;
import com.sx.breakingnews.utils.TimeUtil;
import com.sx.breakingnews.widget.CircleImageView;

import java.util.concurrent.TimeUnit;

import me.drakeet.multitype.ItemViewBinder;

/**
 * @Author Administrator
 * @Date 2018/5/11 0011 上午 11:23
 * @Description 多类型条目 -- 文字
 */
public class NewsArticleTextViewBinder extends ItemViewBinder<MultiNewsArticleDataBean, NewsArticleTextViewBinder.ViewHolder> {

    @NonNull
    @Override
    protected ViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        View root = inflater.inflate(R.layout.item_news_article_text, parent, false);
        return new ViewHolder(root);
    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder holder, @NonNull MultiNewsArticleDataBean item) {
        Context context = holder.itemView.getContext();

        try {
            if (null != item.getUser_info()) {
                String avatarUrl = item.getUser_info().getAvatar_url();
                if (!TextUtils.isEmpty(avatarUrl)) {
                    ImageLoader.loadCenterCrop(context, avatarUrl, holder.iv_media, R.color.White);
                }
            }

            String title = item.getTitle();
            String abstractX = item.getAbstractX();
            String source = item.getSource();
            String commentCount = item.getComment_count() + "评论";
            String dateTime = item.getBehot_time() + "";

            if (!TextUtils.isEmpty(dateTime)) {
                //返回发布的时间间隔
                dateTime = TimeUtil.getTimeStampAgo(dateTime);
            }


            holder.tv_title.setText(title);
            holder.tv_abstract.setText(abstractX);
            holder.tv_extra.setText(source + "-" + commentCount + "-" + dateTime);
            holder.iv_dots.setOnClickListener(view -> {
                //弹框
                PopupMenu popupMenu = new PopupMenu(context, holder.iv_dots, Gravity.END, 0, R.style.MyPopupMenu);
                popupMenu.setOnMenuItemClickListener(menuItem -> {
                    int itemId = menuItem.getItemId();
                    if (itemId == R.id.action_share) {
                        IntentAction.send(context, item.getTitle() + "\n" + item.getShare_url());
                    }
                    return false;
                });

                popupMenu.show();
            });

            RxView
                    .clicks(holder.itemView)
                    .throttleFirst(1, TimeUnit.SECONDS)
                    .subscribe(o -> {
                        Toast.makeText(context, "点击进入文章详情", Toast.LENGTH_SHORT).show();
                    });

        } catch (Exception e) {
            ErrorAction.print(e);
        }


    }


    static class ViewHolder extends RecyclerView.ViewHolder {

        private CircleImageView iv_media;
        private TextView tv_extra;
        private TextView tv_title;
        private TextView tv_abstract;
        private ImageView iv_dots;

        ViewHolder(View itemView) {
            super(itemView);
            this.iv_media = itemView.findViewById(R.id.iv_media);
            this.tv_extra = itemView.findViewById(R.id.tv_extra);
            this.tv_title = itemView.findViewById(R.id.tv_title);
            this.tv_abstract = itemView.findViewById(R.id.tv_abstract);
            this.iv_dots = itemView.findViewById(R.id.iv_dots);
        }
    }
}
