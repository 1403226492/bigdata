package com.zhiyou100.thread;

public class TestThreadClient01 {

	public static void main(String[] args) {
		ThreadDemo01 t1 = new ThreadDemo01();//创建一个线程
		//t1.run();//方法调用，并没有启动多线程的支持
		t1.start();
		//t1.start();//线程只能启动一次，启动多次会提示IllegalThreadStateException异常
		for(int j=0;j<10;j++){
			System.out.println("TestThreadClient01打印：" + j);
		}
	}

}
