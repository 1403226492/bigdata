package com.zhiyou100.oop.interfaces;

public class Client {
	public static void main(String[] args) {
		Flyable duck = new Duck();
		duck.fly();
		Client client = new Client();
		client.testFlyMethod(new Penguin());
	}
	
	/**
	 * ���Է���ķ���
	 * ����ӿڱ��
	 * LSP��Liskvo substitution Princple���������ܹ���ȫ�滻����
	 * ��ԭ�����ҪĿ�������������û���˵����������������Ժͷ�����
	 */
	public void testFlyMethod(Flyable obj){
		obj.fly();
	}
}
