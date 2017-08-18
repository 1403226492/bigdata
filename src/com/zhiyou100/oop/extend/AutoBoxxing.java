package com.zhiyou100.oop.extend;

public class AutoBoxxing {
	public static void main(String[] args) {
		int i = 3;
		Integer iInteger = new Integer(4);
		Integer iInteger2 = 5;
		Byte bByte = 123;
		Short sShort = 124;
		Long lLong = 234L;
		Float fFloat = 12.12F;
		Double dDouble = 12.23;
		Character cChar = 'A';
		int intValue = iInteger;
		System.out.println(iInteger + iInteger2);
	}
}
