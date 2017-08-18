package com.zhiyou100.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

public class TestFileChannel {

	public static void main(String[] args) {
		File srcFile = new File("D:\\devtools\\bigdataworkspace\\bigdata\\src\\com\\zhiyou100\\io\\TestFileChannel.java");
		File destFile = new File("d:\\TestChannel.java");
		
		FileChannel fcin = null;
		FileChannel fcout = null;
		
		try {
			fcin = new FileInputStream(srcFile).getChannel();
			fcout = new FileOutputStream(destFile).getChannel();
			fcin.transferTo(0, fcin.size(), fcout);
			System.out.println("文件复制成功！");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if(fcout != null){
					fcout.close();
				}
				if(fcin != null){
					fcin.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
