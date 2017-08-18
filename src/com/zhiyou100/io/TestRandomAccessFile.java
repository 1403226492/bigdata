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
		//replace(2, "玉", targetFile);
		//append("马加爵", targetFile);
		insert(16, "疼", targetFile);
	}

	
	private static void replace(long positin,String content,File file){
		RandomAccessFile raf = null;
		
		try {
			raf = new RandomAccessFile(file, "rw");
			raf.seek(positin);//将文件指针移动到要插入内容的位置
			raf.write((content+"\r\n").getBytes());
			System.out.println("写数据：" + content +" 成功！");
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
			System.out.println("追加数据：" + content +" 成功！");
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
			temp.deleteOnExit();//虚拟机关闭的时候就会自动删除
			fos = new FileOutputStream(temp);
			fis = new FileInputStream(temp);
			
			raf = new RandomAccessFile(file, "rw");
			
			raf.seek(pos);
			
			while((raf.read(buffer)) != -1){
				fos.write(buffer);//将文件后半截的数据临时存储到临时文件中
			} 
			fos.flush();
			
			raf.seek(pos);
			
			raf.write(content.getBytes());
			
			while((fis.read(buffer)) != -1) {
				raf.write(buffer);
			}
			
			System.out.println("插入内容：" + content + "，成功！");
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
