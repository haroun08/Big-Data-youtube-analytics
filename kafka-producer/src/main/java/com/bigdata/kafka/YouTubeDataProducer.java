package com.bigdata.kafka;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;

public class YouTubeDataProducer {
    private KafkaProducer<String, YouTubeData> producer;
    private String topic;

    public YouTubeDataProducer(String kafkaConfigPath, String topic) {
        try {
            PropertyFileReader propertyFileReader = new PropertyFileReader(kafkaConfigPath);
            Properties properties = new Properties();

            // Kafka Producer Configurations
            properties.put("bootstrap.servers", propertyFileReader.getProperty("com.iot.app.kafka.brokerlist"));
            properties.put("key.serializer", StringSerializer.class.getName());
            properties.put("value.serializer", YouTubeDataEncoder.class.getName());

            producer = new KafkaProducer<>(properties);
            this.topic = topic;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void sendYouTubeData(YouTubeData data) {
        try {
            producer.send(new ProducerRecord<>(topic, data.getVideoId(), data));
            System.out.println("Sent data: " + data);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void closeProducer() {
        if (producer != null) {
            producer.close();
        }
    }
}