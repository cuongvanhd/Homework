/**
 * Copyright(C) 2015 Media Brige Company
 * DatabaseProperties.java
 */
package com.vancuong.utils;

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * @author Cuong
 *
 */
public class DatabaseProperties {

	// biến data để lưu dữ liệu đọc từ file database.properties
	static private Map<String, String> data = new HashMap<String, String>();

	static {
		Properties prop = new Properties();
		try {
			prop.load(DatabaseProperties.class.getResourceAsStream(("/database.properties")));
		} catch (IOException e) {
			e.printStackTrace();
		}

		Enumeration<String> en = (Enumeration<String>) prop.propertyNames();
		while (en.hasMoreElements()) {
			String key = (String) en.nextElement();
			data.put(key, prop.getProperty(key));
		}
	}

	/**
	 * Phương thức getData để từ file database.properties
	 *
	 * @param key
	 *            Key
	 * @return String
	 */
	static public String getData(String key) {
		String string = "";
		if (data.containsKey(key)) {
			string = data.get(key);
		}
		return string;
	}
}
