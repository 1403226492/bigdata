package com.zhiyou100.thread.procon2;

import java.util.concurrent.LinkedBlockingQueue;

public class Producer extends Thread {
	private LinkedBlockingQueue<Apple> pool;
	private String name;
	/**
	 * 
	 */
	public Producer() {
		super();
	}
	
	public Producer(LinkedBlockingQueue<Apple> pool,String name) {
		this.pool = pool;
		this.name = name;
	}
	
	@Override
	public void run() {
		for (int i=0;i<20;i++) {
				Apple apple = new Apple(i);
				try {
					pool.put(apple);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(name +"生产了苹果：" + i);
				try {
					Thread.sleep(300);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
		}
	}
}
