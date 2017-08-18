package com.zhiyou100.thread;

import java.util.concurrent.TimeUnit;

public class ThreadSleep {

	public static void main(String[] args) throws InterruptedException {
		SleepThread sleepThread = new SleepThread("����˯�����߳�--");
		sleepThread.start();
		Thread.sleep(1000);
		//sleepThread.interrupt();//���ø÷�����ָ�����յ�ȥ���sleepThread��ִ�У���sleepThreadҪ�׳�InterruptedException�쳣
	}

}

class SleepThread extends Thread {
	private String name;
	
	public SleepThread() {
	}
	public SleepThread(String name) {
		this.name = name;
	}
	
	
	@Override
	public void run() {
		try {
			for (int i = 0; i < 100; i++) {
				//Thread.sleep(100);
				TimeUnit.MILLISECONDS.sleep(100);
				System.out.println(name + "print : " + i);
			}
		} catch (InterruptedException e) {
			System.out.println(name +"�߳�˯�߹����б���ϣ�");
			e.printStackTrace();
		}
	}
}