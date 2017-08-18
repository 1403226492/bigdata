package com.zhiyou100.exceptions;

import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;

public class TestException {

	public static void main(String[] args) throws InterruptedException {
		//System.out.println(TestException.add("123", "234.12"));
		// System.out.println(TestException.divide("123", "0"));
		// System.out.println(len(null));
		// String[] objs = {"a","b","c","d"};
		// System.out.println(getObjAt(objs,5));
		// printMsg();
		//anotherPrintMsg();
		
		String msg = null;
		
		if(msg != null){
			System.out.println(msg.length());
		}
	}

	/**
	 * 该方法当传入的参数不能转出成数字的时候，会出现 java.lang.NumberFormatException
	 * 
	 * @param add1
	 * @param add2
	 * @return
	 */
	public static String add(String add1, String add2) {
		BigDecimal ret = new BigDecimal("0");
		BigDecimal num1 = null;
		BigDecimal num2 = null;
		try {
			num1 = new BigDecimal(add1);
			num2 = new BigDecimal(add2);
			ret = num1.add(num2).setScale(2, BigDecimal.ROUND_HALF_UP);
		} catch (NumberFormatException e) {
			e.printStackTrace();
			System.out.println("你输入的数字格式异常，请确认格式！");
			ret = new BigDecimal(Integer.MIN_VALUE);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			System.out.println("程序执行完毕，可以进行剩余的清理工作！");
			num1 = null;
			num2 = null;
		}

		return ret.toString();
	}

	/**
	 * 该方法在除数为0 的情况下，会出现 java.lang.ArithmeticException
	 * 
	 * @param add1
	 * @param add2
	 * @return
	 */
	public static String divide(String add1, String add2) {
		BigDecimal ret = new BigDecimal("0");
		BigDecimal num1 = new BigDecimal(add1);
		BigDecimal num2 = new BigDecimal(add2);
		ret = num1.divide(num2, 2, BigDecimal.ROUND_HALF_UP);
		return ret.toString();
	}

	/**
	 * 根据输入的字符串，得到该字符串的长度 如果输入的参数为null，则出现： java.lang.NullPointerException
	 * 
	 * @param inStr
	 * @return
	 */
	public static int len(String inStr) {
		int len = 0;
		len = inStr.length();
		return len;
	}

	/**
	 * 得到输入数组的指定索引处的对象 如果要获取的对象超过了数组的最大索引，会出现
	 * java.lang.ArrayIndexOutOfBoundsException
	 * 
	 * @param objs
	 * @param index
	 * @return
	 */
	public static Object getObjAt(Object[] objs, int index) {
		Object ret = null;
		ret = objs[index];
		return ret;
	}

	public static void printMsg() {
		while (true) {
			System.out.println(String.format("%tT", System.currentTimeMillis()));
			// Thread.sleep(1000);
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void anotherPrintMsg() throws InterruptedException{
		System.out.println(String.format("%tT", System.currentTimeMillis()));
		TimeUnit.SECONDS.sleep(1);
	}
}
