package com.zhiyou100.oop.privs;

public class B {
	protected void bMethod() {
		System.out.println(getClass().getName()+":bMethod");
	}
	
	public static void main(String[] args) {
		A a = new A();
		a.defaultMethod();
		a.protectedMethod();
	}
}
