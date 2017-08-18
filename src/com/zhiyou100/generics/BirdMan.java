package com.zhiyou100.generics;

public class BirdMan implements IFlyable<String> {

	@Override
	public void fly(String obj) {
		System.out.println("I'm a BirdMan ,I can fly " + obj);
	}
}
