package com.zhiyou100.thread.homework;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class Producer implements Runnable {
	
	/**
	 * 由于生产者要往产品池中放产品，所有生产者必须要知道往哪个产品池中放，即生产者
	 * 要持有产品池的引用（关联关系）
	 */
	private LinkedBlockingQueue<Product> pool;
	
	/**
	 * 该数据是为了保证生产者生产的产品顺序的连续性，由于所有的生产者线程使用同样的生产任务（命令），
	 * 所以该实例属性会在所有的线程之间共享，鉴于AtomicInteger是线程安全的整型，不需要我们自己去做
	 * 线程同步处理。
	 */
	private AtomicInteger count = new AtomicInteger(0);
	
	/**
	 * 既然生产者持有产品池的引用，而产品池要在生产者和消费者之间共享，
	 * 所以不能直接自己创建，而要和消费者使用共享的产品池。针对这种情况，必须提供
	 * 外部传入产品池的手段（这里采用构造方法传入，也可以采用setter方法传入）
	 * @param pool
	 */
	public Producer(LinkedBlockingQueue<Product> pool) {
		this.pool = pool;
	}
	
	@Override
	public void run() {
		Product product = null;
		int current = 0;
		try {
			while (true) {
				current = count.getAndIncrement();//原子性的count++，本身count是一个原子整型，这样了是为了理解方便
				product = new Product(current);
				pool.put(product);//将生产好的产品放到产品池中，由于产品池LinkedBlockingQueue本身已经是线程同步的，所以不需要我们做任何线程同步的操作
				System.out.println(Thread.currentThread().getName() + " ：生产了第" + current + "个产品...");
				Thread.sleep(300);
			} 
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
