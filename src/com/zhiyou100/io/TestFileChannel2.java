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
			 * ����һ��1024�ֽڵĻ�����
			 */
			ByteBuffer buffer = ByteBuffer.allocate(1024);
			
			while(fcin.read(buffer) != -1){//buffer��������Ҫ�����ͨ������������
				buffer.flip();//����flip������ʹ�������ɶ�����˼�ǽ�position��0����limit����Ϊ��ǰ��position
				fcout.write(buffer);//д��֮��position����limit
				buffer.clear();//��position����Ϊ0��limit����Ϊcapacity
			}
			
			System.out.println("���ݸ�����ϣ�");
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
