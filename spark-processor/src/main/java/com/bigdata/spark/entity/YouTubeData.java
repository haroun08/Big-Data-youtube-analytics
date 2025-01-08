package com.bigdata.spark.entity;

import org.apache.spark.sql.types.DataTypes;
import org.apache.spark.sql.types.StructType;

import java.io.Serializable;
import java.util.Date;

public class YouTubeData implements Serializable {
    private String videoId;
    private String channelId;
    private int videoCategoryId;
    private int channelViewCount;
    private double likesPerSubscriber;
    private double viewsPerSubscriber;
    private int videoCount;
    private int subscriberCount;
    private double dislikesPerView;
    private int channelCommentCount;
    private int videoViewCount;
    private double likesPerView;
    private int commentsPerView;
    private double totalVideosPerVideoCount;
    private double elapsedTime;
    private int videoLikeCount;
    private int videoDislikeCount;
    private double totalViewsPerSubscriber;
    private double viewsPerElapsedTime;
    private Date videoPublished;
    private int videoCommentCount;

    // Getters and Setters
    public String getVideoId() {
        return videoId;
    }

    public void setVideoId(String videoId) {
        this.videoId = videoId;
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public int getVideoCategoryId() {
        return videoCategoryId;
    }

    public void setVideoCategoryId(int videoCategoryId) {
        this.videoCategoryId = videoCategoryId;
    }

    public int getChannelViewCount() {
        return channelViewCount;
    }

    public void setChannelViewCount(int channelViewCount) {
        this.channelViewCount = channelViewCount;
    }

    public double getLikesPerSubscriber() {
        return likesPerSubscriber;
    }

    public void setLikesPerSubscriber(double likesPerSubscriber) {
        this.likesPerSubscriber = likesPerSubscriber;
    }

    public double getViewsPerSubscriber() {
        return viewsPerSubscriber;
    }

    public void setViewsPerSubscriber(double viewsPerSubscriber) {
        this.viewsPerSubscriber = viewsPerSubscriber;
    }

    public int getVideoCount() {
        return videoCount;
    }

    public void setVideoCount(int videoCount) {
        this.videoCount = videoCount;
    }

    public int getSubscriberCount() {
        return subscriberCount;
    }

    public void setSubscriberCount(int subscriberCount) {
        this.subscriberCount = subscriberCount;
    }

    public double getDislikesPerView() {
        return dislikesPerView;
    }

    public void setDislikesPerView(double dislikesPerView) {
        this.dislikesPerView = dislikesPerView;
    }

    public int getChannelCommentCount() {
        return channelCommentCount;
    }

    public void setChannelCommentCount(int channelCommentCount) {
        this.channelCommentCount = channelCommentCount;
    }

    public int getVideoViewCount() {
        return videoViewCount;
    }

    public void setVideoViewCount(int videoViewCount) {
        this.videoViewCount = videoViewCount;
    }

    public double getLikesPerView() {
        return likesPerView;
    }

    public void setLikesPerView(double likesPerView) {
        this.likesPerView = likesPerView;
    }

    public int getCommentsPerView() {
        return commentsPerView;
    }

    public void setCommentsPerView(int commentsPerView) {
        this.commentsPerView = commentsPerView;
    }

    public double getTotalVideosPerVideoCount() {
        return totalVideosPerVideoCount;
    }

    public void setTotalVideosPerVideoCount(double totalVideosPerVideoCount) {
        this.totalVideosPerVideoCount = totalVideosPerVideoCount;
    }

    public double getElapsedTime() {
        return elapsedTime;
    }

    public void setElapsedTime(double elapsedTime) {
        this.elapsedTime = elapsedTime;
    }

    public int getVideoLikeCount() {
        return videoLikeCount;
    }

    public void setVideoLikeCount(int videoLikeCount) {
        this.videoLikeCount = videoLikeCount;
    }

    public int getVideoDislikeCount() {
        return videoDislikeCount;
    }

    public void setVideoDislikeCount(int videoDislikeCount) {
        this.videoDislikeCount = videoDislikeCount;
    }

    public double getTotalViewsPerSubscriber() {
        return totalViewsPerSubscriber;
    }

    public void setTotalViewsPerSubscriber(double totalViewsPerSubscriber) {
        this.totalViewsPerSubscriber = totalViewsPerSubscriber;
    }

    public double getViewsPerElapsedTime() {
        return viewsPerElapsedTime;
    }

    public void setViewsPerElapsedTime(double viewsPerElapsedTime) {
        this.viewsPerElapsedTime = viewsPerElapsedTime;
    }

    public Date getVideoPublished() {
        return videoPublished;
    }

    public void setVideoPublished(Date videoPublished) {
        this.videoPublished = videoPublished;
    }

    public int getVideoCommentCount() {
        return videoCommentCount;
    }

    public void setVideoCommentCount(int videoCommentCount) {
        this.videoCommentCount = videoCommentCount;
    }

    public static StructType getSchema() {
        return new StructType()
                .add("videoId", DataTypes.StringType, true)
                .add("channelId", DataTypes.StringType, true)
                .add("videoCategoryId", DataTypes.IntegerType, true)
                .add("channelViewCount", DataTypes.IntegerType, true)
                .add("likesPerSubscriber", DataTypes.DoubleType, true)
                .add("viewsPerSubscriber", DataTypes.DoubleType, true)
                .add("videoCount", DataTypes.IntegerType, true)
                .add("subscriberCount", DataTypes.IntegerType, true)
                .add("dislikesPerView", DataTypes.DoubleType, true)
                .add("channelCommentCount", DataTypes.IntegerType, true)
                .add("videoViewCount", DataTypes.IntegerType, true)
                .add("likesPerView", DataTypes.DoubleType, true)
                .add("commentsPerView", DataTypes.IntegerType, true)
                .add("totalVideosPerVideoCount", DataTypes.DoubleType, true)
                .add("elapsedTime", DataTypes.DoubleType, true)
                .add("videoLikeCount", DataTypes.IntegerType, true)
                .add("videoDislikeCount", DataTypes.IntegerType, true)
                .add("totalViewsPerSubscriber", DataTypes.DoubleType, true)
                .add("viewsPerElapsedTime", DataTypes.DoubleType, true)
                .add("videoPublished", DataTypes.DateType, true)
                .add("videoCommentCount", DataTypes.IntegerType, true);
    }
}