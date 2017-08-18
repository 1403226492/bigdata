package com.zhiyou100.desginpatterns.command;

/**
 * ��������ߣ�����Ҫ֪����Ҫ������Щ���󣬼�
 * �����б���������Command��������
 * @author ayuw
 *
 */
public class Invoker {
	
	/**
	 * ����ӿڱ�̡�����õط�ѡ������������MaPoToufuCommand�ȣ�
	 * ��ô��ֻ�ܴ������Ŷ����Ķ����ˡ�����������ó�����������).
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
	 * ���������ķ������������������һ��һ�������������ȷ���ģ�
	 * ���ԣ������ߣ�����Ա��ֻ���𴫵�������˵���������Ҫ����
	 * ���������Ǵ���ľ�������ȥ����
	 */
	public void action(){
		System.out.println("����Ա�õ����������");
		command.execute();
	}
}
