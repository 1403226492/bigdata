package com.zhiyou100.oop;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestDate {
	
	public static void main(String[] args) {
		Date currentDate = new Date();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println(df.format(currentDate));
	}

}
