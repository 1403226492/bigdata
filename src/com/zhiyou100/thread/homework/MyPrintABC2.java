package com.zhiyou100.thread.homework;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class MyPrintABC2 {
	private static Semaphore s1 = new Semaphore(1);
	private static Semaphore s2 = new Semaphore(0);
	private static Semaphore s3 = new Semaphore(0);

	public static void main(String[] args) {
		Runnable a = new Runnable() {

			@Override
			public void run() {
				try {
					for (int i = 0; i < 10; i++) {
						s1.acquire();
						System.out.print("A");
						Thread.sleep(200);
						s2.release();
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		Runnable b = new Runnable() {

			@Override
			public void run() {
				try {
					
					for (int i = 0; i < 10; i++) {
						s2.acquire();
						System.out.print("B");
						Thread.sleep(200);
						s3.release();
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		Runnable c = new Runnable() {

			@Override
			public void run() {
				try {
					for (int i = 0; i < 10; i++) {
						s3.acquire();
						System.out.print("C");
						Thread.sleep(200);
						s1.release();
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		
		ExecutorService pool = Executors.newFixedThreadPool(3);
		pool.submit(a);
		pool.submit(b);
		pool.submit(c);
		
		pool.shutdown();
	}

	
	
}
