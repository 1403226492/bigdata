package com.zhiyou100.oop;
import java.util.Date;
import java.util.Calendar;
public class HomeWork{
	private static final int PEROID_MONTH = 1;
	private static final int PEROID_DAY = 2;
	
	public static Date getPeriodDate(int type,int nums){
		Calendar calendar = Calendar.getInstance();
		Date currentDate = calendar.getTime();
		return getPeriodDate(currentDate,type,nums);
	}
	
	public static Date getPeriodDate(Date date,int type,int nums){
		Date ret = null;
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		if(type == HomeWork.PEROID_MONTH){
			cal.add(Calendar.MONTH,nums);
			ret = cal.getTime();
		}else if(type == PEROID_DAY){
			cal.add(Calendar.DAY_OF_MONTH,nums);
			ret = cal.getTime();
		}else{
			ret = new Date();
		}
		
		return ret;
	}
	
	public static void main(String[] args){
		Date realDate = getPeriodDate(HomeWork.PEROID_DAY,-7);
		System.out.println(String.format("%1$tF %1$tT",realDate));
	}
}