package com.zhiyou100.collections.homework;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.zhiyou100.collections.homework.entity.JuniorStudent;

public class InitData {
	private static final List<JuniorStudent> classOneList = new ArrayList<JuniorStudent>();
	private static final List<JuniorStudent> classTwoList = new ArrayList<JuniorStudent>();
	private static final List<JuniorStudent> classThreeList = new ArrayList<JuniorStudent>();
	public static final Map<String, List<JuniorStudent>> dbMap = new HashMap<String, List<JuniorStudent>>();

	/**
	 * ͨ����̬��ʼ�����ʼ����������
	 */
	static {
		intClassOne();
		intClassTwo();
		intClassThree();
		
		dbMap.put("201601", classOneList);
		dbMap.put("201602", classTwoList);
		dbMap.put("201603", classThreeList);
		
	}

	private static void intClassOne() {
		JuniorStudent student = new JuniorStudent("20160101", "����", "���Դ���", 59.5);
		classOneList.add(student);
		student = new JuniorStudent("20160101", "����", "��ѧӢ��", 62);
		classOneList.add(student);
		student = new JuniorStudent("20160102", "����", "��ѧӢ��", 63);
		classOneList.add(student);
		student = new JuniorStudent("20160103", "����", "��ѧӢ��", 65);
		classOneList.add(student);
	}

	private static void intClassTwo() {
		JuniorStudent student = new JuniorStudent("20160201", "����", "���Դ���", 59.5);
		classTwoList.add(student);
		student = new JuniorStudent("20160201", "����", "��ѧӢ��", 62);
		classTwoList.add(student);
		student = new JuniorStudent("20160202", "����", "��ѧӢ��", 63);
		classTwoList.add(student);
		student = new JuniorStudent("20160203", "����", "��ѧӢ��", 65);
		classTwoList.add(student);
	}

	private static void intClassThree() {
		JuniorStudent student = new JuniorStudent("20160301", "����", "���Դ���", 59.5);
		classThreeList.add(student);
		student = new JuniorStudent("20160301", "����", "��ѧӢ��", 62);
		classThreeList.add(student);
		student = new JuniorStudent("20160302", "����", "��ѧӢ��", 63);
		classThreeList.add(student);
		student = new JuniorStudent("20160303", "����", "��ѧӢ��", 65);
		classThreeList.add(student);
	}
}
