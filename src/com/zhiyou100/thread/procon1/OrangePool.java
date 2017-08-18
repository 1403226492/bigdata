package com.zhiyou100.thread.procon1;

public class OrangePool {
	private Orange[] oranges = new Orange[10];
	
	private int index = 0;
	
	
	public synchronized void put(Orange orange){
		while(index == oranges.length){
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		this.notifyAll();
		oranges[index] = orange;
		index++;
	}

	public synchronized Orange get(){
		Orange orange = null;
		while (index == 0) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		this.notifyAll();
		index--;
		orange = oranges[index];
		return orange;
	}
}
