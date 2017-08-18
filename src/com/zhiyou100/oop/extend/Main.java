package com.zhiyou100.oop.extend;

public class Main {
	
	public static void main(String[] args) {
//		Animal animal = new Animal(1,"鸭子","灰色",1);
//		System.out.println(animal);
		Animal dog = new Dog(1, "二黄", "黑色", 3, "哈士奇");
		dog.cry();
		Animal cat = new Cat(2, "三黄", "白色", 2, "宝石绿");
		cat.cry();
		Cat myCat = (Cat) cat;
		myCat.sleep();
	} 
}
