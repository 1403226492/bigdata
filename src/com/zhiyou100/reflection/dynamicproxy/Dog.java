package com.zhiyou100.reflection.dynamicproxy;

public class Dog implements IAnimal{

	@Override
	public void eat() {
		System.out.println("����ǧ���ʺ��");
	}

	@Override
	public void cry() {
		System.out.println("��������������������");
	}

}
