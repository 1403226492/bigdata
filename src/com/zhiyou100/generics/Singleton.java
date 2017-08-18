package com.zhiyou100.generics;

public class Singleton<T> {
	private static Singleton instance = new Singleton();
	
	/**
	 * ˽�й��췽������֤�ù��췽��ֻ���ڵ�ǰ���б����ʣ�
	 * ��ζ�ű������û�а취ͬ��new�ķ�ʽ�������Ķ���
	 */
	private Singleton(){
	}
	
	public static Singleton getInstace(){
		return instance;
	}
	
	public void printMsg(T msg){
		System.out.println(msg);
	}
}
