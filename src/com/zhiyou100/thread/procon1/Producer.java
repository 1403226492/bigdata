package com.zhiyou100.thread.procon1;

import java.util.concurrent.atomic.AtomicInteger;

public class Producer implements Runnable {
	private OrangePool pool;
	private AtomicInteger count = new AtomicInteger(0);

	/**
	 * 
	 */
	public Producer() {
		super();
	}

	/**
	 * @param pool
	 */
	public Producer(OrangePool pool) {
		this.pool = pool;
	}

	@Override
	public void run() {
		Orange orange = null;
		for (int i = 0; i < 20; i++) {
			orange = new Orange(i);
			pool.put(orange);
			System.out
					.println("�������߳�:" + Thread.currentThread().getName() + ":�����˵ڣ�" + count.getAndIncrement() + "ƿ��֭!");
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

}
