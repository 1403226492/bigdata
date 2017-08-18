package com.zhiyou100.io.util;

import java.util.List;
import java.io.File;

public class Main {

	public static void main(String[] args) {
		//List<File> pdfFiles = FileUtils.listFilesByType(new File("D:\\software"), ".pdf");
		List<File> javaFiles = FileUtils.listFilesByType(new File("D:\\bigdatafiles"), ".java"); 
		//pdfFiles.addAll(wordFiles);
		FileUtils.zipFiles(new File("d:\\myzip.zip"),javaFiles);
	}

}
