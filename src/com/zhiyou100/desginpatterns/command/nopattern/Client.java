package com.zhiyou100.desginpatterns.command.nopattern;

/**
 * 每个客户的需要有变动的时候，都要去修改Cooker的内容。
 * 这种方式不满足开闭原则（OCP open close principle）。
 * @author ayuw
 *
 */
public class Client {
	public static void main(String[] args) {
		Cooker cooker = new Cooker();
		cooker.doMapoToufu();
		cooker.doNoodle();
	}
}
