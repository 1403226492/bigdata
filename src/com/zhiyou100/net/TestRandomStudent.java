package com.zhiyou100.net;

import java.util.Random;

public class TestRandomStudent {
	private static final Random random = new Random();
	
	private static final String[] STUDENT_SEEDS = 
			("�¿���  ����ɭ  ������  ��־��   " +
			" ���� ������ ���� ��ȫ�� ��Դ ������ " +
			" ���� ɣ��˧  ���� �κ��� �޾��� ���� ���ִ� " +
			" ������ ������ ������  ���̿� ������ ������ ������ " +
			" ��˫�� ��˧ ������  ������ ������ ��Ԫ�� ��� �˻�  ����").split("\\s+");
	
	
	public static void main(String[] args) {
		for (int i = 0; i < 5; i++) {
			System.out.println(getRandomStudent());
		}
	}
	
	private static String getRandomStudent(){
		String ret = null;
		ret = STUDENT_SEEDS[random.nextInt(STUDENT_SEEDS.length)];
		return ret;
	}
}
