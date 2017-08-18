package com.zhiyou100.thread;

public class RunnableDemo01 implements Runnable {

	@Override
	public void run() {
		for(int i=0;i<100;i++){
			System.out.println("RunnableDemo01´òÓ¡£º" + i);
		}
	}

}
