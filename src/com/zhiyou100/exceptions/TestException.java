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
	 * �÷���������Ĳ�������ת�������ֵ�ʱ�򣬻���� java.lang.NumberFormatException
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
			System.out.println("����������ָ�ʽ�쳣����ȷ�ϸ�ʽ��");
			ret = new BigDecimal(Integer.MIN_VALUE);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			System.out.println("����ִ����ϣ����Խ���ʣ�����������");
			num1 = null;
			num2 = null;
		}

		return ret.toString();
	}

	/**
	 * �÷����ڳ���Ϊ0 ������£������ java.lang.ArithmeticException
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
	 * ����������ַ������õ����ַ����ĳ��� �������Ĳ���Ϊnull������֣� java.lang.NullPointerException
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
	 * �õ����������ָ���������Ķ��� ���Ҫ��ȡ�Ķ��󳬹����������������������
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
