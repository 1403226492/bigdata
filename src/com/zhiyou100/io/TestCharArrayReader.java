package com.zhiyou100.io;

import java.io.CharArrayReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TestCharArrayReader {

	public static void main(String[] args) throws IOException {
		List<Character> bufferList = new ArrayList<Character>();
		for(char i=0;i<Character.MAX_VALUE;i++){
			bufferList.add(i);
		}
		
		char[] buffer = new char[bufferList.size()];
		for(int i=0;i<bufferList.size();i++){
			buffer[i] = bufferList.get(i);//×Ô¶¨²ð°ü
		}
		CharArrayReader reader = new CharArrayReader(buffer);
		int i = 0;
		while ( (i=reader.read()) != -1) {
			System.out.println((char)i);
		}
	}

}
