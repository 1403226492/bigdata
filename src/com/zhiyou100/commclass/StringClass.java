package com.zhiyou100.commclass;

public class StringClass {
	public static void main(String[] args) {
		String str1 = "abc";
		String str2 = "abc";
		System.out.println("str1==str2:" + (str1 == str2));
		/*
		 * 该声明方式首先在常量池中查找是否存在一个为abc的常量
		 * 如果没有，则创建。
		 * 其次在堆内存中new一个字符串对象。
		 * 最后在栈内存中创建一个str3的引用。
		 * 
		 * */
		String str3 = new String("abc");
		System.out.println("str2==str3:" + (str2 == str3));
		String str4 = "ab" +"c";//编译期就完成了常量的转换，可以理解为直接赋值为abc
		System.out.println("str1==str4:" +(str1 == str4));
		String str5 = "c";
		/*
		 * ab走的是常量池，
		 * str5是通过StingBuffer的append方法添加的，而最终
		 * 的str6是调用添加完成后的StringBuffer的toString方法生成的。
		 * */
		String str6 = "ab" + str5;
		System.out.println("str1 == str6: " + (str1 == str6));
	}
}
