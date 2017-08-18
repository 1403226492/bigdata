package com.zhiyou100.exceptions;

public class TestDebug {
	public static void main(String[] args) {
		String username = "Âí¼Ó¾ô";
		char charAt = username.charAt(2);
		int add1 = 10;
		int add2 = 100;
		int sum = add1 + add2;
		System.out.println(charAt);
		System.out.println(sum);
		
		for(int i=0;i<100;i++){
			System.out.println(i);
		}
	}
}
