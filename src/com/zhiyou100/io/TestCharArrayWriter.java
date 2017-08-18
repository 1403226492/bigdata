package com.zhiyou100.io;

import java.io.CharArrayWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class TestCharArrayWriter {

	public static void main(String[] args) {
		CharArrayWriter writer = null;
		
		writer = new CharArrayWriter();
		for(char i='\u4edc';i<='\u9fa5';i++){
			writer.append(i);
		}
		try {
			writer.writeTo(new FileWriter(new File("d:\\test.bat"),true));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("Ð´³ö³É¹¦........");
	}

}
