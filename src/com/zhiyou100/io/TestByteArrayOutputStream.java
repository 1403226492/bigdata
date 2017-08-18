package com.zhiyou100.io;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class TestByteArrayOutputStream {

	public static void main(String[] args) {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		
		for(byte i=0;i<Byte.MAX_VALUE;i++){
			baos.write(i);
		}
	
		try {
			baos.writeTo(System.out);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
