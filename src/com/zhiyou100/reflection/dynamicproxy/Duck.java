package com.zhiyou100.reflection.dynamicproxy;

public class Duck implements IFlyable {

	@Override
	public void fly() {
		System.out.println("我是一个鸭子，看我给你飞！");
	}

}
