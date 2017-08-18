package com.zhiyou100.desginpatterns.template;

public class FemaleColleger extends AbstractColleger{

	@Override
	public void dressUp() {
		System.out.println("穿上衣");
		System.out.println("穿裙子");
		System.out.println("穿凉鞋");
		System.out.println("画眉");
		System.out.println("...");
		
	}

	@Override
	public void haveBreakfast() {
		System.out.println("来晚酸辣粉，不要辣椒，不要粉！");
		
	}

	@Override
	public void takeBag() {
		System.out.println("带着钱包，背包，化妆包去1204上马哲！");
	}

}
