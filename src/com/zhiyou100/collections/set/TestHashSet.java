package com.zhiyou100.collections.set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import com.zhiyou100.collections.set.entity.Student;

public class TestHashSet {

	public static void main(String[] args) {
		Set<Student> students = new HashSet<Student>();
		Student stu = new Student("201605031024", "���ϴ�ѧ", "��Ӿ�", "����ѧԺ", 31);
		students.add(stu);
		stu = new Student("201605031025", "���ϴ�ѧ", "ҩ����", "����ѧԺ", 33);
		students.add(stu);
		
		stu = new Student("201605031026", "֣�ݴ�ѧ", "˾���", "��Ϣ����ѧԺ", 32);
		students.add(stu);
		
		stu = new Student("201605031027", "��ž���Ϣ���̴�ѧ", "��ź�", "½��װ��ѧԺ", 38);
		students.add(stu);
		
		for(Student s : students){
			System.out.println(s);
		}
		
		stu = new Student("201605031027", "��ž���Ϣ���̴�ѧ", "��ź�", "½��װ��ѧԺ", 38);
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
