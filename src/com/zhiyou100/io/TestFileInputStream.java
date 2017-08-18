package com.zhiyou100.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * ����java�ļ����������̨���������ǵ����ԭ��Ҫ�����Ķ������ļ�����ǰjava�ļ������ļ�����Ϊ����
 * ���ṩ��Ϊ�����������Ҫѡ�������������ļ��Ǵ��ı��ļ�������ѡ���ַ�����FileReader����������������
 * ��������Ҫ�У�����ѡ��FileInputStream��Ϊ��������
 * 
 * ����Ҫʵ�ֵ�Ч���ǽ���java�ļ������ݣ����д�ӡ������̨��Ҫ�����Ķ����ǿ���̨���Գ�����˵��������Ϊ�����ṩ�ߣ�
 * ���䵽����̨������̨��ʾ������ʹ�������������������ѡ�����FileReader����ô��ӡ������̨����ѡ��PrintWriter��
 * �����ʹ��PrintWriter
 * 
 * @author ayuw
 *
 */
public class TestFileInputStream {

	public static void main(String[] args) {
		// testReadFile1();
		File javaFile = new File(
				"D:\\devtools\\bigdataworkspace\\bigdata\\src\\com\\zhiyou100\\io\\TestFileInputStream.java");

		FileInputStream fis = null;
		PrintWriter writer = null;

		try {
			fis = new FileInputStream(javaFile);
			writer = new PrintWriter(System.out);
			byte[] buffer = new byte[1024];
			while (fis.read(buffer) != -1) {
				writer.write(new String(buffer));
			}
			writer.flush();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				fis.close();
				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void testReadFile1() {
		File javaFile = new File(
				"D:\\devtools\\bigdataworkspace\\bigdata\\src\\com\\zhiyou100\\io\\TestFileInputStream.java");

		FileInputStream fis = null;
		PrintWriter writer = null;

		try {
			fis = new FileInputStream(javaFile);
			writer = new PrintWriter(System.out);
			int readed = 0;
			while ((readed = fis.read()) != -1) {
				writer.write(readed);
			}
			writer.flush();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				fis.close();
				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
