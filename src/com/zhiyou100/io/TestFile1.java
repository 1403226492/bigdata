package com.zhiyou100.io;

import java.io.File;
import java.io.IOException;

public class TestFile1 {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws IOException {
		File file = new File("myproperties.properties");
		System.out.println(file.getAbsolutePath());

		/*
		 * 如果没有指定文件的盘符，而是直接使用文件的名称来定义File对象， 那么默认到user.dir下去找。
		 */
		System.out.println(System.getProperty("user.dir"));

		/*
		 * /opt/vmware-tools-distrib/doc
		 */
		File file2 = new File("D:\\bigdatafiles\\docs\\20160707\\HelloWorld.java");

		System.out.println(file2.getAbsolutePath());

		System.out.println(file2.toURI());

		/*
		 * File.separtor是一个静态常量，代表不同操作系统的文件分隔符，在windows下表现为，
		 * \(反斜杠)，unix,linux,mac 表现为/（斜杠）
		 */
		File file3 = new File(
				"D:" + File.separator + "bigdatafiles" + File.separator + "docs" + File.separator + "20160707" + File.separator +"20160707随堂笔记.docx");
		
		System.out.println(file3.toURL());
		System.out.println(file3.getAbsolutePath());
		
		
		String string = Thread.currentThread().getContextClassLoader().getResource(".").getPath();
		System.out.println(string);
		
		TestFile1 testFile1 = new TestFile1();
		
		testFile1.getPath();
		
	}
	
	public void getPath(){
		System.out.println(this.getClass().getClassLoader().getResource("."));
	}

}
