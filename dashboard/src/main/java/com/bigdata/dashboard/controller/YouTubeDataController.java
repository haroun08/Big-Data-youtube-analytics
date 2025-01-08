package com.bigdata.dashboard.controller;

import com.bigdata.dashboard.entity.YouTubeData;
import com.bigdata.dashboard.service.YouTubeDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/youtube")
public class YouTubeDataController {

    @Autowired
    private YouTubeDataService service;




    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @Scheduled(fixedRate = 5000) // Send data every 5 seconds
    public void sendData() {
        YouTubeData data = new YouTubeData();
        data.setVideoViewCount(1000);
        data.setVideoLikeCount(500);
        data.setVideoDislikeCount(50);
        data.setVideoCommentCount(200);
        data.setChannelViewCount(10000);
        data.setSubscriberCount(1000);
        data.setVideoPublished("2023-10-01");

        System.out.println("Sending data: " + data);
        messagingTemplate.convertAndSend("/topic/data", data);
    }
    @GetMapping("/all")
    public ResponseEntity<List<YouTubeData>> getAllData() {
        List<YouTubeData> data = service.getAllData();
        if (data.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(data);
    }

    @GetMapping("/channel/{channelId}")
    public ResponseEntity<List<YouTubeData>> getDataByChannel(@PathVariable String channelId) {
        List<YouTubeData> data = service.getDataByChannel(channelId);
        if (data.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(data);
    }

    @GetMapping("/category/{categoryId}")
    public ResponseEntity<List<YouTubeData>> getDataByCategory(@PathVariable int categoryId) {
        List<YouTubeData> data = service.getDataByCategory(categoryId);
        if (data.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(data);
    }
}