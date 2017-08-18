package com.zhiyou100.commclass;

import java.io.Console;
import java.util.Arrays;
import java.util.Map;
import java.util.Properties;

public class SystemClass {
	public static void main(String[] args) {
		//testArrayCopy();
		//testConsole();
		//testExit();
		
		String path = System.getenv("path");
		System.out.println(path);
		
		Map<String, String> envMap = System.getenv();
		for (Map.Entry<String, String> e : envMap.entrySet()) {
			System.out.println(e.getKey() +"=" + e.getValue());
		}
		
		String userDir = System.getProperty("user.dir");
		System.out.println(userDir);
		
		Properties props = System.getProperties();
		
		for(Map.Entry<Object, Object> e:props.entrySet()){
			System.err.println(e.getKey() +"=" + e.getValue());
		}
	}

	public static void testExit() {
		System.out.println(System.currentTimeMillis());
		System.exit(0);//������ǿ�ƹػ�����ߵĴ��벻��ִ��
		System.out.println("abcccccccccccccccccc");
	}

	public static void testConsole() {
		Console console = System.console();
		String line = console.readLine();
		while(!"quit".equals(line)){
			System.out.println("��ã�������������ǣ�" + line);
			line = console.readLine();
		}
	}

	/**
	 * 
	 * ��һ�����鸳ֵ���ݵ����������
	 */
	public static void testArrayCopy() {
		int[] source = {1,2,3,4,5,6};
		int[] target = new int[10];
		System.arraycopy(source, 0, target, 0, source.length);
		System.out.println(Arrays.toString(target));
	}
}
