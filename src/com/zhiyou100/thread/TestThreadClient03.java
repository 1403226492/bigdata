package com.zhiyou100.thread;

public class TestThreadClient03 {

	public static void main(String[] args) {
		ThreadGroup myGroup = new ThreadGroup("智游大数据线程组：");
		Runnable myRunnable = new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 10; i++) {
					System.out.println(">>>>>>>>>>>>>" + Thread.currentThread().getThreadGroup().getName());
					System.out.println(Thread.currentThread().getName() +"打印：" + i );
				}
			}
		};
		
		Thread t1 = new Thread(myGroup,myRunnable,"计算线程");
		t1.start();
		String groupName = Thread.currentThread().getThreadGroup().getName();
		System.out.println(">>>>>>>>>>>>>" + groupName);
		for (int i = 0; i < 10; i++) {
			System.out.println(Thread.currentThread().getName() +"打印：" + i );
		}
	}

}
