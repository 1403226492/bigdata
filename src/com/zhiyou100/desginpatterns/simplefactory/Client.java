package com.zhiyou100.desginpatterns.simplefactory;

public class Client {

	public static void main(String[] args) {
		Human black = HumanFactory.createHuman("B");
		black.marry();
		
		Human yellow = HumanFactory.createHuman2("com.zhiyou100.desginpatterns.simplefactory.YellowPerson");
		yellow.marry();
	}

}
