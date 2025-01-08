package com.bigdata.spark.processor;

import com.bigdata.spark.entity.YouTubeData;
import com.bigdata.spark.util.YouTubeDataDeserializer;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.RowFactory;
import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.types.StructType;
import org.apache.spark.streaming.Durations;
import org.apache.spark.streaming.api.java.JavaInputDStream;
import org.apache.spark.streaming.api.java.JavaStreamingContext;
import org.apache.spark.streaming.kafka010.ConsumerStrategies;
import org.apache.spark.streaming.kafka010.KafkaUtils;
import org.apache.spark.streaming.kafka010.LocationStrategies;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StreamProcessor {
	private static final String KAFKA_BROKER = "localhost:9092"; // Replace with your Kafka broker
	private static final String TOPIC = "youtube-data"; // Replace with your Kafka topic

	public static void main(String[] args) throws InterruptedException {
		SparkConf conf = new SparkConf().setAppName("YouTubeDataProcessor").setMaster("local[2]");
		JavaSparkContext sc = new JavaSparkContext(conf);
		SparkSession spark = SparkSession.builder().appName("YouTubeDataProcessor").getOrCreate();

		// Create Spark Streaming context
		JavaStreamingContext ssc = new JavaStreamingContext(sc, Durations.seconds(10));

		// Set up Kafka parameters
		Map<String, Object> kafkaParams = new HashMap<>();
		kafkaParams.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, KAFKA_BROKER);
		kafkaParams.put(ConsumerConfig.GROUP_ID_CONFIG, "spark-consumer-group");
		kafkaParams.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "latest");
		kafkaParams.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		kafkaParams.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, YouTubeDataDeserializer.class);

		// Define Kafka topics to listen to
		List<String> topics = List.of(TOPIC);

		// Create a DStream that represents the stream of input data from Kafka
		JavaInputDStream<ConsumerRecord<String, YouTubeData>> stream = KafkaUtils.createDirectStream(
				ssc,
				LocationStrategies.PreferConsistent(),
				ConsumerStrategies.Subscribe(topics, kafkaParams)
		);

		// Process the stream
		stream.foreachRDD(rdd -> {
			if (!rdd.isEmpty()) {
				// Convert RDD<ConsumerRecord<String, YouTubeData>> to RDD<Row>
				JavaRDD<Row> rowRDD = rdd.map(record -> {
					YouTubeData data = record.value();
					return RowFactory.create(
							data.getVideoId(),
							data.getChannelId(),
							data.getVideoCategoryId(),
							data.getChannelViewCount(),
							data.getLikesPerSubscriber(),
							data.getViewsPerSubscriber(),
							data.getVideoCount(),
							data.getSubscriberCount(),
							data.getDislikesPerView(),
							data.getChannelCommentCount(),
							data.getVideoViewCount(),
							data.getLikesPerView(),
							data.getCommentsPerView(),
							data.getTotalVideosPerVideoCount(),
							data.getElapsedTime(),
							data.getVideoLikeCount(),
							data.getVideoDislikeCount(),
							data.getTotalViewsPerSubscriber(),
							data.getViewsPerElapsedTime(),
							data.getVideoPublished(),
							data.getVideoCommentCount()
					);
				});

				// Create DataFrame from RDD<Row>
				Dataset<Row> youtubeDataDF = spark.createDataFrame(rowRDD, YouTubeData.getSchema());

				// Perform transformations or actions on the DataFrame
				youtubeDataDF.createOrReplaceTempView("youtube_data");

				// Example query to compute total likes per view
				Dataset<Row> result = spark.sql(
						"SELECT videoId, (videoLikeCount / videoViewCount) AS likesPerView FROM youtube_data");

				// Save the results to a database (e.g., Cassandra or HDFS)
				result.write()
						.mode("append")
						.parquet("hdfs://localhost:9000/user/output/youtube_data");
			}
		});

		// Start the computation
		ssc.start();

		// Wait for the computation to terminate
		ssc.awaitTermination();
	}
}