package com.sx.breakingnews.bean.news;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * @Author Administrator
 * @Date 2018/5/10 0010 下午 4:37
 * @Description
 */

public class MultiNewsArticleDataBean implements Parcelable{

    /**
     * abstract :
     * action_list : [{"action":1,"desc":"","extra":{}},{"action":3,"desc":"","extra":{}},{"action":7,"desc":"","extra":{}},{"action":9,"desc":"","extra":{}}]
     * aggr_type : 1
     * allow_download : false
     * article_alt_url : http://m.toutiao.com/group/article/6553127623394853384/
     * article_sub_type : 1
     * article_type : 1
     * article_url : https://temai.snssdk.com/article/feed/index?id=7088292&subscribe=5501832587&source_type=24&content_type=2&create_user_id=2001&classify=16&adid=__AID__
     * ban_comment : 0
     * behot_time : 1525934108
     * bury_count : 0
     * cell_flag : 262155
     * cell_layout_style : 1
     * cell_type : 0
     * comment_count : 0
     * content_decoration :
     * cursor : 1525934108000
     * digg_count : 0
     * display_url : http://toutiao.com/group/6553127623394853384/
     * filter_words : [{"id":"8:0","is_selected":false,"name":"看过了"},{"id":"9:1","is_selected":false,"name":"内容太水"},{"id":"5:2162942372","is_selected":false,"name":"拉黑作者:潮男指南"},{"id":"2:558298604","is_selected":false,"name":"不想看:今日特卖"},{"id":"6:227718","is_selected":false,"name":"不想看:亚麻"},{"id":"7:10001","is_selected":false,"name":"不想看:全部特卖"}]
     * forward_info : {"forward_count":0}
     * gallary_image_count : 16
     * gallary_style : 1
     * group_flags : 131072
     * group_id : 6553127623394853384
     * has_image : true
     * has_m3u8_video : false
     * has_mp4_video : 0
     * has_video : false
     * hot : 0
     * ignore_web_transform : 0
     * image_list : [{"height":450,"uri":"list/temai/6559be1287b8f0126dda413d983a4e0e6fe2c08e","url":"http://p1.pstatp.com/list/300x196/temai/6559be1287b8f0126dda413d983a4e0e6fe2c08e.webp","url_list":[{"url":"http://p1.pstatp.com/list/300x196/temai/6559be1287b8f0126dda413d983a4e0e6fe2c08e.webp"},{"url":"http://pb3.pstatp.com/list/300x196/temai/6559be1287b8f0126dda413d983a4e0e6fe2c08e.webp"},{"url":"http://pb9.pstatp.com/list/300x196/temai/6559be1287b8f0126dda413d983a4e0e6fe2c08e.webp"}],"width":800},{"height":450,"uri":"list/temai/b2fdf51569f556d47250865f4cd34c0e5519e845","url":"http://p1.pstatp.com/list/300x196/temai/b2fdf51569f556d47250865f4cd34c0e5519e845.webp","url_list":[{"url":"http://p1.pstatp.com/list/300x196/temai/b2fdf51569f556d47250865f4cd34c0e5519e845.webp"},{"url":"http://pb3.pstatp.com/list/300x196/temai/b2fdf51569f556d47250865f4cd34c0e5519e845.webp"},{"url":"http://pb9.pstatp.com/list/300x196/temai/b2fdf51569f556d47250865f4cd34c0e5519e845.webp"}],"width":800},{"height":843,"uri":"list/temai/8720202366ad1b7c61e1afdd5a1de3aeb0447f4c","url":"http://p1.pstatp.com/list/300x196/temai/8720202366ad1b7c61e1afdd5a1de3aeb0447f4c.webp","url_list":[{"url":"http://p1.pstatp.com/list/300x196/temai/8720202366ad1b7c61e1afdd5a1de3aeb0447f4c.webp"},{"url":"http://pb3.pstatp.com/list/300x196/temai/8720202366ad1b7c61e1afdd5a1de3aeb0447f4c.webp"},{"url":"http://pb9.pstatp.com/list/300x196/temai/8720202366ad1b7c61e1afdd5a1de3aeb0447f4c.webp"}],"width":1500}]
     * is_subject : false
     * item_id : 6553127623394853384
     * item_version : 0
     * keywords : 运动裤,中国风男装亚麻,休闲裤,衬衫,舒适
     * level : 0
     * log_pb : {"impr_id":"20180510143608010020038093137B74"}
     * media_info : {"avatar_url":"http://p2.pstatp.com/large/8602/5710290530","follow":false,"is_star_user":false,"media_id":5501832587,"name":"潮男指南","recommend_reason":"","recommend_type":0,"user_id":5501832587,"user_verified":false,"verified_content":""}
     * media_name : 潮男指南
     * middle_image : {"height":450,"uri":"list/temai/6559be1287b8f0126dda413d983a4e0e6fe2c08e","url":"http://p1.pstatp.com/list/300x196/temai/6559be1287b8f0126dda413d983a4e0e6fe2c08e.webp","url_list":[{"url":"http://p1.pstatp.com/list/300x196/temai/6559be1287b8f0126dda413d983a4e0e6fe2c08e.webp"},{"url":"http://pb3.pstatp.com/list/300x196/temai/6559be1287b8f0126dda413d983a4e0e6fe2c08e.webp"},{"url":"http://pb9.pstatp.com/list/300x196/temai/6559be1287b8f0126dda413d983a4e0e6fe2c08e.webp"}],"width":800}
     * need_client_impr_recycle : 1
     * publish_time : 1525768922
     * read_count : 9
     * rid : 20180510143608010020038093137B74
     * share_count : 0
     * share_info : {"cover_image":null,"description":null,"share_type":{"pyq":2,"qq":0,"qzone":0,"wx":0},"share_url":"http://m.toutiao.com/group/6553127623394853384/?iid=5034850950&app=news_article","title":"偷偷跟您讲，比运动裤还舒适的亚麻裤\u201c顺势而出\u201d，70男贼中意"}
     * share_type : 2
     * share_url : http://m.toutiao.com/group/6553127623394853384/?iid=5034850950&app=news_article
     * show_dislike : true
     * show_portrait : false
     * show_portrait_article : false
     * source : 潮男指南
     * source_icon_style : 6
     * source_open_url : sslocal://profile?uid=5501832587
     * tag : news_fashion
     * tag_id : 6553127623394853384
     * tip : 0
     * title : 偷偷跟您讲，比运动裤还舒适的亚麻裤“顺势而出”，70男贼中意
     * ugc_recommend : {"activity":"","reason":""}
     * url : https://temai.snssdk.com/article/feed/index?id=7088292&subscribe=5501832587&source_type=24&content_type=2&create_user_id=2001&classify=16&adid=__AID__
     * user_info : {"avatar_url":"http://p3.pstatp.com/thumb/8602/5710290530","description":"每日优质商品推荐，每日新鲜资讯分享。","follow":false,"follower_count":0,"name":"潮男指南","user_id":5501832587,"user_verified":false}
     * user_repin : 0
     * user_verified : 0
     * verified_content :
     * video_style : 0
     */

