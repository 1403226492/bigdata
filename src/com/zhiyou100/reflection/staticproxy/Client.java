package com.zhiyou100.reflection.staticproxy;

public class Client {

	public static void main(String[] args) {
		IWoman panJinLian = new PanJinLian();
		IWoman wangPo = new WangPo(panJinLian);
		wangPo.sendMsg("���Ŵ����");
		System.out.println("===============================");
		wangPo.happy("������");
	}

}
