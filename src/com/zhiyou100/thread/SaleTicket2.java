package com.zhiyou100.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SaleTicket2 implements Runnable{
	
	private int count = 100;
	private Lock lock = new ReentrantLock();
	
	public static void main(String[] args) {
		SaleTicket2 ticket2 = new SaleTicket2();
		new Thread(ticket2,"֣�ݴ���").start();
		new Thread(ticket2,"��������").start();
		new Thread(ticket2,"���ݴ���").start();
		new Thread(ticket2,"���ڴ���").start();
	}

	@Override
	public void run() {
		while(true){
			try {
				lock.lock();
				if(count > 0){
					System.out.println(Thread.currentThread().getName() +" sales :��" + count + "��Ʊ��");
					count--;
					Thread.sleep(100);
				}else{
					break;
				}
			} catch (Exception e) {
			}finally {
				lock.unlock();
			}
		}
	}

}


