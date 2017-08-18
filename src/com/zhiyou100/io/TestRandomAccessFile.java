package com.zhiyou100.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;

public class TestRandomAccessFile {

	public static void main(String[] args) {
		File targetFile = new File("hanyubo.txt");
		//replace(2, "��", targetFile);
		//append("��Ӿ�", targetFile);
		insert(16, "��", targetFile);
	}

	
	private static void replace(long positin,String content,File file){
		RandomAccessFile raf = null;
		
		try {
			raf = new RandomAccessFile(file, "rw");
			raf.seek(positin);//���ļ�ָ���ƶ���Ҫ�������ݵ�λ��
			raf.write((content+"\r\n").getBytes());
			System.out.println("д���ݣ�" + content +" �ɹ���");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(raf != null ){
				try {
					raf.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public static void append(String content,File file){
		RandomAccessFile raf = null;
		
		try {
			raf = new RandomAccessFile(file, "rw");
			raf.seek(raf.length());
			raf.write((content+"\r\n").getBytes());
			System.out.println("׷�����ݣ�" + content +" �ɹ���");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(raf != null ){
				try {
					raf.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
	
	private static void insert(long pos,String content,File file){
		RandomAccessFile raf = null;
		File temp = null;
		FileOutputStream fos = null;
		FileInputStream fis = null;
		byte[] buffer = new byte[1024];
		
	    try {
			temp = File.createTempFile("temp", null);
			temp.deleteOnExit();//������رյ�ʱ��ͻ��Զ�ɾ��
			fos = new FileOutputStream(temp);
			fis = new FileInputStream(temp);
			
			raf = new RandomAccessFile(file, "rw");
			
			raf.seek(pos);
			
			while((raf.read(buffer)) != -1){
				fos.write(buffer);//���ļ����ص�������ʱ�洢����ʱ�ļ���
			} 
			fos.flush();
			
			raf.seek(pos);
			
			raf.write(content.getBytes());
			
			while((fis.read(buffer)) != -1) {
				raf.write(buffer);
			}
			
			System.out.println("�������ݣ�" + content + "���ɹ���");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if(fos != null){
					fos.close();
				}
				if(fis != null){
					fis.close();
				}
				if(raf != null){
					raf.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
