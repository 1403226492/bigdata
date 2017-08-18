package com.zhiyou100.desginpatterns.command;

/**
 * 请求调用者，必须要知道需要调用哪些请求，即
 * 该类中必须有请求（Command）的引用
 * @author ayuw
 *
 */
public class Invoker {
	
	/**
	 * 面向接口编程。如果该地方选择具体的命令如MaPoToufuCommand等，
	 * 那么就只能处理麻婆豆腐的订单了。所以这里采用抽象的命令（订单).
	 */
	private ICommand command;
	
	public Invoker() {
	}
	public Invoker(ICommand command) {
		this.command = command;
	}
	public ICommand getCommand() {
		return command;
	}
	public void setCommand(ICommand command) {
		this.command = command;
	}
	
	/**
	 * 服务做饭的方法，具体的做饭是由一个一个具体的命令来确定的，
	 * 所以，调用者（服务员）只负责传递命令单（菜单），具体要做的
	 * 内容由我们传入的具体命令去处理。
	 */
	public void action(){
		System.out.println("服务员拿到命令单。。。");
		command.execute();
	}
}
