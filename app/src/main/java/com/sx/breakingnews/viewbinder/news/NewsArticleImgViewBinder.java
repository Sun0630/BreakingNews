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

import com.jakewharton.rxbinding2.view.RxView;
import com.sx.breakingnews.ErrorAction;
import com.sx.breakingnews.IntentAction;
import com.sx.breakingnews.R;
import com.sx.breakingnews.bean.news.MultiNewsArticleDataBean;
import com.sx.breakingnews.module.news.content.NewsContentActivity;
import com.sx.breakingnews.utils.ImageLoader;
import com.sx.breakingnews.utils.SettingUtils;
import com.sx.breakingnews.utils.TimeUtil;
import com.sx.breakingnews.widget.CircleImageView;

import java.util.List;
import java.util.concurrent.TimeUnit;

import me.drakeet.multitype.ItemViewBinder;

/**
 * @Author Administrator
 * @Date 2018/5/11 0011 上午 11:23
 * @Description 多类型 -- 图片
 */
public class NewsArticleImgViewBinder extends ItemViewBinder<MultiNewsArticleDataBean, NewsArticleImgViewBinder.ViewHolder> {

    @NonNull
    @Override
    protected ViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        View root = inflater.inflate(R.layout.item_news_article_img, parent, false);
        return new ViewHolder(root);
    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder holder, @NonNull MultiNewsArticleDataBean item) {
        Context context = holder.itemView.getContext();

        try {
            String imgUrl = "http://p3.pstatp.com/";
            List<MultiNewsArticleDataBean.ImageListBean> image_list = item.getImage_list();
            if (image_list != null && image_list.size() > 0) {
                String url = image_list.get(0).getUrl();
                ImageLoader.loadCenterCrop(context,url,holder.iv_image,R.color.White);

                if (!TextUtils.isEmpty(image_list.get(0).getUri())){
                    imgUrl += image_list.get(0).getUri().replace("list","large");
                }
            }

            /**
             * 头像
             */
            if (null != item.getUser_info()) {
                String avatarUrl = item.getUser_info().getAvatar_url();
                if (!TextUtils.isEmpty(avatarUrl)) {
                    ImageLoader.loadCenterCrop(context, avatarUrl, holder.iv_media, R.color.White);
                }
            }

            String tv_title = item.getTitle();
            String tv_abstract = item.getAbstractX();
            String tv_source = item.getSource();
            String tv_comment_count = item.getComment_count() + "评论";
            String tv_datetime = item.getBehot_time() + "";
            if (!TextUtils.isEmpty(tv_datetime)) {
                tv_datetime = TimeUtil.getTimeStampAgo(tv_datetime);
            }

            holder.tv_title.setText(tv_title);
            holder.tv_title.setTextSize(SettingUtils.getInstance().getTextSize());
            holder.tv_abstract.setText(tv_abstract);
            holder.tv_extra.setText(tv_source + " - " + tv_comment_count + " - " + tv_datetime);
            holder.iv_dots.setOnClickListener(view -> {
                PopupMenu popupMenu = new PopupMenu(context,
                        holder.iv_dots, Gravity.END, 0, R.style.MyPopupMenu);
                popupMenu.inflate(R.menu.menu_share);
                popupMenu.setOnMenuItemClickListener(menu -> {
                    int itemId = menu.getItemId();
                    if (itemId == R.id.action_share) {
                        IntentAction.send(context, item.getTitle() + "\n" + item.getShare_url());
                    }
                    return false;
                });
                popupMenu.show();
            });

            final String finalImgUrl = imgUrl;
            RxView.clicks(holder.itemView)
                    .throttleFirst(1, TimeUnit.SECONDS)
                    .subscribe(o -> {
                        NewsContentActivity.launch(item,finalImgUrl);
                    });


        } catch (Exception e) {
            ErrorAction.print(e);
        }
    }


    static class ViewHolder extends RecyclerView.ViewHolder {

        private CircleImageView iv_media;
        private ImageView iv_image;
        private TextView tv_title;
        private TextView tv_abstract;
        private TextView tv_extra;
        private ImageView iv_dots;

        ViewHolder(View itemView) {
            super(itemView);
            this.iv_media = itemView.findViewById(R.id.iv_media);
            this.iv_image = itemView.findViewById(R.id.iv_image);
            this.tv_title = itemView.findViewById(R.id.tv_title);
            this.tv_abstract = itemView.findViewById(R.id.tv_abstract);
            this.tv_extra = itemView.findViewById(R.id.tv_extra);
            this.iv_dots = itemView.findViewById(R.id.iv_dots);
        }
    }
}
