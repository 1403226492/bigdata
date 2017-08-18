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
			 * ��Properties���ļ�������������ȡ���ַ�ʽ�����뽫�ļ�
			 * �ŵ���Ŀ�ĸ�Ŀ¼�¡�
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
