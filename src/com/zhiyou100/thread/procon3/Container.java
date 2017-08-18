package com.zhiyou100.thread.procon3;

public class Container {
	private int index = 0;
	private Orange[] oranges = new Orange[6];
	
	public synchronized void put(Orange orange){
		while (index == oranges.length) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		this.notify();
		oranges[index] = orange;
		this.index++;
	}
	
	public synchronized Orange pop(){
		Orange ret = null;
		while (this.index == 0) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		this.notify();
		this.index--;
		ret = oranges[this.index];
		return ret;
	}
}



