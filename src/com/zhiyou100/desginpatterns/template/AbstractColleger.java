package com.zhiyou100.desginpatterns.template;

public abstract class AbstractColleger {
	
	public void goToClass(){
		dressUp();
		haveBreakfast();
		takeBag();
	}
	public abstract void dressUp();
	public abstract void haveBreakfast();
	public abstract void takeBag();
}
