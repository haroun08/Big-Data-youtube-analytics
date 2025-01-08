package com.bigdata.dashboard.utils;

import com.bigdata.dashboard.entity.YouTubeData;
import com.bigdata.dashboard.service.YouTubeDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataService {

	@Autowired
	private SimpMessagingTemplate messagingTemplate;

	@Autowired
	private YouTubeDataService youtubeDataService;

	public void sendYouTubeData() {
		List<YouTubeData> data = youtubeDataService.getAllData();
		if (!data.isEmpty()) {
			YouTubeData latestData = data.get(0); // Example: Send the first record
			Response response = new Response(
					latestData.getIndex(),
					latestData.getTotalViewsPerChannelElapsedTime(),
					latestData.getChannelId(),
					latestData.getVideoCategoryId(),
					latestData.getChannelViewCount(),
					latestData.getLikesPerSubscriber(),
					latestData.getViewsPerSubscribers(),
					latestData.getVideoCount(),
					latestData.getSubscriberCount(),
					latestData.getVideoId(),
					latestData.getDislikesPerViews(),
					latestData.getChannelElapsedTime(),
					latestData.getCommentsPerSubscriber(),
					latestData.getLikesPerViews(),
					latestData.getChannelCommentCount(),
					latestData.getVideoViewCount(),
					latestData.getLikesPerDislikes(),
					latestData.getCommentsPerViews(),
					latestData.getTotVideosPerVideoCount(),
					latestData.getElapsedTime(),
					latestData.getVideoLikeCount(),
					latestData.getVideoDislikeCount(),
					latestData.getDislikesPerSubscriber(),
					latestData.getTotViewsPerTotSubs(),
					latestData.getViewsPerElapsedTime(),
					latestData.getVideoPublished(),
					latestData.getVideoCommentCount()
			);
			messagingTemplate.convertAndSend("/topic/youtube", response);
		}
	}
}