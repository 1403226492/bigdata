package com.zhiyou100.regexp;

public class TestRegExp {
	public static void main(String[] args) {
		String content = "葡萄美酒夜光杯，abcdefsdf，古来征战几人还13437766545";
//		System.out.println(getChineseChar(content));
//		System.out.println(getNumChar(content));
//		System.out.println(replaceChineseChar(content));
		
		String noChineseStr = content.replaceAll("[\u4e00-\u9fa5]", "\\$");
		System.out.println(noChineseStr);
		System.out.println(content);
		String numStr = content.replaceAll("[0-9]", "*");
		System.out.println(numStr);
	}
	
	public static String getChineseChar(String content){
		String ret = "";
		if(content == null || content.trim().equals("")){
			ret = null;
		}else{
			/*
			 *变量的定义要在必须要使用的时候定义
			 *之所以不放到开头的地方去定义，是因为
			 *该数组可能压根就用不到。 
			 */
			char[] arrays = content.toCharArray();
			for (int i = 0; i < arrays.length; i++) {
				if(arrays[i]>255){
					ret = ret + arrays[i];
				}
			}
		}
		return ret;
	}
	
	
	public static String replaceChineseChar(String content){
		String ret = "";
		if(content == null || content.trim().equals("")){
			ret = null;
		}else{
			char[] arrays = content.toCharArray();
			char[] tempArr = new char[content.length()];
			for (int i = 0; i < arrays.length; i++) {
				if(arrays[i]>255){
					tempArr[i]='$';
				}else{
					tempArr[i] = arrays[i];
				}
			}
			ret = new String(tempArr);
		}
		return ret;
	}
	public static String getNumChar(String content){
		String ret = "";
		if(content == null || content.trim().equals("")){
			ret = null;
		}else{
			/*
			 *变量的定义要在必须要使用的时候定义
			 *之所以不放到开头的地方去定义，是因为
			 *该数组可能压根就用不到。 
			 */
			char[] arrays = content.toCharArray();
			for (int i = 0; i < arrays.length; i++) {
				if(arrays[i]>=48 && arrays[i] <=57){
					ret = ret + arrays[i];
				}
			}
		}
		return ret;
	}
}
