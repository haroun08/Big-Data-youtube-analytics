package com.bigdata.dashboard.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data // Generates getters, setters, toString, equals, and hashCode
@NoArgsConstructor // Generates a no-args constructor
public class Response implements Serializable   {
    private double index;
    private double totalViewsPerChannelElapsedTime;
    private String channelId;
    private int videoCategoryId;
    private long channelViewCount;
    private double likesPerSubscriber;
    private double viewsPerSubscribers;
    private int videoCount;
    private long subscriberCount;
    private String videoId;
    private double dislikesPerViews;
    private int channelElapsedTime;
    private double commentsPerSubscriber;
    private double likesPerViews;
    private int channelCommentCount;
    private long videoViewCount;
    private double likesPerDislikes;
    private double commentsPerViews;
    private double totVideosPerVideoCount;
    private double elapsedTime;
    private long videoLikeCount;
    private long videoDislikeCount;
    private double dislikesPerSubscriber;
    private double totViewsPerTotSubs;
    private double viewsPerElapsedTime;
    private String videoPublished;
    private int videoCommentCount;

    // Constructor to match the fields you want to set
    public Response(double index, double totalViewsPerChannelElapsedTime, String channelId, int videoCategoryId,
                    long channelViewCount, double likesPerSubscriber, double viewsPerSubscribers, int videoCount,
                    long subscriberCount, String videoId, double dislikesPerViews, int channelElapsedTime,
                    double commentsPerSubscriber, double likesPerViews, int channelCommentCount, long videoViewCount,
                    double likesPerDislikes, double commentsPerViews, double totVideosPerVideoCount, double elapsedTime,
                    long videoLikeCount, long videoDislikeCount, double dislikesPerSubscriber, double totViewsPerTotSubs,
                    double viewsPerElapsedTime, String videoPublished, int videoCommentCount) {
        this.index = index;
        this.totalViewsPerChannelElapsedTime = totalViewsPerChannelElapsedTime;
        this.channelId = channelId;
        this.videoCategoryId = videoCategoryId;
        this.channelViewCount = channelViewCount;
        this.likesPerSubscriber = likesPerSubscriber;
        this.viewsPerSubscribers = viewsPerSubscribers;
        this.videoCount = videoCount;
        this.subscriberCount = subscriberCount;
        this.videoId = videoId;
        this.dislikesPerViews = dislikesPerViews;
        this.channelElapsedTime = channelElapsedTime;
        this.commentsPerSubscriber = commentsPerSubscriber;
        this.likesPerViews = likesPerViews;
        this.channelCommentCount = channelCommentCount;
        this.videoViewCount = videoViewCount;
        this.likesPerDislikes = likesPerDislikes;
        this.commentsPerViews = commentsPerViews;
        this.totVideosPerVideoCount = totVideosPerVideoCount;
        this.elapsedTime = elapsedTime;
        this.videoLikeCount = videoLikeCount;
        this.videoDislikeCount = videoDislikeCount;
        this.dislikesPerSubscriber = dislikesPerSubscriber;
        this.totViewsPerTotSubs = totViewsPerTotSubs;
        this.viewsPerElapsedTime = viewsPerElapsedTime;
        this.videoPublished = videoPublished;
        this.videoCommentCount = videoCommentCount;
    }

    // Getters and setters for all fields...
}
