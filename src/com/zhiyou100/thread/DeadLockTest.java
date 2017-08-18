package com.zhiyou100.thread;

public class DeadLockTest {
	public static Object resourceA = new Object();
	public static Object resourceB = new Object();
	public static void main(String[] args) {
		new DeadLockTest().new DeadLockThread1("ռ����ԴA���߳�").start();
		new DeadLockTest().new DeadLockThread2("ռ����ԴB���߳�").start();
	}

	class DeadLockThread1 extends Thread{
		private String name;
		public DeadLockThread1(String name){
			this.name = name;
		}
		
		@Override
		public void run() {
			/*
			 * �߳�ռ������ԴA
			 */
			synchronized (resourceA) {
				System.out.println(">>>>>>>>>>>>�����߳�--" + name);
				try {
					/*
					 * sleep�������еĹ����в��ͷ��Ѿ�ռ�е�����
					 * �������ͷ�ռ��resourceA
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
			 * �߳�ռ������ԴB
			 */
			synchronized (resourceB) {
				System.out.println(">>>>>>>>>>>>�����߳�--" + name);
				try {
					/*
					 * sleep�������еĹ����в��ͷ��Ѿ�ռ�е�����
					 * �������ͷ�ռ��resourceB
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
