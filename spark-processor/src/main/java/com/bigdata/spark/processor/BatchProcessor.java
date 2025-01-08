package com.bigdata.spark.processor;

import com.bigdata.spark.entity.YouTubeData;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class BatchProcessor {

	public static class ProcessorUtils {

		public static class StreamProcessor {

			public static List<YouTubeData> processCSV(String csvFile) throws ParseException {
				List<YouTubeData> youtubeDataList = new ArrayList<>();
				// Simulate parsing CSV data
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");

				// Example data
				YouTubeData data = new YouTubeData();
				data.setVideoId("video1");
				data.setChannelId("channel1");
				data.setVideoCategoryId(1);
				data.setChannelViewCount(1000);
				data.setLikesPerSubscriber(0.5);
				data.setViewsPerSubscriber(10.0);
				data.setVideoCount(5);
				data.setSubscriberCount(100);
				data.setDislikesPerView(0.1);
				data.setChannelCommentCount(50);
				data.setVideoViewCount(10000);
				data.setLikesPerView(0.2);
				data.setCommentsPerView(5);
				data.setTotalVideosPerVideoCount(2.0);
				data.setElapsedTime(3600.0);
				data.setVideoLikeCount(200);
				data.setVideoDislikeCount(20);
				data.setTotalViewsPerSubscriber(100.0);
				data.setViewsPerElapsedTime(0.1);
				data.setVideoPublished(dateFormat.parse("2024-01-01T00:00:00.000Z"));
				data.setVideoCommentCount(10);

				youtubeDataList.add(data);
				return youtubeDataList;
			}
		}
	}

	public static void main(String[] args) {
		try {
			String csvFile = "youtube_data.csv"; // Path to your CSV file
			List<YouTubeData> youtubeDataList = ProcessorUtils.StreamProcessor.processCSV(csvFile);

			// Print the data
			youtubeDataList.forEach(System.out::println);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
}