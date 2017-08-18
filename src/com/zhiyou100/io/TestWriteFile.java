package com.zhiyou100.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 接受从键盘输入的内容，保存到指定的文件中。
 * 1.要接受从键盘输入的内容，程序要使用键盘输入的内容，这个时候键盘对我们的程序来说是一个输入流；最终要处理的
 * 是一个一个的字符，需要使用字符流：BufferedReader
 * 2.程序要将接受到的键盘输入的内容写到文件中，这个时候文件对程序来说要使用程序的数据，需要使用输出流；
 * 	由于键盘输入的内容都是字符串包含汉字，要使用字符流，这个时候可以确认输出流使用：FileWriter
 * @author ayuw
 *
 */
public class TestWriteFile {

	public static void main(String[] args) {
		File destFile = new File("test.log");
		
		BufferedReader reader = null;
		FileWriter writer = null;
		
		try {
			/*
			 * BufferedReader接受一个Reader类型的参数，而System.in即键盘是一个InputStream
			 * 所有需要将InputStream转换为Reader，方式是转换流：InputStreamReader
			 */
			reader = new BufferedReader(new InputStreamReader(System.in));
			writer = new FileWriter(destFile,true);
			
			String line = null;
			
			System.out.println("请输入内容，bye为退出：");
			while((line = reader.readLine()) != null){
				System.out.println(">>>>>>>请输入内容(bye为退出)：");
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
