package com.zhiyou100.thread.procon2;

import java.util.concurrent.LinkedBlockingQueue;

public class Consumer extends Thread {
	private LinkedBlockingQueue<Apple> pool;
	private String name;

	/**
	 * 
	 */
	public Consumer() {
		super();
	}

	public Consumer(LinkedBlockingQueue<Apple> pool, String name) {
		this.pool = pool;
		this.name = name;
	}

	@Override
	public void run() {
		for (int i = 0; i < 20; i++) {
			Apple apple = null;
			try {
				apple = pool.take();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(name + "ฯ๛ทัมหฃบ" + apple);
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
