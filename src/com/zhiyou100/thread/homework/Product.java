package com.zhiyou100.thread.homework;

public class Product {
	private int id;
	
	public Product() {
	}
	
		
	public Product(int id) {
		this.id = id;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	@Override
	public String toString() {
		return "²úÆ· [id=" + id + "]";
	}
	
	
}
