package com.zhiyou100.reflection.staticproxy;

public class WangPo implements IWoman {
	private IWoman panJinLian;
	
	public WangPo(IWoman panJinLian) {
		this.panJinLian = panJinLian;
	}
	@Override
	public void sendMsg(String target) {
		System.out.println(target +" ����20�����ӣ�");
		panJinLian.sendMsg(target);
	}

	@Override
	public void happy(String target) {
		System.out.println("���Ŵ������������Ұ���ŷ磡");
		panJinLian.happy(target);
	}

}
