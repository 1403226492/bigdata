package com.zhiyou100.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class SaleTicket3 implements Runnable {
	private Semaphore semaphore = new Semaphore(1);
	
	private int count = 100;
	@Override
	public void run() {
		while (true) {
			try {
				semaphore.acquire();
				if(count > 0){
					System.out.println(Thread.currentThread().getName() + " 卖出了第" + count +"张票！");
					count--;
					TimeUnit.MILLISECONDS.sleep(100);
				}else{
					break;
				}
				semaphore.release();
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				
			}
		}
	}

	public static void main(String[] args) {
		ExecutorService pool = Executors.newFixedThreadPool(5);
		SaleTicket3 ticket3  = new SaleTicket3();
		
		pool.submit(ticket3);
		pool.submit(ticket3);
		pool.submit(ticket3);
		pool.submit(ticket3);
		pool.submit(ticket3);
		
		pool.shutdown();
	}

}
