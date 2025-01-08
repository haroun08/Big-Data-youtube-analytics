package com.bigdata.kafka;

import java.util.List;

public class YouTubeDataStreamer {

    public static void main(String[] args) {
        // Initialize the producer
        String kafkaConfigPath = "kafka-producer/src/main/resources/kafka-producer.properties";  // Adjust the path
        String topic = "YouTube_topic";
        YouTubeDataProducer producer = new YouTubeDataProducer(kafkaConfigPath, topic);

        // Read the CSV file
        String csvFilePath = "kafka-producer/data/YouTubeDataset_withChannelElapsed.csv";
        YouTubeDataCSVReader csvReader = new YouTubeDataCSVReader();
        List<YouTubeData> dataList = csvReader.readCSV(csvFilePath);

        // Stream data to Kafka
        for (YouTubeData data : dataList) {
            producer.sendYouTubeData(data);
        }

        // Close the producer
        producer.closeProducer();
    }
}