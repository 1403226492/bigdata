package com.zhiyou100.commclass;

public class StringClass {
	public static void main(String[] args) {
		String str1 = "abc";
		String str2 = "abc";
		System.out.println("str1==str2:" + (str1 == str2));
		/*
		 * ��������ʽ�����ڳ������в����Ƿ����һ��Ϊabc�ĳ���
		 * ���û�У��򴴽���
		 * ����ڶ��ڴ���newһ���ַ�������
		 * �����ջ�ڴ��д���һ��str3�����á�
		 * 
		 * */
		String str3 = new String("abc");
		System.out.println("str2==str3:" + (str2 == str3));
		String str4 = "ab" +"c";//�����ھ�����˳�����ת�����������Ϊֱ�Ӹ�ֵΪabc
		System.out.println("str1==str4:" +(str1 == str4));
		String str5 = "c";
		/*
		 * ab�ߵ��ǳ����أ�
		 * str5��ͨ��StingBuffer��append������ӵģ�������
		 * ��str6�ǵ��������ɺ��StringBuffer��toString�������ɵġ�
		 * */
		String str6 = "ab" + str5;
		System.out.println("str1 == str6: " + (str1 == str6));
	}
}