    @SerializedName("abstract")
    private String abstractX;
    private int aggr_type;
    private boolean allow_download;
    private String article_alt_url;
    private int article_sub_type;
    private int article_type;
    private String article_url;
    private int ban_comment;
    private int behot_time;
    private int bury_count;
    private int cell_flag;
    private int cell_layout_style;
    private int cell_type;
    private int comment_count;
    private String content_decoration;
    private long cursor;
    private int digg_count;
    private String display_url;
    private ForwardInfoBean forward_info;
    private int gallary_image_count;
    private int gallary_style;
    private int group_flags;
    private long group_id;
    private boolean has_image;
    private boolean has_m3u8_video;
    private int has_mp4_video;
    private boolean has_video;
    private int hot;
    private int ignore_web_transform;
    private boolean is_subject;
    private long item_id;
    private int item_version;
    private String keywords;
    private int level;
    private LogPbBean log_pb;
    private MediaInfoBean media_info;
    private String media_name;
    private MiddleImageBean middle_image;
    private int need_client_impr_recycle;
    private int publish_time;
    private int read_count;
    private String rid;
    private int share_count;
    private ShareInfoBean share_info;
    private int share_type;
    private String share_url;
    private boolean show_dislike;
    private boolean show_portrait;
    private boolean show_portrait_article;
    private String source;
    private int source_icon_style;
    private String source_open_url;
    private String tag;
    private long tag_id;
    private int tip;
    private String title;
    private UgcRecommendBean ugc_recommend;
    private String url;
    private UserInfoBean user_info;
    private int user_repin;
    private int user_verified;
    private String verified_content;
    private int video_style;
    private List<ActionListBean> action_list;
    private List<FilterWordsBean> filter_words;
    private List<ImageListBean> image_list;

