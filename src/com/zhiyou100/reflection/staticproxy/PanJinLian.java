package com.zhiyou100.reflection.staticproxy;

public class PanJinLian implements IWoman {

	@Override
	public void sendMsg(String target) {
		System.out.println("潘金莲发消息给：" + target);

	}

	@Override
	public void happy(String target) {
		System.out.println("PanJinLian happy with :" + target);
	}
}
