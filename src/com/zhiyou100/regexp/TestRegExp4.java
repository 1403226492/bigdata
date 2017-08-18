package com.zhiyou100.regexp;

import java.util.regex.Pattern;

public class TestRegExp4 {
	public static void main(String[] args) {
		String mobile = "17739445432";
		System.out.println(checkMobile(mobile));
		
		System.out.println(checkPassword("12Ax,@"));
		System.out.println(checkMyPassword("AABb33dD333"));
		System.out.println(replaceStr("高高兴兴乐乐呵呵开开心心"));
		System.out.println(checkEmail("abc@163.com"));
	}
	
	public static boolean checkMobile(String inStr){
		Pattern pattern = Pattern.compile("13[0-9]\\d{8}|15\\d{9}|17\\d{9}|18\\d{9}");
		return pattern.matcher(inStr).matches();
	}
	
	public static boolean checkPassword(String inStr){
		Pattern pattern = Pattern.compile("\\S{6,14}");
		return pattern.matcher(inStr).matches();
	}
	
	/**
	 * 必须包含大小写字母，数字，并且长度在8-20之间
	 * @param inStr
	 * @return
	 */
	public static boolean checkMyPassword(String inStr){
		Pattern pattern = Pattern.compile("[A-Z]+[a-z]+[0-9]+[\\w&&[^_]]*{8,20}|[A-Z]+[0-9]+[a-z]+[\\w&&[^_]]*{8,20}|[0-9]+[A-Z]+[a-z]+[\\w&&[^_]]*{8,20}|[0-9]+[a-z]+[A-Z]+[\\w&&[^_]]*{8,20}|[a-z]+[0-9]+[A-Z]+[\\w&&[^_]]*{8,20}|[a-z]+[A-Z]+[0-9]+[\\w&&[^_]]*{8,20}");
		return pattern.matcher(inStr).matches();
	}
	
	public static boolean checkEmail(String inStr){
		Pattern pattern = Pattern.compile("^\\w+@[a-zA-Z0-9]+\\.com|net|cn|org[\\.cn|hk|tw|jp]");
		return pattern.matcher(inStr).matches();
	}
	
	/**
	 * 高高兴兴乐乐呵呵欢欢喜喜
	 * 高兴乐呵欢喜
	 * 参数可以任意传入，如aabbccdd替换成abcd
	 * @param inStr
	 * @return
	 */
	public static String replaceStr(String inStr){
		return inStr.replaceAll("(.)\\1", "$1");
	}
}