    protected MultiNewsArticleDataBean(Parcel in) {
        abstractX = in.readString();
        aggr_type = in.readInt();
        allow_download = in.readByte() != 0;
        article_alt_url = in.readString();
        article_sub_type = in.readInt();
        article_type = in.readInt();
        article_url = in.readString();
        ban_comment = in.readInt();
        behot_time = in.readInt();
        bury_count = in.readInt();
        cell_flag = in.readInt();
        cell_layout_style = in.readInt();
        cell_type = in.readInt();
        comment_count = in.readInt();
        content_decoration = in.readString();
        cursor = in.readLong();
        digg_count = in.readInt();
        display_url = in.readString();
        gallary_image_count = in.readInt();
        gallary_style = in.readInt();
        group_flags = in.readInt();
        group_id = in.readLong();
        has_image = in.readByte() != 0;
        has_m3u8_video = in.readByte() != 0;
        has_mp4_video = in.readInt();
        has_video = in.readByte() != 0;
        hot = in.readInt();
        ignore_web_transform = in.readInt();
        is_subject = in.readByte() != 0;
        item_id = in.readLong();
        item_version = in.readInt();
        keywords = in.readString();
        level = in.readInt();
        media_name = in.readString();
        need_client_impr_recycle = in.readInt();
        publish_time = in.readInt();
        read_count = in.readInt();
        rid = in.readString();
        share_count = in.readInt();
        share_type = in.readInt();
        share_url = in.readString();
        show_dislike = in.readByte() != 0;
        show_portrait = in.readByte() != 0;
        show_portrait_article = in.readByte() != 0;
        source = in.readString();
        source_icon_style = in.readInt();
        source_open_url = in.readString();
        tag = in.readString();
        tag_id = in.readLong();
        tip = in.readInt();
        title = in.readString();
        url = in.readString();
        user_repin = in.readInt();
        user_verified = in.readInt();
        verified_content = in.readString();
        video_style = in.readInt();
    }

    public static final Creator<MultiNewsArticleDataBean> CREATOR = new Creator<MultiNewsArticleDataBean>() {
        @Override
        public MultiNewsArticleDataBean createFromParcel(Parcel in) {
            return new MultiNewsArticleDataBean(in);
        }

        @Override
        public MultiNewsArticleDataBean[] newArray(int size) {
            return new MultiNewsArticleDataBean[size];
        }
    };

    public String getAbstractX() {
        return abstractX;
    }

    public void setAbstractX(String abstractX) {
        this.abstractX = abstractX;
    }

    public int getAggr_type() {
        return aggr_type;
    }

    public void setAggr_type(int aggr_type) {
        this.aggr_type = aggr_type;
    }

    public boolean isAllow_download() {
        return allow_download;
    }

    public void setAllow_download(boolean allow_download) {
        this.allow_download = allow_download;
    }

    public String getArticle_alt_url() {
        return article_alt_url;
    }

    public void setArticle_alt_url(String article_alt_url) {
        this.article_alt_url = article_alt_url;
    }

    public int getArticle_sub_type() {
        return article_sub_type;
    }

    public void setArticle_sub_type(int article_sub_type) {
        this.article_sub_type = article_sub_type;
    }

    public int getArticle_type() {
        return article_type;
    }

    public void setArticle_type(int article_type) {
        this.article_type = article_type;
    }

    public String getArticle_url() {
        return article_url;
    }

