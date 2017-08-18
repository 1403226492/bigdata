package com.zhiyou100.net;

import java.util.Random;

public class TestRandomStudent {
	private static final Random random = new Random();
	
	private static final String[] STUDENT_SEEDS = 
			("陈凯杰  王永森  陈升腾  徐志立   " +
			" 蒋玉凯 陈晓凯 张培 成全利 孙源 张型宇 " +
			" 王涛 桑国帅  邓振东 宋航琦 邹九龙 杨龙 靳林川 " +
			" 贺尤申 赵银明 王中亚  刘继奎 侯亚坤 刘乐乐 吴腾龙 " +
			" 孙双明 郭帅 李银修  田亮亮 吕华磊 齐元迪 马杰 邓慧  杜羽").split("\\s+");
	
	
	public static void main(String[] args) {
		for (int i = 0; i < 5; i++) {
			System.out.println(getRandomStudent());
		}
	}
	
	private static String getRandomStudent(){
		String ret = null;
		ret = STUDENT_SEEDS[random.nextInt(STUDENT_SEEDS.length)];
		return ret;
	}
}
