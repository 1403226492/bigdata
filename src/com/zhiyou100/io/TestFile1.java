package com.zhiyou100.io;

import java.io.File;
import java.io.IOException;

public class TestFile1 {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws IOException {
		File file = new File("myproperties.properties");
		System.out.println(file.getAbsolutePath());

		/*
		 * ���û��ָ���ļ����̷�������ֱ��ʹ���ļ�������������File���� ��ôĬ�ϵ�user.dir��ȥ�ҡ�
		 */
		System.out.println(System.getProperty("user.dir"));

		/*
		 * /opt/vmware-tools-distrib/doc
		 */
		File file2 = new File("D:\\bigdatafiles\\docs\\20160707\\HelloWorld.java");

		System.out.println(file2.getAbsolutePath());

		System.out.println(file2.toURI());

		/*
		 * File.separtor��һ����̬����������ͬ����ϵͳ���ļ��ָ�������windows�±���Ϊ��
		 * \(��б��)��unix,linux,mac ����Ϊ/��б�ܣ�
		 */
		File file3 = new File(
				"D:" + File.separator + "bigdatafiles" + File.separator + "docs" + File.separator + "20160707" + File.separator +"20160707���ñʼ�.docx");
		
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
