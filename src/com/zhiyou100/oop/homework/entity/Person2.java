package com.zhiyou100.oop.homework.entity;

public class Person2 {
	private long id;
	private String name;
	private int salary;
	private boolean alived;

	public Person2() {
		super();
	}

	public Person2(String name, int salary) {
		super();
		this.name = name;
		this.salary = salary;
	}

	public Person2(long id, String name, int salary, boolean alived) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.alived = alived;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public boolean isAlived() {
		return alived;
	}

	public void setAlived(boolean alived) {
		this.alived = alived;
	}

	@Override
	public String toString() {
		return "Person2 [id=" + id + ", name=" + name + ", salary=" + salary + ", alived=" + alived + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (alived ? 1231 : 1237);
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + salary;
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
		Person2 other = (Person2) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (salary != other.salary)
			return false;
		return true;
	}
}
