package com.zhiyou100.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * ����ǰ��java�ļ����Ƶ�ָ���ĵط���
 * 1.Ҫ�����Ķ����ǵ�ǰjava�ļ�����java�ļ���Ϊ�����ṩ�߹�����ʹ�ã����ʹ����������
 * ���ڸ�java�ļ��Ǵ��ı��ļ��������Ȳ����ַ�����FileReader��
 * 2.�������Ϊ�ļ���ʹ�������������������ʴ��ı���ʹ���ַ�������FileWriter
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
