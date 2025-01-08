# YouTube Analytics Pipeline using Lambda Architecture

This application is a YouTube data processing and monitoring system designed to handle massive quantities of data using the **Lambda Architecture**. It processes both real-time and batch data to provide insights into YouTube video and channel metrics.

---

## **Architecture**
The application follows the Lambda Architecture, which combines batch processing and stream processing to handle large-scale data efficiently. The architecture is divided into three layers:

1. **Batch Layer**: Processes historical data to compute pre-aggregated views.
2. **Speed Layer**: Handles real-time data streams for immediate insights.
3. **Serving Layer**: Combines results from the batch and speed layers for querying and visualization.

---

## **Modules**
The application is divided into three standalone Maven modules, each written in Java and capable of being built and run independently.

### **1. Kafka Producer**
**Purpose**: Simulates real-time YouTube data ingestion.

#### **Functionality**:
- Reads YouTube data from a CSV file (`YouTubeDataset_withChannelElapsed.csv`).
- Parses the data into `YouTubeData` objects.
- Sends the data as events to a Kafka topic (`YouTube_topic`).

#### **Key Metrics**:
- Video views, likes, dislikes, and comments.
- Channel views, subscribers, and engagement ratios.

### **2. Spark Processor**

#### **Stream Processor (Speed Layer)**
**Purpose**: Processes real-time data streams.

**Functionality**:
- Reads data from the Kafka topic (`YouTube_topic`).
- Separates and processes metrics such as video views, likes, dislikes, and comments.
- Stores processed data in Cassandra for real-time querying.
- Appends raw data to Hadoop HDFS for batch processing.

#### **Batch Processor (Batch Layer)**
**Purpose**: Processes historical data for comprehensive analytics.

**Functionality**:
- Reads raw data from Hadoop HDFS.
- Computes aggregated metrics (e.g., average views, likes, dislikes, and comments per video or channel).
- Stores pre-computed views in Cassandra for serving layer queries.

### **3. Dashboard**
**Purpose**: Visualizes real-time and batch-processed data.

**Functionality**:
- Retrieves data from Cassandra.
- Uses WebSocket and jQuery to push real-time updates to the web page.
- Displays metrics using Google Charts:
   - Real-time metrics (e.g., video views, likes, dislikes, comments).
   - Batch-processed metrics (e.g., average views, likes, dislikes, comments).

#### **Features**:
- Automatic data refresh at fixed intervals.
- Separate intervals for real-time and batch-processed data.

---

## **Execution**
The application is containerized using Docker, making it easy to set up and run. Follow these steps to execute the application:

### **Prerequisites**
- Install Docker on your machine.

### **Steps**

#### 1. Start the Docker containers:
```bash
docker-compose up
```

#### 2. Create the Cassandra database schema:
```bash
docker exec cassandra-iot cqlsh --username cassandra --password cassandra -f /schema.cql
```

#### 3. Set up Hadoop HDFS directories:
```bash
docker exec namenode hdfs dfs -rm -r /lambda-arch
docker exec namenode hdfs dfs -mkdir /lambda-arch
docker exec namenode hdfs dfs -mkdir /lambda-arch/checkpoint
docker exec namenode hdfs dfs -chmod -R 777 /lambda-arch
docker exec namenode hdfs dfs -chmod -R 777 /lambda-arch/checkpoint
```

#### 4. Run the Stream Processor:
```bash
docker exec spark-master /spark/bin/spark-submit --class com.bigdata.spark.processor.StreamProcessor --master spark://localhost:7077 /opt/spark-data/bigdata-spark-processor-1.0.0.jar
```

#### 5. Run the Batch Processor:
```bash
docker exec spark-master /spark/bin/spark-submit --class com.bigdata.spark.processor.BatchProcessor --master spark://localhost:7077 /opt/spark-data/bigdata-spark-processor-1.0.0.jar
```

#### 6. Access the Dashboard:
Open your browser and navigate to:
```
http://localhost:3000
```

---

## **Stack**
The application uses the following technologies:

- **Programming Language**: Java 23
- **Build Tool**: Maven
- **Web Framework**: Spring Boot
- **Stream Processing**: Kafka, Spark Streaming
- **Batch Processing**: Spark, Hadoop HDFS
- **Database**: Cassandra
- **Containerization**: Docker
- **Visualization**: Google Charts, jQuery, WebSocket

---

## **Key Features**

### **Real-Time Data Processing**:
- Processes YouTube data in real-time using Kafka and Spark Streaming.
- Provides immediate insights into video and channel metrics.

### **Batch Data Processing**:
- Computes aggregated metrics (e.g., averages) using Spark and Hadoop HDFS.
- Stores pre-computed views in Cassandra for efficient querying.

### **Interactive Dashboard**:
- Displays real-time and batch-processed metrics using Google Charts.
- Automatically refreshes data at fixed intervals.

### **Scalable Architecture**:
- Uses Lambda Architecture to handle both real-time and batch data efficiently.
- Containerized using Docker for easy deployment and scaling.

---

## **Example Use Case**
Suppose the CSV file contains the following data:

| videoId | videoViewCount | videoLikeCount | videoDislikeCount | videoCommentCount | channelViewCount | subscriberCount | videoPublished |
|---------|----------------|----------------|-------------------|-------------------|------------------|-----------------|----------------|
| abc123  | 1000           | 500            | 50                | 200               | 10000            | 1000            | 2023-10-01     |
| xyz456  | 2000           | 1000           | 100               | 500               | 20000            | 2000            | 2023-10-02     |

The application will:

1. Ingest the data from the CSV file.
2. Stream the data to Kafka.
3. Process the data in real-time using Spark Streaming.
4. Store the processed data in Cassandra.
5. Compute aggregated metrics (e.g., average views, likes, dislikes) using Spark Batch Processing.
6. Visualize the data in the dashboard.

---

## **Next Steps**

### **Adding More Metrics**:
- Calculate engagement rates, subscriber growth, and video performance trends.

### **Improving the Dashboard**:
- Add interactive charts and filters for better data exploration.

### **Scaling the Application**:
- Use a distributed Kafka cluster for high-throughput data streaming.
- Scale the Spark job to handle larger datasets.

### **Monitoring and Logging**:
- Add logging and monitoring using tools like Prometheus and Grafana