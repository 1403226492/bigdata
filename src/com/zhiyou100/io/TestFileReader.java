package com.zhiyou100.io;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * ����java�ļ���ȡ������̨չʾ��
 * 
 * @author ayuw
 *
 */
public class TestFileReader {

	public static void main(String[] args) {
		//testReaderNoBuffer();
		File javaFile = new File(
				"D:\\devtools\\bigdataworkspace\\bigdata\\src\\com\\zhiyou100\\io\\TestFileReader.java");
		FileReader reader = null;
		PrintWriter writer = null;
		
		try {
			reader = new FileReader(javaFile);
			writer = new PrintWriter(System.out);
			char[] buffer = new char[64];
			while ( reader.read(buffer) != -1) {
				writer.write(buffer);
			} 
			writer.flush();//����û�д��ڴ���д��������ˢ�³�ȥ
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				reader.close();
				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void testReaderNoBuffer() {
		File javaFile = new File(
				"D:\\devtools\\bigdataworkspace\\bigdata\\src\\com\\zhiyou100\\io\\TestFileReader.java");
		FileReader reader = null;
		PrintWriter writer = null;
		
		try {
			reader = new FileReader(javaFile);
			writer = new PrintWriter(System.out);
			int readed = 0;
			while ((readed = reader.read()) != -1) {
				writer.write(readed);
			} 
			writer.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				reader.close();
				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
