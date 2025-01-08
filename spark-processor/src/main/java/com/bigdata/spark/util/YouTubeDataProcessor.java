package com.bigdata.spark.util;

import org.apache.spark.sql.*;
import org.apache.spark.sql.types.*;

public class YouTubeDataProcessor {

    public static StructType getSchema() {
        return new StructType()
                .add("videoId", DataTypes.StringType, true)
                .add("channelId", DataTypes.StringType, true)
                .add("videoCategoryId", DataTypes.IntegerType, true)
                .add("channelViewCount", DataTypes.IntegerType, true)
                .add("likesPerSubscriber", DataTypes.DoubleType, true)
                .add("viewsPerSubscriber", DataTypes.DoubleType, true)
                .add("videoCount", DataTypes.IntegerType, true)
                .add("subscriberCount", DataTypes.IntegerType, true)
                .add("dislikesPerView", DataTypes.DoubleType, true)
                .add("channelCommentCount", DataTypes.IntegerType, true)
                .add("videoViewCount", DataTypes.IntegerType, true)
                .add("likesPerView", DataTypes.DoubleType, true)
                .add("commentsPerView", DataTypes.IntegerType, true)
                .add("totalVideosPerVideoCount", DataTypes.DoubleType, true)
                .add("elapsedTime", DataTypes.DoubleType, true)
                .add("videoLikeCount", DataTypes.IntegerType, true)
                .add("videoDislikeCount", DataTypes.IntegerType, true)
                .add("dislikesPerSubscriber", DataTypes.DoubleType, true)
                .add("totalViewsPerSubscriber", DataTypes.DoubleType, true)
                .add("viewsPerElapsedTime", DataTypes.DoubleType, true)
                .add("videoPublished", DataTypes.DateType, true)
                .add("videoCommentCount", DataTypes.IntegerType, true);
    }

    public static void main(String[] args) {
        // Initialize Spark session
        SparkSession spark = SparkSession.builder().appName("YouTubeDataProcessor").getOrCreate();

        // Load the dataset into a DataFrame using the schema
        Dataset<Row> youtubeData = spark.read()
                .schema(getSchema())
                .json("path/to/your/youtube_data.json");  // Make sure the path to the dataset is correct

        // Register the DataFrame as a temporary view for SQL queries
        youtubeData.createOrReplaceTempView("youtube_data");

        // Run the SQL query with the modified handling for likesPerView
        Dataset<Row> result = spark.sql(
                "SELECT videoId, " +
                        "CASE WHEN videoViewCount != 0 THEN videoLikeCount / videoViewCount ELSE 0 END AS likesPerView " +
                        "FROM youtube_data");

        // Show the result
        result.show();
    }
}
