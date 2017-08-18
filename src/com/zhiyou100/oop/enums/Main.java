package com.zhiyou100.oop.enums;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		Sex sex = Sex.UNKNOWN;
		switch (sex) {
		case MALE:
			System.out.println("����Ա�Ϊ�У�");
			break;
		case FAMALE:
			System.out.println("����Ա�ΪŮ��");
			break;
		default:
			System.out.println("����Ա�Ϊδ֪��");
			break;
		}
	}
	
	public static void test1(){
		Seasons[] mySeasons = Seasons.values();
//		for(Seasons season : mySeasons){
//			System.out.println(season);
//		}
		System.out.println(Arrays.toString(mySeasons));
	}
	
	public static void test2(){
		Sex male = Sex.MALE;
		System.out.println(male);
		System.out.println("=======================================");
		Sex[] sexes = Sex.values();
		for(Sex s:sexes){
			System.out.println(s);
		}
	}

}