    public void setArticle_url(String article_url) {
        this.article_url = article_url;
    }

    public int getBan_comment() {
        return ban_comment;
    }

    public void setBan_comment(int ban_comment) {
        this.ban_comment = ban_comment;
    }

    public int getBehot_time() {
        return behot_time;
    }

    public void setBehot_time(int behot_time) {
        this.behot_time = behot_time;
    }

    public int getBury_count() {
        return bury_count;
    }

    public void setBury_count(int bury_count) {
        this.bury_count = bury_count;
    }

    public int getCell_flag() {
        return cell_flag;
    }

    public void setCell_flag(int cell_flag) {
        this.cell_flag = cell_flag;
    }

    public int getCell_layout_style() {
        return cell_layout_style;
    }

    public void setCell_layout_style(int cell_layout_style) {
        this.cell_layout_style = cell_layout_style;
    }

    public int getCell_type() {
        return cell_type;
    }

    public void setCell_type(int cell_type) {
        this.cell_type = cell_type;
    }

    public int getComment_count() {
        return comment_count;
    }

    public void setComment_count(int comment_count) {
        this.comment_count = comment_count;
    }

    public String getContent_decoration() {
        return content_decoration;
    }

    public void setContent_decoration(String content_decoration) {
        this.content_decoration = content_decoration;
    }

    public long getCursor() {
        return cursor;
    }

    public void setCursor(long cursor) {
        this.cursor = cursor;
    }

    public int getDigg_count() {
        return digg_count;
    }

    public void setDigg_count(int digg_count) {
        this.digg_count = digg_count;
    }

    public String getDisplay_url() {
        return display_url;
    }

    public void setDisplay_url(String display_url) {
        this.display_url = display_url;
    }

    public ForwardInfoBean getForward_info() {
        return forward_info;
    }

    public void setForward_info(ForwardInfoBean forward_info) {
        this.forward_info = forward_info;
    }

    public int getGallary_image_count() {
        return gallary_image_count;
    }

    public void setGallary_image_count(int gallary_image_count) {
        this.gallary_image_count = gallary_image_count;
    }

    public int getGallary_style() {
        return gallary_style;
    }

    public void setGallary_style(int gallary_style) {
        this.gallary_style = gallary_style;
    }

    public int getGroup_flags() {
        return group_flags;
    }

    public void setGroup_flags(int group_flags) {
        this.group_flags = group_flags;
    }

    public long getGroup_id() {
        return group_id;
    }

    public void setGroup_id(long group_id) {
        this.group_id = group_id;
    }

    public boolean isHas_image() {
        return has_image;
    }

    public void setHas_image(boolean has_image) {
        this.has_image = has_image;
    }

    public boolean isHas_m3u8_video() {
        return has_m3u8_video;
    }

    public void setHas_m3u8_video(boolean has_m3u8_video) {
        this.has_m3u8_video = has_m3u8_video;
    }

    public int getHas_mp4_video() {
        return has_mp4_video;
    }

    public void setHas_mp4_video(int has_mp4_video) {
        this.has_mp4_video = has_mp4_video;
    }

    public boolean isHas_video() {
        return has_video;
    }

    public void setHas_video(boolean has_video) {
        this.has_video = has_video;
    }

    public int getHot() {
        return hot;
    }

    public void setHot(int hot) {
        this.hot = hot;
    }

    public int getIgnore_web_transform() {
        return ignore_web_transform;
    }

    public void setIgnore_web_transform(int ignore_web_transform) {
        this.ignore_web_transform = ignore_web_transform;
    }

    public boolean isIs_subject() {
        return is_subject;
    }

    public void setIs_subject(boolean is_subject) {
        this.is_subject = is_subject;
    }

    public long getItem_id() {
        return item_id;
    }

    public void setItem_id(long item_id) {
        this.item_id = item_id;
    }

    public int getItem_version() {
        return item_version;
    }

