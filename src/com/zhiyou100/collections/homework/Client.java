package com.zhiyou100.collections.homework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.io.Console;
import java.util.regex.Pattern;

import com.zhiyou100.collections.homework.entity.JuniorStudent;

public class Client {

	public static void main(String[] args) {
		String inStr = null;//�ñ��������������������������
		
		/*
		 * ��ȡ�����е�һ���ͻ��ˣ��÷�ʽ������eclipse��IDE������
		 * ʹ�ã�ֻ��ͨ���´򿪵��ն���ʹ�á�
		 */
		Console console = System.console();
		
		/*
		 * ���������������һ������
		 */
		inStr = console.readLine();
		while (inStr!=null) {
			if("quit".equals(inStr)){//����������������quit���˳�ѭ��
				break;
			}
			if(isSerialNum(inStr)){//�����ѧ�ţ���ѧ�Ų���
				List<JuniorStudent> scoreList =  getScoreInfoBySerialNum(inStr);
				printScore(scoreList);
			}else{//����ǰ༶�ţ��򰴰༶�Ų��ң��������ʲôҲ���ǣ���ô����
				List<JuniorStudent> scoreList =  getScoreInfoByClassNum(inStr);
				printScore(scoreList);
			}
			/*
			 * ÿ�β�����֮�����½���һ���µ�����
			 */
			inStr = console.readLine();
		}
	}

	/**
	 * ��ӡ�ҵ���ѧ���ɼ�����
	 * @param scoreList
	 */
	public static void printScore(List<JuniorStudent> scoreList) {
		String result = Arrays.toString(scoreList.toArray());
		System.out.println(result);
	}
	
	/**
	 * ���ݰ༶�Ų���ѧ���ɼ�����
	 * @param inStr
	 * @return
	 */
	private static List<JuniorStudent> getScoreInfoByClassNum(String inStr) {
		return InitData.dbMap.get(inStr);
	}

	/**
	 * ����ѧ�Ų���ѧ���ɼ�����
	 * @param inStr
	 * @return
	 */
	private static List<JuniorStudent> getScoreInfoBySerialNum(String inStr) {
		/*
		 * ��ʱlist������װ���а༶ѧ���ĳɼ�
		 */
		List<JuniorStudent> tempList = new ArrayList<JuniorStudent>();
		/*
		 * ���ؽ��������ͬһ��ѧ�ŵ�ѧ�������ж��ſ��Եĳɼ���
		 * ����Ҫ��һ��list������
		 */
		List<JuniorStudent> retList = new ArrayList<JuniorStudent>();
		
		tempList.addAll(InitData.dbMap.get("201601"));
		tempList.addAll(InitData.dbMap.get("201602"));
		tempList.addAll(InitData.dbMap.get("201603"));
		
		for(JuniorStudent stu : tempList){
			/*
			 * �����ҵ��˶���ѧ�ŵ�ѧ������ŵ�Ҫ���ص�List����
			 */
			if(stu.getSerialNum().equals(inStr)){
				retList.add(stu);
			}
		}
		return retList;
	}

	/**
	 * �ж������������ѧ�Ż��ǰ༶�ţ�
	 * �����ѧ�ŷ���true�����򷵻�false��
	 * @param inStr �ͻ�����Ĳ���
	 * @return �Ƿ�Ϊѧ��
	 */
	private static boolean isSerialNum(String inStr){
		boolean ret = false;
		Pattern SerialNumPattern = Pattern.compile("\\d{8}");
		Pattern classPattern = Pattern.compile("\\d{6}");
		
		if(SerialNumPattern.matcher(inStr).matches()){
			ret = true;
		}else if(classPattern.matcher(inStr).matches()){
			ret = false;
		}else{
			try {
				throw new NotClassNumOrSerialNumException(inStr +"�Ȳ���ѧ��Ҳ���ǰ༶�ţ���ȷ�Ϻ��������룡");
			} catch (NotClassNumOrSerialNumException e) {
				e.printStackTrace();
			}
		}
		return ret;
	}
}
