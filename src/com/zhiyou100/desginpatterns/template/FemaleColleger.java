package com.zhiyou100.desginpatterns.template;

public class FemaleColleger extends AbstractColleger{

	@Override
	public void dressUp() {
		System.out.println("������");
		System.out.println("��ȹ��");
		System.out.println("����Ь");
		System.out.println("��ü");
		System.out.println("...");
		
	}

	@Override
	public void haveBreakfast() {
		System.out.println("���������ۣ���Ҫ��������Ҫ�ۣ�");
		
	}

	@Override
	public void takeBag() {
		System.out.println("����Ǯ������������ױ��ȥ1204�����ܣ�");
	}

}
