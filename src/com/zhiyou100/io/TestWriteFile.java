package com.zhiyou100.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * ���ܴӼ�����������ݣ����浽ָ�����ļ��С�
 * 1.Ҫ���ܴӼ�����������ݣ�����Ҫʹ�ü�����������ݣ����ʱ����̶����ǵĳ�����˵��һ��������������Ҫ�����
 * ��һ��һ�����ַ�����Ҫʹ���ַ�����BufferedReader
 * 2.����Ҫ�����ܵ��ļ������������д���ļ��У����ʱ���ļ��Գ�����˵Ҫʹ�ó�������ݣ���Ҫʹ���������
 * 	���ڼ�����������ݶ����ַ����������֣�Ҫʹ���ַ��������ʱ�����ȷ�������ʹ�ã�FileWriter
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
			 * BufferedReader����һ��Reader���͵Ĳ�������System.in��������һ��InputStream
			 * ������Ҫ��InputStreamת��ΪReader����ʽ��ת������InputStreamReader
			 */
			reader = new BufferedReader(new InputStreamReader(System.in));
			writer = new FileWriter(destFile,true);
			
			String line = null;
			
			System.out.println("���������ݣ�byeΪ�˳���");
			while((line = reader.readLine()) != null){
				System.out.println(">>>>>>>����������(byeΪ�˳�)��");
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
