package com.bigdata.kafka;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class YouTubeData {
	private String videoId;
	private String channelId;
	private int videoCategoryId;
	private long channelViewCount;
	private long subscriberCount;
	private long videoViewCount;
	private long videoLikeCount;
	private long videoDislikeCount;
	private String videoPublished;
}