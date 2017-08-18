package com.zhiyou100.exceptions;

public class AgeExceedLimitException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 608959018801798682L;

	private int age;
	
	public AgeExceedLimitException() {
	}

	public AgeExceedLimitException(String message,int age) {
		super(message);
		this.age = age;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}
