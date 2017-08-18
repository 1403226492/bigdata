package com.zhiyou100.regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestRegExp2 {
	public static void main(String[] args) {
		String target = "abcdefgabcdefabcabcxyz发送到";
		//Pattern pattern = Pattern.compile("[a-z]{2,}");
		//Pattern pattern = Pattern.compile("[abcdefg]+");
//		Pattern pattern = Pattern.compile("[^xyz]+");
		//Pattern pattern = Pattern.compile("abc");//贪婪模式，默认的模式
		Pattern pattern = Pattern.compile("(abc)\\1");
		Matcher matcher = pattern.matcher(target);
		
		StringBuffer sb = new StringBuffer();
		while (matcher.find()) {
			matcher.appendReplacement(sb, "@");
		}
		matcher.appendTail(sb);
		System.out.println(sb);
		System.out.println(matcher.matches());
	}
}
