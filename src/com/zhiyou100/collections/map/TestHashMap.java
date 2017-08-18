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

		myMap.put("张三", "70");
		myMap.put("李四", "80");
		myMap.put("王五", "90");
		myMap.put("赵六", "60");
		myMap.put("吴起", "78");
		
		System.out.println(myMap.containsKey("张三"));
		System.out.println(myMap.containsValue("100"));
	}

	public static void testInterator() {
		Map<String, String> myMap = new HashMap<String, String>();

		myMap.put("张三", "70");
		myMap.put("李四", "80");
		myMap.put("王五", "90");
		myMap.put("赵六", "60");
		myMap.put("吴起", "78");
		
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

		myMap.put("张三", "70");
		myMap.put("张三", "80");
		myMap.put("张三", "90");
		myMap.put("张三", "60");
		myMap.put("张三", "78");

		/*
		 * key相同的时候，HashMap运行放入元素 但是新放入的元素会把老放入的元素给覆盖掉。
		 */
		System.out.println(myMap.get("张三"));
	}
}
