package com.zhiyou100.desginpatterns.template;

public class Client {

	public static void main(String[] args) {
		AbstractColleger boy = new MaleColleger();
		boy.goToClass();
		System.out.println("=========================================");
		AbstractColleger beauty = new FemaleColleger();
		beauty.goToClass();
	}

}
