package com.zhiyou100.desginpatterns.template;

public class MaleColleger extends AbstractColleger {

	@Override
	public void dressUp() {
		System.out.println("穿上衣");
		System.out.println("穿裤子");
		System.out.println("穿拖鞋");
	}

	@Override
	public void haveBreakfast() {
		System.out.println("吃个包子，带馅的！");
	}

	@Override
	public void takeBag() {
		System.out.println("直奔网吧撸两局！");
	}

}
