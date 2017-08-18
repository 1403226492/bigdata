package com.zhiyou100.desginpatterns.command;

public class Client {

	public static void main(String[] args) {
		Invoker waitress = new Invoker();
		Receiver cooker = new Receiver();
		
		MaPoToufuCommand maPoToufuCommand = new MaPoToufuCommand(cooker);
		NoodleWithNoSaltCommand noodleWithNoSaltCommand = new NoodleWithNoSaltCommand(cooker);
		waitress.setCommand(maPoToufuCommand);
		waitress.action();
		
		waitress.setCommand(noodleWithNoSaltCommand);
		waitress.action();
	}

}
