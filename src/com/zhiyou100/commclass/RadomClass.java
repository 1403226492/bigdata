package com.zhiyou100.commclass;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import com.zhiyou100.reflection.dynamicproxy.Dog;

public class RadomClass {

	public static void main(String[] args) {
		// testRandom();
//		while (true)
//			System.out.println(getNoRepeatRandom());
		Dog dog = null;
		for(;;){
			 dog = new Dog();
			System.out.println(dog.toString());
			dog = null;
		}
	}

	public static void testRandom() {
		Random random = new Random();
		System.out.println(random.nextDouble());
		int i = 0;
		while (i < 100) {
			System.err.println(random.nextInt());
			i++;
		}

		int j = 0;
		while (j < 100) {
			System.out.println(random.nextInt(1000));
			j++;
		}
	}

	private static String getNoRepeatRandom() {
		String ret = "";
		String temp = "" + System.nanoTime();
		temp = temp.concat(new StringBuilder(temp).reverse().toString());
		ret = temp;
		return ret;
	}

	private static String getNoRepeatRandomSimple() {
		String ret = "";
		try {
			TimeUnit.MILLISECONDS.sleep(30);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ret = "" + System.nanoTime();
		return ret;
	}
}
