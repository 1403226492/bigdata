package com.zhiyou100.thread;

public class TestJoin {
	public static void main(String[] args) {
		Runnable myRunnable = new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 100; i++) {
					System.out.println(Thread.currentThread().getName()+" print " + i);
					
				}
			}
		};
		
		Thread t1 = new Thread(myRunnable,"我的线程");
		t1.start();
		
		
		for (int i = 0; i < 100; i++) {
			if(i==50){
				try {
					t1.join();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println(Thread.currentThread().getName()+" print " + i);
		}
	}
	
	
}

