package com.zhiyou100.io;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * �Ӽ���ɨ����������ݣ�д�뵽ָ�����ļ��С�
 * 1.�Ӽ���ɨ�裬��ζ�ż���Ҫ�ṩ����Դ������ʹ�ã����������ʹ����������
 * 2.ɨ�������Ҫд���ļ��У����ʱ���ļ���Ϊ���ݵ�Ŀ�ĵأ�ʹ���������
 * ���������Ϊ�ı���ʹ���ַ����������ʱ����Ҫʹ�õ��ǣ�FileWriter��
 * @author ayuw
 *
 */
public class TestScanner {

	public static void main(String[] args) {
		File destFile = new File("abc.log");
		Scanner scanner = null;
		FileWriter writer = null;
		
		try {
			scanner = new Scanner(System.in);
			writer = new FileWriter(destFile,true);
			String line = null;
			while((line = scanner.nextLine()) != null){
				if("bye".equals(line)){
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
				if(scanner!=null){
					scanner.close();
				}
				if(writer!=null){
					writer.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}

}
