package com.zhiyou100.oop.homework.entity;

public class Person implements Comparable<Person>{
	private String name;
	private int salary;
	
	public Person() {
		this(null, 0);
	}
	
	public Person(String name,int salary){
		super();
		this.name = name;
		this.salary = salary;
	}
	
	public String getName(){
		return this.name;
	}
	public void setName(String name){
		this.name = name;
	}
	public int getSalary() {
		return this.salary;
	}
	
	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer("[");
		sb.append("name="+ this.name);
		sb.append(",salary="+ this.salary);
		sb.append("]");
		return sb.toString();
	}

	@Override
	public int compareTo(Person o) {
		int ret = 0;
		if(o != null){
			if(this.getSalary() > o.getSalary()){
				ret = -1;
			}
			if(this.getSalary() < o.getSalary()){
				ret = 1;
			}
			if(this.getSalary() == o.getSalary()){
				ret = o.getName().compareTo(this.getName());
			}
		}
		return ret;
	}
}
