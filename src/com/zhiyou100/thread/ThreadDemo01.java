package com.zhiyou100.thread;

public class ThreadDemo01 extends Thread {
	@Override
	public void run() {
		for(int i=0;i<10;i++){
			System.out.println("ThreadDemo01Ïß³Ì´òÓ¡£º" + i);
		}
	}
	
}
