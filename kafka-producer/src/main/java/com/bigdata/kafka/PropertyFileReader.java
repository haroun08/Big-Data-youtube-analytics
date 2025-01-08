package com.bigdata.kafka;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileReader {
	private Properties properties;

	public PropertyFileReader(String filePath) throws IOException {
		properties = new Properties();
		try (FileInputStream fileInputStream = new FileInputStream(filePath)) {
			properties.load(fileInputStream);
		}
	}

	public String getProperty(String key) {
		return properties.getProperty(key);
	}

	public int getIntProperty(String key) {
		return Integer.parseInt(properties.getProperty(key));
	}
}