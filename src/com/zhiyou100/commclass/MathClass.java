package com.zhiyou100.commclass;

public class MathClass {

	public static void main(String[] args) {
		System.out.println(Math.E);
		System.out.println(Math.copySign(-123.0, 1));
		
		System.out.println("Math.floor������" + Math.floor(120.12));
		System.out.println("Math.floor������" + Math.floor(-120.12));
		
		System.out.println("Math.ceil������" + Math.ceil(120.12));
		System.out.println("Math.ceil������" + Math.ceil(-120.12));
		
		System.out.println("Math.round������С��С��0.5����" + Math.round(120.12));
		System.out.println("Math.round����(С��С��0.5����" + Math.round(-120.12));
		
		System.out.println("Math.round������С������0.5����" + Math.round(120.52));
		System.out.println("Math.round������С������0.5����" + Math.round(-120.52));
		System.out.println(Math.rint(123.567));
		
		System.out.println("Integer.MAX_VALUE = " +Integer.MAX_VALUE);
		System.out.println("Integer.MIN_VALUE = " +Integer.MIN_VALUE);
	}
}
