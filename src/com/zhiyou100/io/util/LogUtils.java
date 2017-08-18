package com.zhiyou100.io.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class LogUtils {
	public static void writeLog(String logName,String content){
		File logFile = new File(logName);
		FileOutputStream fos = null;
		BufferedWriter bw = null;
		try {
			fos = new FileOutputStream(logFile,true);
			bw = new BufferedWriter(new OutputStreamWriter(fos));
			bw.write(content);
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
		
		System.out.println("–¥»Î"+ content +"≥…π¶°£");
	}
}
