package com.bigdata.kafka;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class YouTubeDataCSVReader {

    public List<YouTubeData> readCSV(String filePath) {
        List<YouTubeData> dataList = new ArrayList<>();
        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            String[] nextLine;
            boolean isHeader = true;
            while ((nextLine = reader.readNext()) != null) {
                if (isHeader) {
                    isHeader = false;
                    continue; // Skip header
                }
                YouTubeData data = new YouTubeData(
                        nextLine[9],  // videoId
                        nextLine[2],  // channelId
                        Integer.parseInt(nextLine[3]),  // videoCategoryId
                        Long.parseLong(nextLine[4]),  // channelViewCount
                        Long.parseLong(nextLine[8]),  // subscriberCount
                        Long.parseLong(nextLine[15]), // videoViewCount
                        Long.parseLong(nextLine[20]), // videoLikeCount
                        Long.parseLong(nextLine[21]), // videoDislikeCount
                        nextLine[25]  // videoPublished
                );
                dataList.add(data);
            }
        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        }
        return dataList;
    }
}