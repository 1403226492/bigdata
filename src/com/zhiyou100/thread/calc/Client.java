package com.zhiyou100.thread.calc;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Client {

	public static void main(String[] args) {
		CalcCallable c1 = new CalcCallable(0, 100);
		CalcCallable c2 = new CalcCallable(101, 200);
		CalcCallable c3 = new CalcCallable(201, 300);
		ExecutorService service = Executors.newFixedThreadPool(3);
		Future[] fs = new Future[3];
		Future<Integer> f1 = service.submit(c1);
		Future<Integer> f2 = service.submit(c2);
		Future<Integer> f3 = service.submit(c3);
		fs[0] = f1;
		fs[1] = f2;
		fs[2] = f3;
		int sum = 0;
		for (Future<Integer> f : fs) {
			try {
				sum = sum + f.get().intValue();
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			}
		}
		System.out.println(sum);
		service.shutdown();
	}

}
