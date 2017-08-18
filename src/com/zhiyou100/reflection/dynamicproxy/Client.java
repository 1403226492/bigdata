package com.zhiyou100.reflection.dynamicproxy;

import java.lang.reflect.Proxy;

import com.zhiyou100.reflection.staticproxy.IWoman;
import com.zhiyou100.reflection.staticproxy.PanJinLian;

public class Client {

	public static void main(String[] args) {

		Class<?>[] interfaces = { IWoman.class,IFlyable.class,IAnimal.class };
		IWoman panJianLian = new PanJinLian();
		IWoman wangPo = (IWoman) Proxy.newProxyInstance(Client.class.getClassLoader(), interfaces, new DynamicProxy(panJianLian));
		wangPo.happy("Âí¼Ó¾ô");
		
		IFlyable duck = new Duck();
		IFlyable duckPerson = (IFlyable) Proxy.newProxyInstance(Client.class.getClassLoader(), interfaces, new DynamicProxy(duck));
		duckPerson.fly();
		
		
		IAnimal dog = new Dog();
		IAnimal wolf = new Wolf();
		
		IAnimal proxyAnimal = (IAnimal) Proxy.newProxyInstance(Client.class.getClassLoader(), interfaces, new DynamicProxy(dog));
		proxyAnimal.eat();
		proxyAnimal.cry();
		
		
		proxyAnimal = (IAnimal) Proxy.newProxyInstance(Client.class.getClassLoader(), interfaces, new DynamicProxy(wolf));
		
		proxyAnimal.eat();
		proxyAnimal.cry();
		
	}

}
