package com.zhiyou100.reflection.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * 该类能够代理任何接口
 * 这个类相当于静态代理中的wangpo类
 * @author ayuw
 *
 */
public class DynamicProxy implements InvocationHandler {
	private Object target;
	
	
	public DynamicProxy(Object target) {
		super();
		this.target = target;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		beforeInvoke();
		Object ret = method.invoke(target, args);
		afterInvoke();
		return ret;
	}

	public void beforeInvoke(){
		System.out.println(String.format("%1$tF %1$tT", new Date()));
	}
	
	public void afterInvoke(){
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(String.format("%1$tF %1$tT", new Date()));
	}
}
