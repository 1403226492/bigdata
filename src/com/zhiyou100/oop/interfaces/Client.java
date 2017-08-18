package com.zhiyou100.oop.interfaces;

public class Client {
	public static void main(String[] args) {
		Flyable duck = new Duck();
		duck.fly();
		Client client = new Client();
		client.testFlyMethod(new Penguin());
	}
	
	/**
	 * 测试飞翔的方法
	 * 面向接口编程
	 * LSP（Liskvo substitution Princple），父类能够完全替换子类
	 * 该原则的主要目的是让我们少用或者说不用子类的特有属性和方法。
	 */
	public void testFlyMethod(Flyable obj){
		obj.fly();
	}
}
