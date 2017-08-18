package com.zhiyou100.thread;

public class TestYield {
	public static void main(String[] args) {
		Runnable myRunnable = new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 100; i++) {
					if(i==50){
						Thread.yield();
						try {
							Thread.sleep(200);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					System.out.println(Thread.currentThread().getName()+" print " + i);
					
				}
			}
		};
		
		new Thread(myRunnable,"我的线程").start();
		
		
		for (int i = 0; i < 100; i++) {
			System.out.println(Thread.currentThread().getName()+" print " + i);
		}
	}
	
	
}

