package com.zhiyou100.thread.homework;

import java.util.concurrent.LinkedBlockingQueue;

public class Main {

	public static void main(String[] args) {
		LinkedBlockingQueue<Product> pool = new LinkedBlockingQueue<>(10);
		Producer p = new Producer(pool);
		Consumer c = new Consumer(pool);
		
		new Thread(p, "������1").start();
		new Thread(p, "������2").start();
		new Thread(p, "������3").start();
		
		new Thread(c, "������1").start();
		new Thread(c, "������2").start();
		new Thread(c, "������3").start();
		new Thread(c, "������4").start();
	}

}
