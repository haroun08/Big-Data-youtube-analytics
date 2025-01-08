package com.bigdata.dashboard.repository;

import com.bigdata.dashboard.entity.YouTubeData;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface YouTubeDataRepository extends CassandraRepository<YouTubeData, String> {
    List<YouTubeData> findByChannelId(String channelId);
    List<YouTubeData> findByVideoCategoryId(int videoCategoryId);

    @Query("SELECT videoId, videoViewCount FROM youtube_data WHERE channelId = ?0")
    List<YouTubeData> findVideoIdsAndViewsByChannelId(String channelId);
}