package com.zhiyou100.thread;

public class TestRunnableDemo02 {

	public static void main(String[] args) {
		RunnableDemo01 r1 = new RunnableDemo01();
		Thread t1 = new Thread(r1);
		t1.start();
		
		for (int i = 0; i < 20; i++) {
			System.out.println("TestRunnableDemo02´òÓ¡£º" + i);
		}
	}

}
