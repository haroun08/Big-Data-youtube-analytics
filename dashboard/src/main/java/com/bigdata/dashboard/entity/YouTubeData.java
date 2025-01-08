package com.bigdata.dashboard.entity;

import lombok.Data;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Data // Generates getters, setters, toString, equals, and hashCode
@Table("youtube_data")
public class YouTubeData {
    public String getVideoId() {
        return videoId;
    }

    public void setVideoId(String videoId) {
        this.videoId = videoId;
    }

    public double getIndex() {
        return index;
    }

    public void setIndex(double index) {
        this.index = index;
    }

    public double getTotalViewsPerChannelElapsedTime() {
        return totalViewsPerChannelElapsedTime;
    }

    public void setTotalViewsPerChannelElapsedTime(double totalViewsPerChannelElapsedTime) {
        this.totalViewsPerChannelElapsedTime = totalViewsPerChannelElapsedTime;
    }

    public int getVideoCategoryId() {
        return videoCategoryId;
    }

    public void setVideoCategoryId(int videoCategoryId) {
        this.videoCategoryId = videoCategoryId;
    }

    public double getLikesPerSubscriber() {
        return likesPerSubscriber;
    }

    public void setLikesPerSubscriber(double likesPerSubscriber) {
        this.likesPerSubscriber = likesPerSubscriber;
    }

    public long getSubscriberCount() {
        return subscriberCount;
    }

    public void setSubscriberCount(long subscriberCount) {
        this.subscriberCount = subscriberCount;
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public long getChannelViewCount() {
        return channelViewCount;
    }

    public void setChannelViewCount(long channelViewCount) {
        this.channelViewCount = channelViewCount;
    }

    public double getViewsPerSubscribers() {
        return viewsPerSubscribers;
    }

    public void setViewsPerSubscribers(double viewsPerSubscribers) {
        this.viewsPerSubscribers = viewsPerSubscribers;
    }

    public int getVideoCount() {
        return videoCount;
    }

    public void setVideoCount(int videoCount) {
        this.videoCount = videoCount;
    }

    public double getDislikesPerViews() {
        return dislikesPerViews;
    }

    public void setDislikesPerViews(double dislikesPerViews) {
        this.dislikesPerViews = dislikesPerViews;
    }

    public double getCommentsPerSubscriber() {
        return commentsPerSubscriber;
    }

    public void setCommentsPerSubscriber(double commentsPerSubscriber) {
        this.commentsPerSubscriber = commentsPerSubscriber;
    }

    public int getChannelCommentCount() {
        return channelCommentCount;
    }

    public void setChannelCommentCount(int channelCommentCount) {
        this.channelCommentCount = channelCommentCount;
    }

    public int getChannelElapsedTime() {
        return channelElapsedTime;
    }

    public void setChannelElapsedTime(int channelElapsedTime) {
        this.channelElapsedTime = channelElapsedTime;
    }

    public double getLikesPerViews() {
        return likesPerViews;
    }

    public void setLikesPerViews(double likesPerViews) {
        this.likesPerViews = likesPerViews;
    }

    public long getVideoViewCount() {
        return videoViewCount;
    }

    public void setVideoViewCount(long videoViewCount) {
        this.videoViewCount = videoViewCount;
    }

    public int getVideoCommentCount() {
        return videoCommentCount;
    }

    public void setVideoCommentCount(int videoCommentCount) {
        this.videoCommentCount = videoCommentCount;
    }

    public String getVideoPublished() {
        return videoPublished;
    }

    public void setVideoPublished(String videoPublished) {
        this.videoPublished = videoPublished;
    }

    public double getViewsPerElapsedTime() {
        return viewsPerElapsedTime;
    }

    public void setViewsPerElapsedTime(double viewsPerElapsedTime) {
        this.viewsPerElapsedTime = viewsPerElapsedTime;
    }

    public double getTotViewsPerTotSubs() {
        return totViewsPerTotSubs;
    }

    public void setTotViewsPerTotSubs(double totViewsPerTotSubs) {
        this.totViewsPerTotSubs = totViewsPerTotSubs;
    }

    public double getDislikesPerSubscriber() {
        return dislikesPerSubscriber;
    }

    public void setDislikesPerSubscriber(double dislikesPerSubscriber) {
        this.dislikesPerSubscriber = dislikesPerSubscriber;
    }

    public long getVideoDislikeCount() {
        return videoDislikeCount;
    }

    public void setVideoDislikeCount(long videoDislikeCount) {
        this.videoDislikeCount = videoDislikeCount;
    }

    public long getVideoLikeCount() {
        return videoLikeCount;
    }

    public void setVideoLikeCount(long videoLikeCount) {
        this.videoLikeCount = videoLikeCount;
    }

    public double getElapsedTime() {
        return elapsedTime;
    }

    public void setElapsedTime(double elapsedTime) {
        this.elapsedTime = elapsedTime;
    }

    public double getTotVideosPerVideoCount() {
        return totVideosPerVideoCount;
    }

    public void setTotVideosPerVideoCount(double totVideosPerVideoCount) {
        this.totVideosPerVideoCount = totVideosPerVideoCount;
    }

    public double getCommentsPerViews() {
        return commentsPerViews;
    }

    public void setCommentsPerViews(double commentsPerViews) {
        this.commentsPerViews = commentsPerViews;
    }

    public double getLikesPerDislikes() {
        return likesPerDislikes;
    }

    public void setLikesPerDislikes(double likesPerDislikes) {
        this.likesPerDislikes = likesPerDislikes;
    }

    @PrimaryKey
    private String videoId;

    @Column("index")
    private double index;

    @Column("totalviews_channelelapsedtime")
    private double totalViewsPerChannelElapsedTime;

    @Column("channelId")
    private String channelId;

    @Column("videoCategoryId")
    private int videoCategoryId;

    @Column("channelViewCount")
    private long channelViewCount;

    @Column("likes_subscriber")
    private double likesPerSubscriber;

    @Column("views_subscribers")
    private double viewsPerSubscribers;

    @Column("videoCount")
    private int videoCount;

    @Column("subscriberCount")
    private long subscriberCount;

    @Column("dislikes_views")
    private double dislikesPerViews;

    @Column("channelelapsedtime")
    private int channelElapsedTime;

    @Column("comments_subscriber")
    private double commentsPerSubscriber;

    @Column("likes_views")
    private double likesPerViews;

    @Column("channelCommentCount")
    private int channelCommentCount;

    @Column("videoViewCount")
    private long videoViewCount;

    @Column("likes_dislikes")
    private double likesPerDislikes;

    @Column("comments_views")
    private double commentsPerViews;

    @Column("totvideos_videocount")
    private double totVideosPerVideoCount;

    @Column("elapsedtime")
    private double elapsedTime;

    @Column("videoLikeCount")
    private long videoLikeCount;

    @Column("videoDislikeCount")
    private long videoDislikeCount;

    @Column("dislikes_subscriber")
    private double dislikesPerSubscriber;

    @Column("totviews_totsubs")
    private double totViewsPerTotSubs;

    @Column("views_elapsedtime")
    private double viewsPerElapsedTime;

    @Column("videoPublished")
    private String videoPublished;

    @Column("videoCommentCount")
    private int videoCommentCount;
}