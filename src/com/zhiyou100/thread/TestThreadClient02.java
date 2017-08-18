package com.zhiyou100.thread;

public class TestThreadClient02 {

	public static void main(String[] args) {
		Runnable myRunnable = new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 10; i++) {
					System.out.println(Thread.currentThread().getName() +"打印：" + i );
				}
			}
		};
	    Thread t1 = new Thread(myRunnable,"计算线程");
		t1.start();
		
		for (int i = 0; i < 10; i++) {
			System.out.println(Thread.currentThread().getName() +"打印：" + i );
		}
	}

}
