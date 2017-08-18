package com.zhiyou100.io;

import java.io.ByteArrayInputStream;

public class TestByteArrayInputStream {

	public static void main(String[] args) {
		byte[] buffer = {1,2,3,4,5,6,7,8,9,0};
		ByteArrayInputStream bis = new ByteArrayInputStream(buffer);
		int readed = 0;
		while ((readed = bis.read()) != -1) {
			System.out.print(readed);
		}
	}

}
