package com.zhiyou100.thread;

public class TestThreadPriority {

	public static void main(String[] args) {
		Runnable r1 = new Runnable() {
			@Override
			public void run() {
				for (int i=0;i<100;i++) {
					System.out.println(Thread.currentThread().getName() +" print :" + i);
					
				}
			}
		};
		Runnable r2 = new Runnable() {
			@Override
			public void run() {
				for (int i=0;i<100;i++) {
					System.out.println(Thread.currentThread().getName() +" print :" + i);
					
				}
			}
		};
		Thread t1 = new Thread(r1,"线程1");
		Thread t2 = new Thread(r2,"线程2");
		
		t1.setPriority(Thread.MAX_PRIORITY);
		t2.setPriority(Thread.MIN_PRIORITY);
		
		t1.start();
		t2.start();
		
		for (int i=0;i<100;i++) {
			System.out.println(Thread.currentThread().getName() +" print :" + i);
		}
	}

	
}
