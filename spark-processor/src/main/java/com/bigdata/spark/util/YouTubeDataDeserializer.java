package com.bigdata.spark.util;

import com.bigdata.spark.entity.YouTubeData;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.serialization.Deserializer;

import java.util.Map;

public class YouTubeDataDeserializer implements Deserializer<YouTubeData> {

    private static ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public YouTubeData deserialize(String topic, byte[] data) {
        try {
            return objectMapper.readValue(data, YouTubeData.class);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {}

    @Override
    public void close() {}
}