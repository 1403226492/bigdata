package com.zhiyou100.regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestRegExp3 {

	public static void main(String[] args) {
		String target = "abcdefgabcdefabcabcxyz���͵�";
		Pattern pattern = Pattern.compile("(abc)(def)");
		Matcher matcher = pattern.matcher(target);
		String group = "";
		while (matcher.find()) {//group�������Ǵ�1��ʼ�ģ���һ�����ҵ����ž��м���group
			group = matcher.group(2);
			System.out.println(group);
		}
		
	}

}
