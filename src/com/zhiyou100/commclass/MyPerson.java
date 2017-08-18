package com.zhiyou100.commclass;

import com.zhiyou100.oop.extend.Dog;

public class MyPerson implements Cloneable{
	private int age;
	private String name;
	private Dog dog;
	public MyPerson() {
		super();
	}
	public MyPerson(int age, String name, Dog dog) {
		super();
		this.age = age;
		this.name = name;
		this.dog = dog;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Dog getDog() {
		return dog;
	}
	public void setDog(Dog dog) {
		this.dog = dog;
	}
	
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	@Override
	public String toString() {
		return "MyPerson [age=" + age + ", name=" + name + ", dog=" + getDog() + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MyPerson other = (MyPerson) obj;
		if (age != other.age)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}



	
}
