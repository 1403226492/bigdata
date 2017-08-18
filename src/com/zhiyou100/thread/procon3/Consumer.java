package com.zhiyou100.thread.procon3;

public class Consumer implements Runnable{
	private Container container;
	private String name;
	
	
	/**
	 * @param container
	 */
	public Consumer(Container container,String name) {
		this.container = container;
		this.name = name;
	}
	public Consumer() {
		super();
	}


	public Container getContainer() {
		return container;
	}


	public void setContainer(Container container) {
		this.container = container;
	}


	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public void run() {
		Orange orange = null;
		for(int i=0;i<20;i++){
			orange = container.pop();
			System.out.println(this.name +":ฯ๛ทัมหฃบ" + orange);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}



