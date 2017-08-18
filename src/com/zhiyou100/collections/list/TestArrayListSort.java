package com.zhiyou100.collections.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.zhiyou100.collections.entity.Employee;

public class TestArrayListSort {
	public static void main(String[] args) {
		List<Employee> employees = new ArrayList<Employee>();
		Employee emp = new Employee("张飞", 55, 20.00);
		employees.add(emp);
		emp = new Employee("关羽", 46, 40.00);
		employees.add(emp);
		emp = new Employee("刘备", 49, 50.00);
		employees.add(emp);
		emp = new Employee("赵云", 30, 40.00);
		employees.add(emp);
		
		
		Collections.sort(employees, new Comparator<Employee>() {
			@Override
			public int compare(Employee o1, Employee o2) {
				return (int)(o2.getSalary() - o1.getSalary());
			}
		});
		
		for(Employee e:employees){
			System.out.println(e);
		}
		
		
		/*
		 * 策略模式
		 */
		Collections.sort(employees,new Comparator<Employee>() {

			@Override
			public int compare(Employee o1, Employee o2) {
				return o2.getAge() - o1.getAge();
			}
		});
		
		for(Employee e:employees){
			System.err.println(e);
		}
		
		Collections.sort(employees, new Comparator<Employee>() {

			@Override
			public int compare(Employee o1, Employee o2) {
				int ret = 0;
				if(o2.getSalary() > o1.getSalary()){
					ret = 1;
				}else if (o2.getSalary() < o1.getSalary()) {
					ret = -1;
				}else {
					ret = o2.getAge() - o1.getAge();
				}
				return ret;
			}
		});
		
		
		for(Employee e:employees){
			System.out.println(e);
		}
	}
}
