package com.zhiyou100.oop.innerclass;

import java.util.Date;

import com.zhiyou100.oop.interfaces.Flyable;

public class Outer {
	
	/*
	 * 定义一个静态常量
	 */
	private static final int OUTER_INT = 10;
	
	/*
	 *定义一个整型实例变量
	 */
	private int outerAge = 30;
	
	public static class StaticInnerClass{
		public void staticClassMethod(){
			System.out.println("staticClassMethod");
		}
	}
	
	public class InstanceInnerClass{
		private int outerAge = 30;
		public void InstanceClassMethod(){
			System.out.println(Outer.OUTER_INT);
			System.out.println(Outer.this.outerAge);
			System.out.println("InstanceClassMethod");
		}
	}
	
	public void testLocalInnerClass(){
		final int localInt = 3;
		 class LocalInnerClass {
			public void localInnerClassMethod(){
				System.out.println("localInnerClassMethod:" + localInt);
			}
		}
		 LocalInnerClass local = new LocalInnerClass();
		 local.localInnerClassMethod();
	}
	
	public Flyable testLocalInnerClass3(){
		final int weight = 30;
		class BirdMan implements Flyable{
			@Override
			public void fly() {
				System.out.println("BirdMan:" + weight);
			}
		}
		return new BirdMan();
	}
	
	
	public void testLocalInnerClass2(){
		final int localInt = 3;
		 class LocalInnerClass {
			public void localInnerClassMethod(){
				System.out.println("localInnerClassMethod:" + localInt);
			}
		}
		 LocalInnerClass local = new LocalInnerClass();
		 local.localInnerClassMethod();
	}
	
	@SuppressWarnings("deprecation")
	public Flyable testAnonymousInnerClasss(){
		final int localInt = 3;
		
		Date date = new Date(){
			@Override
			public String toLocaleString() {
				return "这是匿名内部类的测试";
			}
		};
		System.out.println(date.toLocaleString());
		
		return new Flyable(){
			@Override
			public void fly() {
				System.out.println("anonymousInnerClasss:" + localInt);
			}
			
		};
	}
	/**
	 * 外部类的静态方法
	 */
	public static void outerStaticMethod(){
		System.out.println("outerStaticMethod");
	}
	/**
	 * 外部类的实例方法
	 */
	public void outerInstanceMethod(){
		System.out.println("outerInstanceMethod");
	}
}

