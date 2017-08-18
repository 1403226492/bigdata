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
		
		Thread t1 = new Thread(myRunnable,"打印线程1");
		Thread t2 = new Thread(myRunnable,"打印线程2");
		DeamonThead deamonThread = new DeamonThead();
		deamonThread.setDaemon(true);
		
		deamonThread.start();
		t1.start();
		t2.start();
		System.out.println("main线程执行完毕！");
	}
}
class DeamonThead extends Thread{
	@Override
	public void run() {
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>进入守护线程");
		for(int i=0;i<10000;i++){
			System.out.println("守护线程：" + getName() +"打印：" + i);
		}
		System.out.println("守护线程执行完毕！>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
	}
}