package com.zhiyou100.thread.procon1;

public class Consumer implements Runnable {
	private OrangePool pool;

	/**
	 * 
	 */
	public Consumer() {
	}

	/**
	 * @param pool
	 */
	public Consumer(OrangePool pool) {
		this.pool = pool;
	}

	@Override
	public void run() {
		for (int i = 0; i < 20; i++) {
			System.out.println("�������̣߳�" + Thread.currentThread().getName() + "�����ˣ�" + pool.get());
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
