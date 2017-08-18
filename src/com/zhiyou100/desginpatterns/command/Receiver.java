package com.zhiyou100.desginpatterns.command;

/**
 * 请求执行者，这里指的是厨师，具体要执行的内容由其确认。
 * @author ayuw
 *
 */
public class Receiver {
	public void cooking(String type){
		System.out.println("厨师在做：" + type);
	}
}
