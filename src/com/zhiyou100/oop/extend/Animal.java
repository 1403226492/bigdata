package com.zhiyou100.oop.extend;

public abstract class Animal {
	private int id;
	private String name;
	private String color;
	private int age;
	public Animal() {
		super();
	}
	public Animal(int id, String name, String color, int age) {
		super();
		this.id = id;
		this.name = name;
		this.color = color;
		this.age = age;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Animal [name=" + name + ", color=" + color + ", age=" + age + "]";
	}
	
	public abstract void eat();
	
	public abstract void cry();
	
	public final void  call(){
		System.out.println("ËûÔÚ½Î³µ£¡=========");
	}
}
