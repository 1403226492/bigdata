package com.zhiyou100.desginpatterns.command.nopattern;

/**
 * ÿ���ͻ�����Ҫ�б䶯��ʱ�򣬶�Ҫȥ�޸�Cooker�����ݡ�
 * ���ַ�ʽ�����㿪��ԭ��OCP open close principle����
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
