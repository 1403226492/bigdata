package com.zhiyou100.gui;

import java.sql.SQLNonTransientConnectionException;

public class DB {
	public static Object[] columnsName;
	public static Object[][] data;
	
	static{
		columnsName = new Object[] {
				"姓名",
				"学科",
				"成绩",
				"日期"
		};
		
		data = new Object[][]{
			{"张飞","语文","30","2016-07-26"},
			{"张飞","数学","40","2016-07-26"},
			{"刘备","语文","50","2016-07-26"},
			{"刘备","数学","80","2016-07-26"}
		};
	}
}
