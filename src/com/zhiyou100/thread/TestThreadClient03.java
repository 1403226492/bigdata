package com.zhiyou100.thread;

public class TestThreadClient03 {

	public static void main(String[] args) {
		ThreadGroup myGroup = new ThreadGroup("���δ������߳��飺");
		Runnable myRunnable = new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 10; i++) {
					System.out.println(">>>>>>>>>>>>>" + Thread.currentThread().getThreadGroup().getName());
					System.out.println(Thread.currentThread().getName() +"��ӡ��" + i );
				}
			}
		};
		
		Thread t1 = new Thread(myGroup,myRunnable,"�����߳�");
		t1.start();
		String groupName = Thread.currentThread().getThreadGroup().getName();
		System.out.println(">>>>>>>>>>>>>" + groupName);
		for (int i = 0; i < 10; i++) {
			System.out.println(Thread.currentThread().getName() +"��ӡ��" + i );
		}
	}

}
