package com.zhiyou100.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SaleTicket2 implements Runnable{
	
	private int count = 100;
	private Lock lock = new ReentrantLock();
	
	public static void main(String[] args) {
		SaleTicket2 ticket2 = new SaleTicket2();
		new Thread(ticket2,"郑州窗口").start();
		new Thread(ticket2,"北京窗口").start();
		new Thread(ticket2,"广州窗口").start();
		new Thread(ticket2,"深圳窗口").start();
	}

	@Override
	public void run() {
		while(true){
			try {
				lock.lock();
				if(count > 0){
					System.out.println(Thread.currentThread().getName() +" sales :第" + count + "张票！");
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


