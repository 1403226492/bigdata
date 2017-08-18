package com.zhiyou100.collections.set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import com.zhiyou100.collections.set.entity.Student;

public class TestHashSet {

	public static void main(String[] args) {
		Set<Student> students = new HashSet<Student>();
		Student stu = new Student("201605031024", "河南大学", "马加爵", "化工学院", 31);
		students.add(stu);
		stu = new Student("201605031025", "河南大学", "药家鑫", "化工学院", 33);
		students.add(stu);
		
		stu = new Student("201605031026", "郑州大学", "司马光", "信息管理学院", 32);
		students.add(stu);
		
		stu = new Student("201605031027", "解放军信息工程大学", "徐才厚", "陆军装备学院", 38);
		students.add(stu);
		
		for(Student s : students){
			System.out.println(s);
		}
		
		stu = new Student("201605031027", "解放军信息工程大学", "徐才厚", "陆军装备学院", 38);
		students.add(stu);
		System.out.println("===========================================================");
		for(Student s : students){
			System.out.println(s);
		}
		
		System.out.println("===========================================================");
		
		Iterator<Student> iter = students.iterator();
		
		while (iter.hasNext()) {
			System.out.println(iter.next());
		}
	}

}
