package com.zhiyou100.thread.procon1;

public class Client {
	public static void main(String[] args) {
		OrangePool pool = new OrangePool();

		Producer producer = new Producer(pool);
		Consumer consumer = new Consumer(pool);

//		ExecutorService service = Executors.newFixedThreadPool(5);
//
//		service.execute(producer);
//		service.execute(producer);
//		service.execute(producer);
//		service.execute(consumer);
//		service.execute(consumer);
//
//		service.shutdown();
		new Thread(producer, "������2").start();
		new Thread(producer, "������1").start();
		
		new Thread(consumer, "������2").start();
		new Thread(consumer, "������1").start();
		
	}

}
