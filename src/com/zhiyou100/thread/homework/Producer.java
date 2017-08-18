package com.zhiyou100.thread.homework;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class Producer implements Runnable {
	
	/**
	 * ����������Ҫ����Ʒ���зŲ�Ʒ�����������߱���Ҫ֪�����ĸ���Ʒ���зţ���������
	 * Ҫ���в�Ʒ�ص����ã�������ϵ��
	 */
	private LinkedBlockingQueue<Product> pool;
	
	/**
	 * ��������Ϊ�˱�֤�����������Ĳ�Ʒ˳��������ԣ��������е��������߳�ʹ��ͬ�����������������
	 * ���Ը�ʵ�����Ի������е��߳�֮�乲������AtomicInteger���̰߳�ȫ�����ͣ�����Ҫ�����Լ�ȥ��
	 * �߳�ͬ������
	 */
	private AtomicInteger count = new AtomicInteger(0);
	
	/**
	 * ��Ȼ�����߳��в�Ʒ�ص����ã�����Ʒ��Ҫ�������ߺ�������֮�乲��
	 * ���Բ���ֱ���Լ���������Ҫ��������ʹ�ù���Ĳ�Ʒ�ء������������������ṩ
	 * �ⲿ�����Ʒ�ص��ֶΣ�������ù��췽�����룬Ҳ���Բ���setter�������룩
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
				current = count.getAndIncrement();//ԭ���Ե�count++������count��һ��ԭ�����ͣ���������Ϊ����ⷽ��
				product = new Product(current);
				pool.put(product);//�������õĲ�Ʒ�ŵ���Ʒ���У����ڲ�Ʒ��LinkedBlockingQueue�����Ѿ����߳�ͬ���ģ����Բ���Ҫ�������κ��߳�ͬ���Ĳ���
				System.out.println(Thread.currentThread().getName() + " �������˵�" + current + "����Ʒ...");
				Thread.sleep(300);
			} 
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
