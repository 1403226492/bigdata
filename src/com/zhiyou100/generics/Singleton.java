package com.zhiyou100.generics;

public class Singleton<T> {
	private static Singleton instance = new Singleton();
	
	/**
	 * 私有构造方法，保证该构造方法只能在当前类中被访问，
	 * 意味着别的类中没有办法同过new的方式构造该类的对象。
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
