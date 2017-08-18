package com.zhiyou100.collections.oldcollection;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Properties;

public class TestProperties {

	public static void main(String[] args) {
		Properties properties = new Properties();
		try {
			/*
			 * 将Properties和文件关联起来，采取这种方式，必须将文件
			 * 放到项目的根目录下。
			 */
			properties.load(new FileInputStream(new File("myproperties.properties")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Enumeration<?>  enumer = properties.propertyNames();
		String string = null;
		while (enumer.hasMoreElements()) {
			 string =  (String) enumer.nextElement();
			System.out.println(string +"=" + properties.getProperty(string));
		}
		
		System.out.println("=============================================");
		
		properties.list(System.out);
	}

}
