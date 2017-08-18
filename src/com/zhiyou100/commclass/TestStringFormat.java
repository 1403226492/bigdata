package com.zhiyou100.commclass;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class TestStringFormat {
	public static void main(String[] args) {
		double num = 1234567.7654321;
		String doubleFormatted = String.format("%8.2e", num);
		System.out.println(doubleFormatted);
		doubleFormatted = String.format("%g", num);
		System.out.println(doubleFormatted);
	}

	public static void testIntFormat() {
		int num = 1234567;
		String formattedNum = String.format("%0,10d", num);
		System.out.println(formattedNum);
		formattedNum = String.format("%10o", num);
		System.out.println(formattedNum);
		formattedNum = String.format("%10x", num);
		System.out.println(formattedNum);
	}

	public static void testFormatString() {
		String string = "hello";
		String formattedStr = String.format("%10s", string);
		System.out.println(formattedStr);
		System.out.println("1234567890");
		formattedStr = String.format("%-10s", string);
		System.out.println(formattedStr);
	}
	
	@SuppressWarnings("unused")
	private static void testFormatDate(){
		Calendar cal = Calendar.getInstance();
		String formattedDate = String.format("%1$tF %1$tT %2$tD %2$tr", cal,cal);
		System.out.println(formattedDate);
		
		formattedDate =String.format("%1$tY年 %1$tm月%1$td日%1$tH时%1$tM分%1$tS秒", cal);
		System.out.println(formattedDate);
		//2016年07月27日10时43分20秒
		System.out.println(formatChineseDate(cal));
	}
	private static String formatChineseDate(Calendar c){
		DateFormat format = new SimpleDateFormat("yyyy年MM月dd日HH时mm分ss秒");
		String ret = format.format(c.getTime());
		return ret;
	}
}
