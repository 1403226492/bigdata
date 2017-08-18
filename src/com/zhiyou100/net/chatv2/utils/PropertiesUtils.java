package com.zhiyou100.net.chatv2.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesUtils {
	private static final Properties PROPERTIES;
	
	static{
		PROPERTIES = new Properties();
		try {
			PROPERTIES.load(new FileInputStream(new File("D:\\devtools\\bigdataworkspace\\bigdata\\accountAndNicknameMap.properties")));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static String getNicknameByAccount(String accout){
		return PROPERTIES.getProperty(accout);
	}
}
