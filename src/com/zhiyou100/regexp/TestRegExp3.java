package com.zhiyou100.regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestRegExp3 {

	public static void main(String[] args) {
		String target = "abcdefgabcdefabcabcxyz发送到";
		Pattern pattern = Pattern.compile("(abc)(def)");
		Matcher matcher = pattern.matcher(target);
		String group = "";
		while (matcher.find()) {//group的索引是从1开始的，有一个向右的括号就有几个group
			group = matcher.group(2);
			System.out.println(group);
		}
		
	}

}
