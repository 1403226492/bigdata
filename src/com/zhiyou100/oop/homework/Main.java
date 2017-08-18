package com.zhiyou100.oop.homework;

import java.util.Arrays;

import com.zhiyou100.oop.homework.entity.Person;

public class Main {
	public static void main(String[] args) {
//		String addResult = MathUtils.add("123222222222222222222222222222222222222222222222222.345", "23455555555555555555555555555555555555555555555555555555555555555555555555555.123");
//		System.out.println(addResult);
//		
//		String divideResult = MathUtils.divide("1055555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555", "5");
//		System.out.println(divideResult);
		test2();
	}
	
	public static void test1(){
		Person[] persons = new Person[4];
		Person person = new Person("张三1",2500);
		persons[0] = person;
		person = new Person("张三2",3000);
		persons[1] = person;
		person = new Person("张三3",3000);
		persons[2] = person;
		person = new Person("张三4",3500);
		persons[3] = person;
		Arrays.sort(persons);
		System.out.println(Arrays.toString(persons));
	}
	public static void test2(){
		Person[] persons = new Person[50];
		for(int i=0;i<50;i++){
			persons[i] = new Person("张三" + i,i*500 + 100);
		}
		Arrays.sort(persons);
		System.out.println(Arrays.toString(persons));
	}


}
