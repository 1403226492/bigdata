package com.zhiyou100.gui;

import java.sql.SQLNonTransientConnectionException;

public class DB {
	public static Object[] columnsName;
	public static Object[][] data;
	
	static{
		columnsName = new Object[] {
				"����",
				"ѧ��",
				"�ɼ�",
				"����"
		};
		
		data = new Object[][]{
			{"�ŷ�","����","30","2016-07-26"},
			{"�ŷ�","��ѧ","40","2016-07-26"},
			{"����","����","50","2016-07-26"},
			{"����","��ѧ","80","2016-07-26"}
		};
	}
}
