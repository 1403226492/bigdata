package com.zhiyou100.desginpatterns.simplefactory;

public class HumanFactory {
	public static Human createHuman(String type){
		Human ret = null;
		if("B".equals(type)){
			ret = new BlackHuman();
		}else if ("Y".equals(type)) {
			ret = new YellowPerson();
		}else if ("W".equals(type)) {
			ret = new WhiteHuman();
		}
		return ret;
	}
	
	public static Human createHuman2(String clazzName){
		Human ret = null;
		Class<Human> clazz = null;
		try {
			clazz = (Class<Human>) Class.forName(clazzName);
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		try {
			ret = clazz.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
		return ret;
	}
}
