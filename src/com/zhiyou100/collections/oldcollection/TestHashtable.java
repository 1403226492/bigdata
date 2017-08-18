package com.zhiyou100.collections.oldcollection;

import java.util.Collection;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Map.Entry;
import java.util.Set;

import com.zhiyou100.collections.set.entity.Student;


public class TestHashtable {

	public static void main(String[] args) {
		Hashtable<String, Student> table = new Hashtable<String, Student>();
		table.put("zhangsan", new Student("20101212", "智游培训学校", "张三", "大数据培训班", 22));
		table.put("lisi", new Student("20101213", "智游培训学校", "李四", "大数据培训班", 22));
		table.put("zhangsan", new Student("20101214", "智游培训学校", "王五", "大数据培训班", 22));
		
		Enumeration<Student> students = table.elements();
		Student stu = null;
		for(;students.hasMoreElements();){
			stu = students.nextElement();
			System.out.println(stu);
		}
		System.out.println("============================================");
		
		Collection<Student> collection = table.values();
		for(Student s : collection){
			System.out.println(s);
		}
		
		System.out.println("============================================");
		Enumeration<String> keys = table.keys();
		String key = null;
		
		while (keys.hasMoreElements()) {
			key =  keys.nextElement();
			System.out.println(key +" = " + table.get(key));
		}
		System.out.println("============================================");
		Set<Entry<String, Student>>  entrys = table.entrySet();
		for(Entry<String, Student> entry : entrys){
			System.out.println(entry.getKey() +"=" + entry.getValue());
		}
		System.out.println("============================================");
		Set<String> keySet = table.keySet();
		for(String  k : keySet){
			System.out.println(k +" : " + table.get(k));
		}
		
	}

}
