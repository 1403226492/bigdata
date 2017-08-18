package com.zhiyou100.oop.homework.util;

import java.math.BigDecimal;

public class MathUtils {
	public static String add(String num1,String num2){
		BigDecimal ret = new BigDecimal("0");
		BigDecimal add1 = new BigDecimal(num1);
		BigDecimal add2 = new BigDecimal(num2);
		ret = add1.add(add2).setScale(2, BigDecimal.ROUND_HALF_UP);
		return ret.toString();
	}
	public static String subtract(String num1,String num2){
		BigDecimal ret = new BigDecimal("0");
		BigDecimal add1 = new BigDecimal(num1);
		BigDecimal add2 = new BigDecimal(num2);
		ret = add1.subtract(add2).setScale(2, BigDecimal.ROUND_HALF_UP);
		return ret.toString();
	}
	
	public static String mutiply(String num1,String num2){
		BigDecimal ret = new BigDecimal("0");
		BigDecimal add1 = new BigDecimal(num1);
		BigDecimal add2 = new BigDecimal(num2);
		ret = add1.multiply(add2).setScale(2, BigDecimal.ROUND_HALF_UP);
		return ret.toString();
	}
	
	public static String divide(String num1,String num2){
		BigDecimal ret = new BigDecimal("0");
		BigDecimal add1 = new BigDecimal(num1);
		BigDecimal add2 = new BigDecimal(num2);
		ret = add1.divide(add2,2,BigDecimal.ROUND_HALF_UP);
		return ret.toString();
	}
}
