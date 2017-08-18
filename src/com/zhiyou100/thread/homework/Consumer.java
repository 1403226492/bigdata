package com.zhiyou100.thread.homework;

import java.util.concurrent.LinkedBlockingQueue;

public class Consumer implements Runnable {

	/**
	 * ������Ҫ�Ӳ�Ʒ�������Ѳ�Ʒ�����������߱���֪���Լ����������ĸ���Ʒ�أ�
	 * ��ˣ�������Ҫ���в�Ʒ�ص�һ�����ã�������ϵ��
	 */
	private LinkedBlockingQueue<Product> pool;
	
	/**
	 * Ϊ�˱�֤���������߹����Ʒ�أ������ṩһ��ע�빲���Ʒ�صĽӿڻ���˵������
	 * ������ù��췽��ע��һ���������߹���Ĳ�Ʒ�ء�
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
				product = pool.take();//�Ӳ�Ʒ�����ó�һ����Ʒ�������ѣ���Ʒ�ر����Ѿ����߳�ͬ���ģ�����Ҫ���������κ��߳�ͬ����صĲ���
				System.out.println(Thread.currentThread().getName() + " :�����ˣ�" + product + ">>>");
				Thread.sleep(300);
			} 
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
