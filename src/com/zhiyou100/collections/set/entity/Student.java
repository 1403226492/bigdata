package com.zhiyou100.collections.set.entity;

public class Student {
	private String serialNum;//—ß∫≈
	private String college;//¥Û—ß
	private String name;
	private String dept;
	private int age;
	public Student() {
		super();
	}
	public Student(String serialNum, String college, String name, String dept, int age) {
		super();
		this.serialNum = serialNum;
		this.college = college;
		this.name = name;
		this.dept = dept;
		this.age = age;
	}
	public String getSerialNum() {
		return serialNum;
	}
	public void setSerialNum(String serialNum) {
		this.serialNum = serialNum;
	}
	public String getCollege() {
		return college;
	}
	public void setCollege(String college) {
		this.college = college;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Student [serialNum=" + serialNum + ", college=" + college + ", name=" + name + ", dept=" + dept
				+ ", age=" + age + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((college == null) ? 0 : college.hashCode());
		result = prime * result + ((dept == null) ? 0 : dept.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((serialNum == null) ? 0 : serialNum.hashCode());
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
		Student other = (Student) obj;
		if (age != other.age)
			return false;
		if (college == null) {
			if (other.college != null)
				return false;
		} else if (!college.equals(other.college))
			return false;
		if (dept == null) {
			if (other.dept != null)
				return false;
		} else if (!dept.equals(other.dept))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (serialNum == null) {
			if (other.serialNum != null)
				return false;
		} else if (!serialNum.equals(other.serialNum))
			return false;
		return true;
	}
}
