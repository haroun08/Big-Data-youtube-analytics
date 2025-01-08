package com.bigdata.dashboard.utils;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DataUtils {

    // Format date from YouTube API date format to a simpler format (yyyy-MM-dd)
    public static String formatDate(String date) {
        try {
            // Original YouTube date format: "2024-01-01T00:00:00.000Z"
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
            Date parsedDate = sdf.parse(date);
            // Format to "yyyy-MM-dd"
            return new SimpleDateFormat("yyyy-MM-dd").format(parsedDate);
        } catch (Exception e) {
            return date; // Return original date string if parsing fails
        }
    }

    // Format large numbers (e.g., view counts, likes) with commas for readability
    public static String formatNumber(long number) {
        DecimalFormat formatter = new DecimalFormat("#,###");
        return formatter.format(number);
    }

    // Format the likes/dislikes count (positive number check)
    public static String formatLikesDislikes(int count) {
        return (count >= 0) ? String.valueOf(count) : "N/A"; // In case of invalid count
    }

    // Format video views with commas and suffix if necessary (e.g., K for thousands, M for millions)
    public static String formatViewCount(long viewCount) {
        if (viewCount >= 1_000_000) {
            return String.format("%.1fM", viewCount / 1_000_000.0);
        } else if (viewCount >= 1_000) {
            return String.format("%.1fK", viewCount / 1_000.0);
        } else {
            return String.format("%,d", viewCount);
        }
    }

    // Format subscriber count similarly to views (use K/M suffixes)
    public static String formatSubscriberCount(int subscriberCount) {
        if (subscriberCount >= 1_000_000) {
            return String.format("%.1fM", subscriberCount / 1_000_000.0);
        } else if (subscriberCount >= 1_000) {
            return String.format("%.1fK", subscriberCount / 1_000.0);
        } else {
            return String.valueOf(subscriberCount);
        }
    }
}
