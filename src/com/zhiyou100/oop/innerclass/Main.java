package com.zhiyou100.oop.innerclass;

import com.zhiyou100.oop.interfaces.Flyable;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		Outer.StaticInnerClass staticInnerClass = new Outer.StaticInnerClass();
		staticInnerClass.staticClassMethod();
		Outer.InstanceInnerClass InstanceInnerClass = new Outer().new InstanceInnerClass();
		InstanceInnerClass.InstanceClassMethod();
		
		Outer outer = new Outer();
		outer.testLocalInnerClass();
		Flyable birdMan = outer.testLocalInnerClass3();
		Flyable birdMan2 = outer.testAnonymousInnerClasss();
		birdMan2.fly();
	}

}
