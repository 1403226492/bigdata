package com.zhiyou100.oop.extend;

public  class Cat extends Animal {
	private String eyeColor;

	public Cat() {
		super();
	}

	public Cat(int id, String name, String color, int age) {
		super(id, name, color, age);
	}
	public Cat(int id, String name, String color, int age,String eyeColor) {
		super(id, name, color, age);
		this.eyeColor = eyeColor;
	}

	public String getEyeColor() {
		return eyeColor;
	}

	public void setEyeColor(String eyeColor) {
		this.eyeColor = eyeColor;
	}

	@Override
	public String toString() {
		return "Cat [name="+getName()+",color=" + getColor() +",age="+getAge()+",eyeColor=" + eyeColor + "]";
	}
	
	@Override
	public void eat() {
		System.out.println("Cat is eating!.........");
	}
	
	@Override
	public void cry() {
		System.out.println("Ã¨»áß÷ß÷½Ð£¡----------");
	}
	
	public void sleep(){
		System.out.println("Ã¨Ë¯¾õµÄÊ±ºò»á´òºôàà£¡£¬£¬£¬£¬£¬£¬£¬");
	}
	
}
