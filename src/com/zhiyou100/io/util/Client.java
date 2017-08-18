package com.zhiyou100.io.util;

import java.io.File;
import java.util.List;

public class Client {

	public static void main(String[] args) {
//		testListFile();
		//testCreateFile();
		FileUtils.deleteFiles(new File("d:\\�����ݲ���"));
//		FileUtils.renameFiles(new File("d:\\�����ݲ���"), ".txt", ".bak");
		
	}

	public static void testCreateFile() {
		long name = 0L;
		for(int i=0;i<1000;i++){
			name = System.currentTimeMillis();
			FileUtils.createFile(new File("d:\\�����ݲ���"), name +".txt");
			System.out.println("�������ļ���" + name +".txt");
			try {
				Thread.sleep(30);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static void testListFile() {
		File directory = new File("D:\\bigdatafiles");
		List<File> docFiles = FileUtils.listFilesByType(directory, "docx");
		for(File f: docFiles){
			System.out.println(f.getName());
		}
	}

}