    public void setItem_version(int item_version) {
        this.item_version = item_version;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public LogPbBean getLog_pb() {
        return log_pb;
    }

    public void setLog_pb(LogPbBean log_pb) {
        this.log_pb = log_pb;
    }

    public MediaInfoBean getMedia_info() {
        return media_info;
    }

    public void setMedia_info(MediaInfoBean media_info) {
        this.media_info = media_info;
    }

    public String getMedia_name() {
        return media_name;
    }

    public void setMedia_name(String media_name) {
        this.media_name = media_name;
    }

    public MiddleImageBean getMiddle_image() {
        return middle_image;
    }

    public void setMiddle_image(MiddleImageBean middle_image) {
        this.middle_image = middle_image;
    }

    public int getNeed_client_impr_recycle() {
        return need_client_impr_recycle;
    }

    public void setNeed_client_impr_recycle(int need_client_impr_recycle) {
        this.need_client_impr_recycle = need_client_impr_recycle;
    }

    public int getPublish_time() {
        return publish_time;
    }

    public void setPublish_time(int publish_time) {
        this.publish_time = publish_time;
    }

    public int getRead_count() {
        return read_count;
    }

    public void setRead_count(int read_count) {
        this.read_count = read_count;
    }

    public String getRid() {
        return rid;
    }

    public void setRid(String rid) {
        this.rid = rid;
    }

    public int getShare_count() {
        return share_count;
    }

    public void setShare_count(int share_count) {
        this.share_count = share_count;
    }

    public ShareInfoBean getShare_info() {
        return share_info;
    }

    public void setShare_info(ShareInfoBean share_info) {
        this.share_info = share_info;
    }

    public int getShare_type() {
        return share_type;
    }

    public void setShare_type(int share_type) {
        this.share_type = share_type;
    }

    public String getShare_url() {
        return share_url;
    }

    public void setShare_url(String share_url) {
        this.share_url = share_url;
    }

    public boolean isShow_dislike() {
        return show_dislike;
    }

    public void setShow_dislike(boolean show_dislike) {
        this.show_dislike = show_dislike;
    }

    public boolean isShow_portrait() {
        return show_portrait;
    }

    public void setShow_portrait(boolean show_portrait) {
        this.show_portrait = show_portrait;
    }

    public boolean isShow_portrait_article() {
        return show_portrait_article;
    }

    public void setShow_portrait_article(boolean show_portrait_article) {
        this.show_portrait_article = show_portrait_article;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public int getSource_icon_style() {
        return source_icon_style;
    }

    public void setSource_icon_style(int source_icon_style) {
        this.source_icon_style = source_icon_style;
    }

    public String getSource_open_url() {
        return source_open_url;
    }

    public void setSource_open_url(String source_open_url) {
        this.source_open_url = source_open_url;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public long getTag_id() {
        return tag_id;
    }

    public void setTag_id(long tag_id) {
        this.tag_id = tag_id;
    }

    public int getTip() {
        return tip;
    }

    public void setTip(int tip) {
        this.tip = tip;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public UgcRecommendBean getUgc_recommend() {
        return ugc_recommend;
    }

    public void setUgc_recommend(UgcRecommendBean ugc_recommend) {
        this.ugc_recommend = ugc_recommend;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public UserInfoBean getUser_info() {
        return user_info;
    }

    public void setUser_info(UserInfoBean user_info) {
        this.user_info = user_info;
    }

    public int getUser_repin() {
        return user_repin;
    }

    public void setUser_repin(int user_repin) {
        this.user_repin = user_repin;
    }

    public int getUser_verified() {
        return user_verified;
    }

    public void setUser_verified(int user_verified) {
        this.user_verified = user_verified;
    }

    public String getVerified_content() {
        return verified_content;
    }

    public void setVerified_content(String verified_content) {
        this.verified_content = verified_content;
    }

    public int getVideo_style() {
        return video_style;
    }

    public void setVideo_style(int video_style) {
        this.video_style = video_style;
    }

    public List<ActionListBean> getAction_list() {
        return action_list;
    }

    public void setAction_list(List<ActionListBean> action_list) {
        this.action_list = action_list;
    }

    public List<FilterWordsBean> getFilter_words() {
        return filter_words;
    }

    public void setFilter_words(List<FilterWordsBean> filter_words) {
        this.filter_words = filter_words;
    }

    public List<ImageListBean> getImage_list() {
        return image_list;
    }

    public void setImage_list(List<ImageListBean> image_list) {
        this.image_list = image_list;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(abstractX);
        dest.writeInt(aggr_type);
        dest.writeByte((byte) (allow_download ? 1 : 0));
        dest.writeString(article_alt_url);
        dest.writeInt(article_sub_type);
        dest.writeInt(article_type);
        dest.writeString(article_url);
        dest.writeInt(ban_comment);
        dest.writeInt(behot_time);
        dest.writeInt(bury_count);
        dest.writeInt(cell_flag);
        dest.writeInt(cell_layout_style);
        dest.writeInt(cell_type);
        dest.writeInt(comment_count);
        dest.writeString(content_decoration);
        dest.writeLong(cursor);
        dest.writeInt(digg_count);
        dest.writeString(display_url);
        dest.writeInt(gallary_image_count);
        dest.writeInt(gallary_style);
        dest.writeInt(group_flags);
        dest.writeLong(group_id);
        dest.writeByte((byte) (has_image ? 1 : 0));
        dest.writeByte((byte) (has_m3u8_video ? 1 : 0));
        dest.writeInt(has_mp4_video);
        dest.writeByte((byte) (has_video ? 1 : 0));
        dest.writeInt(hot);
        dest.writeInt(ignore_web_transform);
        dest.writeByte((byte) (is_subject ? 1 : 0));
        dest.writeLong(item_id);
        dest.writeInt(item_version);
        dest.writeString(keywords);
        dest.writeInt(level);
        dest.writeString(media_name);
        dest.writeInt(need_client_impr_recycle);
        dest.writeInt(publish_time);
        dest.writeInt(read_count);
        dest.writeString(rid);
        dest.writeInt(share_count);
        dest.writeInt(share_type);
        dest.writeString(share_url);
        dest.writeByte((byte) (show_dislike ? 1 : 0));
        dest.writeByte((byte) (show_portrait ? 1 : 0));
        dest.writeByte((byte) (show_portrait_article ? 1 : 0));
        dest.writeString(source);
        dest.writeInt(source_icon_style);
        dest.writeString(source_open_url);
        dest.writeString(tag);
        dest.writeLong(tag_id);
        dest.writeInt(tip);
        dest.writeString(title);
        dest.writeString(url);
        dest.writeInt(user_repin);
        dest.writeInt(user_verified);
        dest.writeString(verified_content);
        dest.writeInt(video_style);
    }


    public static class ForwardInfoBean {
        /**
         * forward_count : 0
         */

        private int forward_count;

        public int getForward_count() {
            return forward_count;
        }

        public void setForward_count(int forward_count) {
            this.forward_count = forward_count;
        }
    }

    public static class LogPbBean {
        /**
         * impr_id : 20180510143608010020038093137B74
         */

        private String impr_id;

        public String getImpr_id() {
            return impr_id;
        }

        public void setImpr_id(String impr_id) {
            this.impr_id = impr_id;
        }
    }

    public static class MediaInfoBean {
        /**
         * avatar_url : http://p2.pstatp.com/large/8602/5710290530
         * follow : false
         * is_star_user : false
         * media_id : 5501832587
         * name : 潮男指南
         * recommend_reason :
         * recommend_type : 0
         * user_id : 5501832587
         * user_verified : false
         * verified_content :
         */

        private String avatar_url;
        private boolean follow;
        private boolean is_star_user;
        private long media_id;
        private String name;
        private String recommend_reason;
        private int recommend_type;
        private long user_id;
        private boolean user_verified;
        private String verified_content;

        public String getAvatar_url() {
            return avatar_url;
        }

        public void setAvatar_url(String avatar_url) {
            this.avatar_url = avatar_url;
        }

        public boolean isFollow() {
            return follow;
        }

        public void setFollow(boolean follow) {
            this.follow = follow;
        }

        public boolean isIs_star_user() {
            return is_star_user;
        }

        public void setIs_star_user(boolean is_star_user) {
            this.is_star_user = is_star_user;
        }

        public long getMedia_id() {
            return media_id;
        }

        public void setMedia_id(long media_id) {
            this.media_id = media_id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getRecommend_reason() {
            return recommend_reason;
        }

        public void setRecommend_reason(String recommend_reason) {
            this.recommend_reason = recommend_reason;
        }

        public int getRecommend_type() {
            return recommend_type;
        }

        public void setRecommend_type(int recommend_type) {
            this.recommend_type = recommend_type;
        }

        public long getUser_id() {
            return user_id;
        }

        public void setUser_id(long user_id) {
            this.user_id = user_id;
        }

        public boolean isUser_verified() {
            return user_verified;
        }

        public void setUser_verified(boolean user_verified) {
            this.user_verified = user_verified;
        }

        public String getVerified_content() {
            return verified_content;
        }

        public void setVerified_content(String verified_content) {
            this.verified_content = verified_content;
        }
    }

    public static class MiddleImageBean {
        /**
         * height : 450
         * uri : list/temai/6559be1287b8f0126dda413d983a4e0e6fe2c08e
         * url : http://p1.pstatp.com/list/300x196/temai/6559be1287b8f0126dda413d983a4e0e6fe2c08e.webp
         * url_list : [{"url":"http://p1.pstatp.com/list/300x196/temai/6559be1287b8f0126dda413d983a4e0e6fe2c08e.webp"},{"url":"http://pb3.pstatp.com/list/300x196/temai/6559be1287b8f0126dda413d983a4e0e6fe2c08e.webp"},{"url":"http://pb9.pstatp.com/list/300x196/temai/6559be1287b8f0126dda413d983a4e0e6fe2c08e.webp"}]
         * width : 800
         */

        private int height;
        private String uri;
        private String url;
        private int width;
        private List<UrlListBean> url_list;

        public int getHeight() {
            return height;
        }

        public void setHeight(int height) {
            this.height = height;
        }

        public String getUri() {
            return uri;
        }

        public void setUri(String uri) {
            this.uri = uri;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public int getWidth() {
            return width;
        }

        public void setWidth(int width) {
            this.width = width;
        }

        public List<UrlListBean> getUrl_list() {
            return url_list;
        }

        public void setUrl_list(List<UrlListBean> url_list) {
            this.url_list = url_list;
        }

        public static class UrlListBean {
            /**
             * url : http://p1.pstatp.com/list/300x196/temai/6559be1287b8f0126dda413d983a4e0e6fe2c08e.webp
             */

            private String url;

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }
        }
    }

    public static class ShareInfoBean {
        /**
         * cover_image : null
         * description : null
         * share_type : {"pyq":2,"qq":0,"qzone":0,"wx":0}
         * share_url : http://m.toutiao.com/group/6553127623394853384/?iid=5034850950&app=news_article
         * title : 偷偷跟您讲，比运动裤还舒适的亚麻裤“顺势而出”，70男贼中意
         */

        private Object cover_image;
        private Object description;
        private ShareTypeBean share_type;
        private String share_url;
        private String title;

        public Object getCover_image() {
            return cover_image;
        }

        public void setCover_image(Object cover_image) {
            this.cover_image = cover_image;
        }

        public Object getDescription() {
            return description;
        }

        public void setDescription(Object description) {
            this.description = description;
        }

        public ShareTypeBean getShare_type() {
            return share_type;
        }

        public void setShare_type(ShareTypeBean share_type) {
            this.share_type = share_type;
        }

        public String getShare_url() {
            return share_url;
        }

        public void setShare_url(String share_url) {
            this.share_url = share_url;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public static class ShareTypeBean {
            /**
             * pyq : 2
             * qq : 0
             * qzone : 0
             * wx : 0
             */

            private int pyq;
            private int qq;
            private int qzone;
            private int wx;

            public int getPyq() {
                return pyq;
            }

            public void setPyq(int pyq) {
                this.pyq = pyq;
            }

            public int getQq() {
                return qq;
            }

            public void setQq(int qq) {
                this.qq = qq;
            }

            public int getQzone() {
                return qzone;
            }

            public void setQzone(int qzone) {
                this.qzone = qzone;
            }

            public int getWx() {
                return wx;
            }

            public void setWx(int wx) {
                this.wx = wx;
            }
        }
    }

    public static class UgcRecommendBean {
        /**
         * activity :
         * reason :
         */

        private String activity;
        private String reason;

        public String getActivity() {
            return activity;
        }

        public void setActivity(String activity) {
            this.activity = activity;
        }

        public String getReason() {
            return reason;
        }

        public void setReason(String reason) {
            this.reason = reason;
        }
    }

    public static class UserInfoBean {
        /**
         * avatar_url : http://p3.pstatp.com/thumb/8602/5710290530
         * description : 每日优质商品推荐，每日新鲜资讯分享。
         * follow : false
         * follower_count : 0
         * name : 潮男指南
         * user_id : 5501832587
         * user_verified : false
         */

        private String avatar_url;
        private String description;
        private boolean follow;
        private int follower_count;
        private String name;
        private long user_id;
        private boolean user_verified;

        public String getAvatar_url() {
            return avatar_url;
        }

        public void setAvatar_url(String avatar_url) {
            this.avatar_url = avatar_url;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public boolean isFollow() {
            return follow;
        }

        public void setFollow(boolean follow) {
            this.follow = follow;
        }

        public int getFollower_count() {
            return follower_count;
        }

        public void setFollower_count(int follower_count) {
            this.follower_count = follower_count;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public long getUser_id() {
            return user_id;
        }

        public void setUser_id(long user_id) {
            this.user_id = user_id;
        }

        public boolean isUser_verified() {
            return user_verified;
        }

        public void setUser_verified(boolean user_verified) {
            this.user_verified = user_verified;
        }
    }

    public static class ActionListBean {
        /**
         * action : 1
         * desc :
         * extra : {}
         */

        private int action;
        private String desc;
        private ExtraBean extra;

        public int getAction() {
            return action;
        }

        public void setAction(int action) {
            this.action = action;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public ExtraBean getExtra() {
            return extra;
        }

        public void setExtra(ExtraBean extra) {
            this.extra = extra;
        }

        public static class ExtraBean {
        }
    }

    public static class FilterWordsBean {
        /**
         * id : 8:0
         * is_selected : false
         * name : 看过了
         */

        private String id;
        private boolean is_selected;
        private String name;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public boolean isIs_selected() {
            return is_selected;
        }

        public void setIs_selected(boolean is_selected) {
            this.is_selected = is_selected;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public static class ImageListBean {
        /**
         * height : 450
         * uri : list/temai/6559be1287b8f0126dda413d983a4e0e6fe2c08e
         * url : http://p1.pstatp.com/list/300x196/temai/6559be1287b8f0126dda413d983a4e0e6fe2c08e.webp
         * url_list : [{"url":"http://p1.pstatp.com/list/300x196/temai/6559be1287b8f0126dda413d983a4e0e6fe2c08e.webp"},{"url":"http://pb3.pstatp.com/list/300x196/temai/6559be1287b8f0126dda413d983a4e0e6fe2c08e.webp"},{"url":"http://pb9.pstatp.com/list/300x196/temai/6559be1287b8f0126dda413d983a4e0e6fe2c08e.webp"}]
         * width : 800
         */

        private int height;
        private String uri;
        private String url;
        private int width;
        private List<UrlListBeanX> url_list;

        public int getHeight() {
            return height;
        }

        public void setHeight(int height) {
            this.height = height;
        }

        public String getUri() {
            return uri;
        }

        public void setUri(String uri) {
            this.uri = uri;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public int getWidth() {
            return width;
        }

        public void setWidth(int width) {
            this.width = width;
        }

        public List<UrlListBeanX> getUrl_list() {
            return url_list;
        }

        public void setUrl_list(List<UrlListBeanX> url_list) {
            this.url_list = url_list;
        }

        public static class UrlListBeanX {
            /**
             * url : http://p1.pstatp.com/list/300x196/temai/6559be1287b8f0126dda413d983a4e0e6fe2c08e.webp
             */

            private String url;

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }
        }
    }
}
