package com.zhiyou100.thread.procon3;

public class Producer implements Runnable{
	private Container container;
	private String name;
	
	
	/**
	 * 
	 */
	public Producer() {
		super();
		// TODO Auto-generated constructor stub
	}


	/**
	 * @param container
	 * @param name
	 */
	public Producer(Container container, String name) {
		this.container = container;
		this.name = name;
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
			orange = new Orange(i);
			container.put(orange);
			System.out.println(name +":Éú²úÁË£º" + orange);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}



