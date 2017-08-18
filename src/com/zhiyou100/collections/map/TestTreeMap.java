package com.zhiyou100.collections.map;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

import com.zhiyou100.collections.set.entity.Student;

public class TestTreeMap {
	public static void main(String[] args) {
		Map<Student, String> treeMap = new TreeMap<>(new Comparator<Student>() {
			@Override
			public int compare(Student o1, Student o2) {
				int ret = 0;
				if(o1 == null && o2 != null){
					ret = 2;
				}
				if(o1 !=null && o2 == null){
					ret = -2;
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
		
		Student stu = new Student("20107073", "��������ѧ", "˾���", "��Ϣ����ѧԺ", 34);
		treeMap.put(stu, "��������");
        stu = new Student("20107074", "�׶�ʦ����ѧ", "��ȥ��", "�ķ�ѧԺ", 44);
		treeMap.put(stu, "ɽ���ӻ���");
		stu = new Student("20107072", "����ʦ��ѧԺ", "��Ѳ", "��ѧѧԺ", 44);
		treeMap.put(stu, "��¸�");
		stu = new Student("3", "������", "��Ӿ�", "��Ϣ�������", 30);
		treeMap.put(stu, "����֣��");
		
		Set<Entry<Student, String>> entrySet = treeMap.entrySet();
		
		for(Entry<Student, String> entry : entrySet){
			System.out.println(entry.getKey() +" = " + entry.getValue());
		}
		
		System.out.println("==========================================================");
		Set<Student> keys = treeMap.keySet();
		for(Student  student : keys){
			System.out.println(student + " : " + treeMap.get(student));
		}
		
		
		System.out.println("==========================================================");
		
		Iterator<Student> iter = treeMap.keySet().iterator();
		Student temp = null;
		for(;iter.hasNext();){
			temp = iter.next();
			System.out.println(temp + treeMap.get(temp));
		}
		
//		while(iter.hasNext()){
//			
//		}
//		
//		for(int i=0,j=6;i<10;i++){
//			
//		}
		
		/*
		 * for����ѭ��
		 */
//		for(;;){
//			System.out.println(System.currentTimeMillis());
//			try {
//				Thread.sleep(100);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//		}
	}
}
