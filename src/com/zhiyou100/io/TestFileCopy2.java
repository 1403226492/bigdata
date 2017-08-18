package com.zhiyou100.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class TestFileCopy2 {

	public static void main(String[] args) {
		File srcFile = new File("D:/devtools/bigdataworkspace/bigdata/src/com/zhiyou100/io/TestFileCopy2.java");
		File destFile = new File("d:/Test.java");
		if(!destFile.exists()){
			try {
				destFile.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		FileInputStream fis = null;
		FileOutputStream fos = null;
		
		try {
			fis = new FileInputStream(srcFile);
			fos = new FileOutputStream(destFile);
			int readed = 0;
			while((readed = fis.read() ) != -1){
				fos.write(readed);
			}
			fos.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if(fis!=null){
					fis.close();
				}
				if(fos != null){
					fos.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
