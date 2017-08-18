package com.zhiyou100.thread.homework;

import java.util.concurrent.LinkedBlockingQueue;

public class Main {

	public static void main(String[] args) {
		LinkedBlockingQueue<Product> pool = new LinkedBlockingQueue<>(10);
		Producer p = new Producer(pool);
		Consumer c = new Consumer(pool);
		
		new Thread(p, "生产者1").start();
		new Thread(p, "生产者2").start();
		new Thread(p, "生产者3").start();
		
		new Thread(c, "消费者1").start();
		new Thread(c, "消费者2").start();
		new Thread(c, "消费者3").start();
		new Thread(c, "消费者4").start();
	}

}
