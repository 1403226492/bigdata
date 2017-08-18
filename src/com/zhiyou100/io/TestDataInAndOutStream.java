package com.zhiyou100.io;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class TestDataInAndOutStream {

	public static void main(String[] args) {
		
		DataInputStream dis = null;
		DataOutputStream dos = null;
		
		try {
			dis = new DataInputStream(System.in);
			dos = new DataOutputStream(new FileOutputStream(new File("d:\\test.txt"),true));
			
			String line = dis.readLine();
			while(line != null){
				line = dis.readLine();
				if("bye".equals(line.trim())){
					break;
				}
				dos.write(line.getBytes());;
				dos.write("\r\n".getBytes());
			}
			dos.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if(dos != null){
					dos.close();
				}
				if(dis != null){
					dis.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
