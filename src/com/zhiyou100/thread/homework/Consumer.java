package com.zhiyou100.thread.homework;

import java.util.concurrent.LinkedBlockingQueue;

public class Consumer implements Runnable {

	/**
	 * 消费者要从产品池中消费产品，所以消费者必须知道自己操作的是哪个产品池；
	 * 因此，消费者要持有产品池的一个引用（关联关系）
	 */
	private LinkedBlockingQueue<Product> pool;
	
	/**
	 * 为了保证所有消费者共享产品池，必须提供一个注入共享产品池的接口或者说方法，
	 * 这里采用构造方法注入一个和生产者共享的产品池。
	 * @param pool
	 */
	public Consumer(LinkedBlockingQueue<Product> pool) {
		this.pool = pool;
	}
	
	@Override
	public void run() {
		Product product = null;
		try {
			while (true) {
				product = pool.take();//从产品池中拿出一个产品用来消费，产品池本身已经是线程同步的，不需要我们再做任何线程同步相关的操作
				System.out.println(Thread.currentThread().getName() + " :消费了：" + product + ">>>");
				Thread.sleep(300);
			} 
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
