package com.zhiyou100.thread.homework;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyPrintABC {
	
	public static Lock lock = new ReentrantLock();
	public static Condition a = lock.newCondition();
	public static Condition b = lock.newCondition();
	public static Condition c = lock.newCondition();
	
	public static String threadName = "A";

	public static void main(String[] args) {
		ARunnable a = new ARunnable();
		BRunnable b = new BRunnable();
		CRunnable c = new CRunnable();
		ExecutorService  service = Executors.newFixedThreadPool(3);
		
		service.submit(b);
		service.submit(a);
		service.submit(c);
		
		service.shutdown();
	}

}
class ARunnable implements Runnable{

	@Override
	public void run() {
		try {
			MyPrintABC.lock.lock();
			for (int i = 0; i < 10; i++) {
				while (!MyPrintABC.threadName.equals("A")) {
					MyPrintABC.a.await();
				}
				System.out.print("A");
				Thread.sleep(10);
				MyPrintABC.threadName = "B";
				MyPrintABC.b.signal();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			MyPrintABC.lock.unlock();
		}
	}
		
	}
	
class BRunnable implements Runnable{

	@Override
	public void run() {
		try {
			MyPrintABC.lock.lock();
			for (int i = 0; i < 10; i++) {
				while (!MyPrintABC.threadName.equals("B")) {
					MyPrintABC.b.await();
				}
				System.out.print("B");
				Thread.sleep(10);
				MyPrintABC.threadName = "C";
				MyPrintABC.c.signal();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			MyPrintABC.lock.unlock();
		}
	}
		
	}
	
class CRunnable implements Runnable{

	@Override
	public void run() {
		try {
			MyPrintABC.lock.lock();
			for (int i = 0; i < 10; i++) {
				while (!MyPrintABC.threadName.equals("C")) {
					MyPrintABC.c.await();
				}
				System.out.print("C");
				Thread.sleep(10);
				MyPrintABC.threadName = "A";
				MyPrintABC.a.signal();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			MyPrintABC.lock.unlock();
		}
	}
		
	}
	
