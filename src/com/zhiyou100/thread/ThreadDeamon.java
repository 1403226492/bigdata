package com.zhiyou100.thread;

public class ThreadDeamon {

	public static void main(String[] args) {
		Runnable myRunnable = new Runnable() {
			
			@Override
			public void run() {
				for (int i=0;i<100;i++) {
					System.out.println(Thread.currentThread().getName() +" print: " + i);
				}
			}
		};
		
		Thread t1 = new Thread(myRunnable,"��ӡ�߳�1");
		Thread t2 = new Thread(myRunnable,"��ӡ�߳�2");
		DeamonThead deamonThread = new DeamonThead();
		deamonThread.setDaemon(true);
		
		deamonThread.start();
		t1.start();
		t2.start();
		System.out.println("main�߳�ִ����ϣ�");
	}
}
class DeamonThead extends Thread{
	@Override
	public void run() {
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>�����ػ��߳�");
		for(int i=0;i<10000;i++){
			System.out.println("�ػ��̣߳�" + getName() +"��ӡ��" + i);
		}
		System.out.println("�ػ��߳�ִ����ϣ�>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
	}
}