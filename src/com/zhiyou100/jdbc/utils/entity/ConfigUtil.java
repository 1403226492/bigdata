package com.zhiyou100.jdbc.utils.entity;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigUtil {
	private static final ConfigUtil instance = new ConfigUtil();
	private Properties properties = new Properties();

	private ConfigUtil() {

	}

	{
		try {
			properties.load(new FileInputStream(new File("D:/devtools/bigdataworkspace/bigdata/jdbc.properties")));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static ConfigUtil getInstance() {
		return instance;
	}

	public DBEntity getEntity(String type) {
		DBEntity ret = null;
		if ("mysql".equals(type)) {
			ret = new DBEntity(properties.getProperty("mysql.url"), properties.getProperty("mysql.user"),
					properties.getProperty("mysql.password"), properties.getProperty("mysql.driver"));
		} else if ("oracle".equals(type)) {
			ret = new DBEntity(properties.getProperty("oracle.url"), properties.getProperty("oracle.user"),
					properties.getProperty("oracle.password"), properties.getProperty("oracle.driver"));
		}
		return ret;
	}
}
