package com.zhiyou100.thread.calc;

import java.util.concurrent.Callable;

public class CalcCallable implements Callable<Integer> {
	private int floorValue;
	private int ceilValue;
	
	
	/**
	 * @param floorValue
	 * @param ceilValue
	 */
	public CalcCallable(int floorValue, int ceilValue) {
		this.floorValue = floorValue;
		this.ceilValue = ceilValue;
	}


	@Override
	public Integer call() throws Exception {
		int sum = floorValue + ceilValue;
		return sum;
	}

}
