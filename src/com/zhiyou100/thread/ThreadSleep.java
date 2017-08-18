package com.zhiyou100.thread;

import java.util.concurrent.TimeUnit;

public class ThreadSleep {

	public static void main(String[] args) throws InterruptedException {
		SleepThread sleepThread = new SleepThread("正在睡觉的线程--");
		sleepThread.start();
		Thread.sleep(1000);
		//sleepThread.interrupt();//调用该方法，指名道姓的去打断sleepThread的执行，则sleepThread要抛出InterruptedException异常
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
			System.out.println(name +"线程睡眠过程中被打断！");
			e.printStackTrace();
		}
	}
}