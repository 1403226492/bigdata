package com.zhiyou100.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class TestWriterFile2 {

	public static void main(String[] args) {
		File destFile = new File("test3.log");
		BufferedReader reader = null;
		PrintWriter writer = null;
		
		try {
			reader = new BufferedReader(new InputStreamReader(System.in));
			writer = new PrintWriter(new FileWriter(destFile), true);
			
			
			String line = null;
			while((line = reader.readLine()) != null){
				if("bye".equals(line.trim())){
					break;
				}
				writer.println(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if(reader != null){
					reader.close();
				}
				if(writer != null){
					writer.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 处理键盘的输入输出比较标准的方式
	 */
	public static void testWriteByBufferedWriter() {
		File destFile = new File("test2.log");
		
		BufferedReader reader = null;
		BufferedWriter writer = null;
		
		try {
			reader = new BufferedReader(new InputStreamReader(System.in));
			writer = new BufferedWriter(new FileWriter(destFile,true));
			
			String line = null;
			while((line = reader.readLine()) != null){
				if("bye".equals(line.trim())){
					break;
				}
				writer.write(line);
				writer.write("\r\n");
			}
			writer.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if(reader != null){
					reader.close();
				}
				if(writer != null){
					writer.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
