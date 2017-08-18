package com.zhiyou100.oop.enums;

public class Seasons {
	public static final Seasons SPRING = new Seasons("����");
	public static final Seasons SUMMER = new Seasons("����");
	public static final Seasons AUTUMN = new Seasons("����");
	public static final Seasons WINTER = new Seasons("����");
	private String seasonName;
	private Seasons(){
		
	}
	private Seasons(String seasonName){
		this.seasonName = seasonName;
	}
	public String getSeasonName() {
		return seasonName;
	}
	public void setSeasonName(String seasonName) {
		this.seasonName = seasonName;
	}
	@Override
	public String toString() {
		return "Seasons [seasonName=" + seasonName + "]";
	}
	
	public static Seasons[] values(){
		Seasons[] ret = new Seasons[4];
		ret[0] = SPRING;
		ret[1] = SUMMER;
		ret[2] = AUTUMN;
		ret[3] = WINTER;
		return ret;
	}
}
