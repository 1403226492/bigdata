package com.zhiyou100.desginpatterns.command;


/**
 * 具体的命令。可以理解为是一个具体的菜单。
 * @author ayuw
 *
 */
public class MaPoToufuCommand implements ICommand {
	
	/**
	 * 菜单上只写了做什么，怎么做必须由请求执行者（厨师）来完成。即
	 * 每一个命令（菜单）都要交给厨师来完成。所以要有一个厨师的属性（聚合）；
	 */
	private Receiver receiver;
	
	public MaPoToufuCommand() {
	}
	public MaPoToufuCommand( Receiver receiver) {
		this.receiver = receiver;
	}
	public Receiver getReceiver() {
		return receiver;
	}
	public void setReceiver(Receiver receiver) {
		this.receiver = receiver;
	}
	
	/**
	 * 命令具体要做的事情。也就是具体麻婆豆腐怎么做由厨师确定。
	 * 所有命令的执行方法调用的是执行者（厨师）的具体方法。
	 */
	@Override
	public void execute() {
		/*
		 * 厨师做麻婆豆腐
		 */
		receiver.cooking("麻婆豆腐不要豆腐！");
	}

}
