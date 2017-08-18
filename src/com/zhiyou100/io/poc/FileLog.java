package com.zhiyou100.io.poc;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class FileLog {

	public static void main(String[] args) {
		//testWriteLog();
		testReadFile();
	}

	public static void testReadFile() {
		File logFile = new File("log.log");
		FileInputStream fis = null;
		BufferedReader br = null;
		
		try {
			fis = new FileInputStream(logFile);
			br = new BufferedReader(new InputStreamReader(fis));
			String line = null;
			while ((line = br.readLine()) != null) {
				System.out.println(line);
			} 
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void testWriteLog() {
		File logFile = new File("log.log");
		FileOutputStream fos = null;
		BufferedWriter bw = null;
		try {
			fos = new FileOutputStream(logFile,true);
			bw = new BufferedWriter(new OutputStreamWriter(fos));
			String record = System.currentTimeMillis()+"," + "srcName" +"," +"destName";
			bw.write(record);
			bw.newLine();
			bw.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				fos.close();
				bw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("–¥»Î≥…π¶°£");
	}

}
