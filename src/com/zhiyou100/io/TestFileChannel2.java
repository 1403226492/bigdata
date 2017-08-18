package com.zhiyou100.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class TestFileChannel2 {

	public static void main(String[] args) {
		File srcFile = new File("D:\\devtools\\bigdataworkspace\\bigdata\\src\\com\\zhiyou100\\io\\TestFileChannel2.java");
		File destFile = new File("d:\\TestChannel.java");
		
		FileChannel fcin = null;
		FileChannel fcout = null;
		
		try {
			fcin = new FileInputStream(srcFile).getChannel();
			fcout = new FileOutputStream(destFile).getChannel();
			
			/*
			 * 分配一个1024字节的缓冲区
			 */
			ByteBuffer buffer = ByteBuffer.allocate(1024);
			
			while(fcin.read(buffer) != -1){//buffer已满，需要往输出通道中输送数据
				buffer.flip();//调用flip方法，使缓冲区可读，意思是将position归0，将limit设置为当前的position
				fcout.write(buffer);//写完之后position等于limit
				buffer.clear();//将position设置为0，limit设置为capacity
			}
			
			System.out.println("数据复制完毕！");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if(fcout != null && fcout.isOpen()){
					fcout.close();
				}
				if(fcin != null && fcin.isOpen()){
					fcin.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
