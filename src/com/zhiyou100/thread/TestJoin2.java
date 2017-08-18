package com.zhiyou100.thread;

public class TestJoin2 {
	public static void main(String[] args) {
		JoinThead joinThead = new JoinThead("�ҵ��߳�");
		joinThead.start();
		
		for (int i = 0; i < 10; i++) {
			if (i == 3) {
				try {
					joinThead.join(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println(Thread.currentThread().getName() +" print " + i);
		}
	}
}


class JoinThead extends Thread{
	private String name;
	public JoinThead(String name) {
		this.name = name;
	}
	@Override
	public void run() {
		System.out.println(name +" ����ʼִ�У�>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(name +" ��ִ����ϣ�>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
	}
}