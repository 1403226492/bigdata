package com.zhiyou100.collections.set;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

import com.zhiyou100.collections.set.entity.Student;

public class TestTreeSet {

	public static void main(String[] args) {
		Set<Student> students = new TreeSet<Student>(new  Comparator<Student>() {
			@Override
			public int compare(Student o1, Student o2) {
				int ret = 0;
				if(o1 == null && o2 != null){
					ret = 1;
				}
				if(o1 != null && o2 == null){
					ret = -1;
				}
				if(o1 == null && o2 == null){
					ret = 0;
				}
				if(o1 != null && o2 != null){
					ret = o1.getSerialNum().compareTo(o2.getSerialNum());
				}
				return ret;
			}
		});
		Student stu = new Student("201605031024", "河南大学", "马加爵", "化工学院", 31);
		students.add(stu);
		stu = new Student("201605031025", "河南大学", "药家鑫", "化工学院", 33);
		students.add(stu);
		
		stu = new Student("201605031026", "郑州大学", "司马光", "信息管理学院", 32);
		students.add(stu);
		
		stu = new Student("201605031027", "解放军信息工程大学", "徐才厚", "陆军装备学院", 38);
		students.add(stu); 
		Student student = null;
		for (Iterator<Student> iterator = students.iterator(); iterator.hasNext();) {
			 student =  iterator.next();
			 System.out.println(student);
		}
		
		System.out.println("=======================================");
		
		
		TreeSet<Student> newSet = (TreeSet<Student>) students;		
		
//		for (Iterator<Student> iterator = newSet.descendingIterator(); iterator.hasNext();) {
//			 student =  iterator.next();
//			 System.out.println(student);
//		}
		
		
		Set<Student> mySet = newSet.headSet(new Student("201605031026", "郑州大学", "司马光", "信息管理学院", 32), false);
		for (Iterator<Student> iterator = mySet.iterator(); iterator.hasNext();) {
			Student student2 = iterator.next();
			System.out.println(student2);
			
		}
		System.out.println("=======================================");
		Set<Student> mySet2 = newSet.headSet(new Student("201605031026", "郑州大学", "司马光", "信息管理学院", 32));
		for (Iterator<Student> iterator = mySet2.iterator(); iterator.hasNext();) {
			Student student3 = iterator.next();
			System.out.println(student3);
		}
	}

}
