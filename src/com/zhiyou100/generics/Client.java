package com.zhiyou100.generics;

public class Client {

	public static void main(String[] args) {
		IFlyable<String> man = new BirdMan();
		man.fly("עשענְֿ");
	}
	
	public static void test1(){
		Singleton<Integer> obj = Singleton.getInstace();
		obj.printMsg(1);
		Singleton<String> obj2 = Singleton.getInstace();
		obj2.printMsg("abc");
		
		System.out.println(obj.getClass() == obj2.getClass());
	}

}
