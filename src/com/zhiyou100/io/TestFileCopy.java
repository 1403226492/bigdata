package com.zhiyou100.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 将当前的java文件复制到指定的地方：
 * 1.要操作的对象是当前java文件，该java文件作为数据提供者供程序使用，因此使用输入流；
 * 由于该java文件是纯文本文件，故优先采用字符流，FileReader；
 * 2.输出对象为文件，使用输出流，输出的内容问纯文本，使用字符流，即FileWriter
 * @author ayuw
 *
 */
public class TestFileCopy {

	public static void main(String[] args) {
		File srcFile = new File("D:/devtools/bigdataworkspace/bigdata/src/com/zhiyou100/io/TestFileCopy.java");
		File destFile = new File("d:/Ttt.java");
		if(!destFile.exists()){
			try {
				destFile.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		FileReader reader = null;
		FileWriter writer = null;
		
		try {
			reader = new FileReader(srcFile);
			writer = new FileWriter(destFile);
			char[] buffer = new char[1024];
			while(reader.read(buffer)!=-1){
				writer.write(buffer);
			}
			writer.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if(reader!=null){
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
