package com.zhiyou100.reflection.staticproxy;

public class WangPo implements IWoman {
	private IWoman panJinLian;
	
	public WangPo(IWoman panJinLian) {
		this.panJinLian = panJinLian;
	}
	@Override
	public void sendMsg(String target) {
		System.out.println(target +" 给我20两银子！");
		panJinLian.sendMsg(target);
	}

	@Override
	public void happy(String target) {
		System.out.println("西门大官人你继续，我帮你放风！");
		panJinLian.happy(target);
	}

}
