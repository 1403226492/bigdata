package com.zhiyou100.reflection.staticproxy;

public class Client {

	public static void main(String[] args) {
		IWoman panJinLian = new PanJinLian();
		IWoman wangPo = new WangPo(panJinLian);
		wangPo.sendMsg("西门大官人");
		System.out.println("===============================");
		wangPo.happy("西门庆");
	}

}
