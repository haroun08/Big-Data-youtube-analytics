package com.bigdata.dashboard.service;

import com.bigdata.dashboard.entity.YouTubeData;
import com.bigdata.dashboard.repository.YouTubeDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class YouTubeDataService {

    @Autowired
    private YouTubeDataRepository repository;

    @Cacheable("allData")
    public List<YouTubeData> getAllData() {
        return repository.findAll();
    }

    @Cacheable(value = "dataByChannel", key = "#channelId")
    public List<YouTubeData> getDataByChannel(String channelId) {
        return repository.findByChannelId(channelId);
    }

    @Cacheable(value = "dataByCategory", key = "#categoryId")
    public List<YouTubeData> getDataByCategory(int categoryId) {
        return repository.findByVideoCategoryId(categoryId);
    }
}