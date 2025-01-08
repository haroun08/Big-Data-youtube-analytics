package com.bigdata.spark.processor;

import org.apache.spark.SparkConf;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SaveMode;
import org.apache.spark.sql.SparkSession;

import java.util.Properties;

public class ProcessorUtils {

	public static SparkConf getSparkConf(Properties prop) {
		SparkConf sparkConf = new SparkConf()
				.setAppName(prop.getProperty("com.iot.app.spark.app.name"))
				.setMaster(prop.getProperty("com.iot.app.spark.master"));

		if ("local".equals(prop.getProperty("com.iot.app.env"))) {
			sparkConf.set("spark.driver.bindAddress", "127.0.0.1");
		}
		return sparkConf;
	}

	// Method to read data from a CSV file into a Spark DataFrame
	public static Dataset<Row> readCsvData(SparkSession sparkSession, String csvFilePath) {
		System.out.println("Reading CSV data...");
		return sparkSession.read()
				.option("header", "true")  // Assume the CSV file has headers
				.option("inferSchema", "true")  // Automatically infer data types
				.csv(csvFilePath);
	}

	// Method to save DataFrame to HDFS (Batch processing)
	public static void saveDataToHDFS(Dataset<Row> dataFrame, String saveFile) {
		System.out.println("Saving data to HDFS...");
		dataFrame.write()
				.mode(SaveMode.Append)
				.parquet(saveFile);
	}

	// Method to process and visualize data
	public static void processAndVisualizeData(SparkSession sparkSession, String csvFilePath, String saveFile) {
		// Read data from CSV file
		Dataset<Row> dataFrame = readCsvData(sparkSession, csvFilePath);

		// Show schema and a few rows of the data for visualization
		dataFrame.printSchema();
		dataFrame.show(10);

		// Save data to HDFS (if needed)
		saveDataToHDFS(dataFrame, saveFile);
	}
}
