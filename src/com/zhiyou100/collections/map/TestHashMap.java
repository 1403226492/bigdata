package com.zhiyou100.collections.map;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class TestHashMap {
	public static void main(String[] args) {
		
		Map<String, String> myMap = new HashMap<String, String>();

		myMap.put("����", "70");
		myMap.put("����", "80");
		myMap.put("����", "90");
		myMap.put("����", "60");
		myMap.put("����", "78");
		
		System.out.println(myMap.containsKey("����"));
		System.out.println(myMap.containsValue("100"));
	}

	public static void testInterator() {
		Map<String, String> myMap = new HashMap<String, String>();

		myMap.put("����", "70");
		myMap.put("����", "80");
		myMap.put("����", "90");
		myMap.put("����", "60");
		myMap.put("����", "78");
		
		Set<Entry<String, String>> entrySet = myMap.entrySet();
		
		for(Entry<String, String> entry : entrySet){
			System.out.println(entry.getKey() +" : " + entry.getValue());
		}
		
		System.out.println("===================================");
		Set<String> keySet = myMap.keySet();
		
		for(String key : keySet){
			System.out.println(key +" = " + myMap.get(key));
		}
		
		Collection<String>  valueCollection = myMap.values();
		Iterator<String> iter = valueCollection.iterator();
		
		String value = null;
		for(;iter.hasNext();) {
			 value = iter.next();
			 System.out.println(value);
		}
	}

	public static void testSameKey() {
		Map<String, String> myMap = new HashMap<String, String>();

		myMap.put("����", "70");
		myMap.put("����", "80");
		myMap.put("����", "90");
		myMap.put("����", "60");
		myMap.put("����", "78");

		/*
		 * key��ͬ��ʱ��HashMap���з���Ԫ�� �����·����Ԫ�ػ���Ϸ����Ԫ�ظ����ǵ���
		 */
		System.out.println(myMap.get("����"));
	}
}
