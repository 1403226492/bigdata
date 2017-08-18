package com.zhiyou100.oop.privs;

public class A {
	public void publicMethod() {
		System.out.println(getClass().getName() + ":publicMethod");
	}
	protected void protectedMethod() {
		System.out.println(getClass().getName()+":protectedMethod ");
	}
	private void aPrivateMethod() {
		System.out.println(getClass().getName() + ":aPrivateMethod");
	}
	
	void defaultMethod(){
		System.out.println(getClass().getName()+":defaultMethod");
	}
	public static void main(String[] args) {
		A a = new A();
		a.aPrivateMethod();
		a.protectedMethod();
	}
}
