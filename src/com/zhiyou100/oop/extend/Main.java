package com.zhiyou100.oop.extend;

public class Main {
	
	public static void main(String[] args) {
//		Animal animal = new Animal(1,"Ѽ��","��ɫ",1);
//		System.out.println(animal);
		Animal dog = new Dog(1, "����", "��ɫ", 3, "��ʿ��");
		dog.cry();
		Animal cat = new Cat(2, "����", "��ɫ", 2, "��ʯ��");
		cat.cry();
		Cat myCat = (Cat) cat;
		myCat.sleep();
	} 
}
