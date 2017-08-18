package com.zhiyou100.desginpatterns.command;


/**
 * ���������������Ϊ��һ������Ĳ˵���
 * @author ayuw
 *
 */
public class MaPoToufuCommand implements ICommand {
	
	/**
	 * �˵���ֻд����ʲô����ô������������ִ���ߣ���ʦ������ɡ���
	 * ÿһ������˵�����Ҫ������ʦ����ɡ�����Ҫ��һ����ʦ�����ԣ��ۺϣ���
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
	 * �������Ҫ�������顣Ҳ���Ǿ������Ŷ�����ô���ɳ�ʦȷ����
	 * ���������ִ�з������õ���ִ���ߣ���ʦ���ľ��巽����
	 */
	@Override
	public void execute() {
		/*
		 * ��ʦ�����Ŷ���
		 */
		receiver.cooking("���Ŷ�����Ҫ������");
	}

}
