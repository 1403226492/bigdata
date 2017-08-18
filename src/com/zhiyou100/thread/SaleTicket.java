package com.zhiyou100.thread;

public class SaleTicket implements Runnable {
	private int count = 100;
	Object lock = new Object();
	private synchronized void sell(){
			if(count > 0){
				System.out.println(Thread.currentThread().getName() +" ���˵� " + count +"��Ʊ��");
				count--;
				try {
					Thread.sleep(20);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
	}
	
	@SuppressWarnings("unused")
	private synchronized void sell2(){
		if(count > 0){
			System.out.println(Thread.currentThread().getName() +" ���˵� " + count +"��Ʊ��");
			count--;
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
}
	@Override
	public void run() {
		while (true) {
			sell();
			if (count <= 0) {
				break;
			}
		}
	}

	public static void main(String[] args) {
		SaleTicket ticket = new SaleTicket();
		new Thread(ticket,"����1").start();
		new Thread(ticket,"����2").start();
		new Thread(ticket,"����3").start();
	}
}
