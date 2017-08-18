package com.zhiyou100.commclass;

import com.zhiyou100.oop.extend.Dog;

public class ObjectClass {

	public static void main(String[] args) throws Throwable {
		//testAssignByVarName();
		MyPerson person = new MyPerson();
		person.setAge(20);
		person.setName("zhangsan");
		Dog dog = new Dog(1, "Ð¡»Æ", "green", 3);
		person.setDog(dog);
		MyPerson person2 = (MyPerson) person.clone();
		System.out.println(person);
		person2.setName("lisi");
		person2.getDog().setName("Ð¡ºÚ");
		System.out.println(person);
	}

	public static void testAssignByVarName() {
		MyPerson person = new MyPerson();
		person.setAge(30);
		person.setName("zhangsan");
		System.out.println(person);
		MyPerson person2 = person;
		
		System.out.println(person);
		person2.setName("simaguang");
		System.out.println(person);
	}

}
