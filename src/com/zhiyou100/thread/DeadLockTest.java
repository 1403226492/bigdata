package com.zhiyou100.thread;

public class DeadLockTest {
	public static Object resourceA = new Object();
	public static Object resourceB = new Object();
	public static void main(String[] args) {
		new DeadLockTest().new DeadLockThread1("占有资源A的线程").start();
		new DeadLockTest().new DeadLockThread2("占有资源B的线程").start();
	}

	class DeadLockThread1 extends Thread{
		private String name;
		public DeadLockThread1(String name){
			this.name = name;
		}
		
		@Override
		public void run() {
			/*
			 * 线程占有了资源A
			 */
			synchronized (resourceA) {
				System.out.println(">>>>>>>>>>>>进入线程--" + name);
				try {
					/*
					 * sleep方法运行的过程中不释放已经占有的锁，
					 * 即不会释放占有resourceA
					 */
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				synchronized (resourceB) {
					for (int i = 0; i < 10; i++) {
						System.out.println(name +": print " + i);
					}
				}
			}
		}
	}
	
	class DeadLockThread2 extends Thread{
		private String name;
		public DeadLockThread2(String name){
			this.name = name;
		}
		
		@Override
		public void run() {
			/*
			 * 线程占有了资源B
			 */
			synchronized (resourceB) {
				System.out.println(">>>>>>>>>>>>进入线程--" + name);
				try {
					/*
					 * sleep方法运行的过程中不释放已经占有的锁，
					 * 即不会释放占有resourceB
					 */
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				synchronized (resourceA) {
					for (int i = 0; i < 10; i++) {
						System.out.println(name +": print " + i);
					}
				}
			}
		}
	}
}
