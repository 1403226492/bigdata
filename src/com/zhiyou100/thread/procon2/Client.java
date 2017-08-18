package com.zhiyou100.thread.procon2;

import java.util.concurrent.LinkedBlockingQueue;

public class Client {

	public static void main(String[] args) {
		LinkedBlockingQueue<Apple> pool = new LinkedBlockingQueue<Apple>(5);
		new Producer(pool,"生产者1").start();
		new Producer(pool,"生产者2").start();
		new Consumer(pool,"消费者1").start();
		new Consumer(pool,"消费者2").start();
	}

}
