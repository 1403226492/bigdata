package com.zhiyou100.oop.extend;

public class Dog extends Animal{
	private String type;

	public Dog() {
		super();
	}

	public Dog(int id, String name, String color, int age) {
		super(id, name, color, age);
	}

	public Dog(int id, String name, String color, int age,String type) {
		super(id, name, color, age);
		this.type = type;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Dog [name="+getName()+",color=" + getColor() +",age="+getAge()+",type=" + type + "]";
	}
	
	@Override
	public void eat() {
		System.out.println("this is a dog eats method!------------");
	}

	@Override
	public void cry() {
		System.out.println("A dog may cry like wangwang!...........");
	}
	
	
}
