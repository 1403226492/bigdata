package com.zhiyou100.reflection.dynamicproxy;

public class Wolf implements IAnimal {

	@Override
	public void eat() {
		System.out.println("����ǧ��ҲҪ��ʺ��");
	}

	@Override
	public void cry() {
		System.out.println("��������������������������������");
	}

}
