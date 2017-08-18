package com.zhiyou100.collections.homework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.io.Console;
import java.util.regex.Pattern;

import com.zhiyou100.collections.homework.entity.JuniorStudent;

public class Client {

	public static void main(String[] args) {
		String inStr = null;//该变量用来接收命令行输入的数据
		
		/*
		 * 获取命令行的一个客户端，该方式不能在eclipse等IDE工具下
		 * 使用，只能通过新打开的终端来使用。
		 */
		Console console = System.console();
		
		/*
		 * 读入命令行输入的一行数据
		 */
		inStr = console.readLine();
		while (inStr!=null) {
			if("quit".equals(inStr)){//如果命令行输入的是quit则退出循环
				break;
			}
			if(isSerialNum(inStr)){//如果是学号，则按学号查找
				List<JuniorStudent> scoreList =  getScoreInfoBySerialNum(inStr);
				printScore(scoreList);
			}else{//如果是班级号，则按班级号查找，？输入的什么也不是，这么处理？
				List<JuniorStudent> scoreList =  getScoreInfoByClassNum(inStr);
				printScore(scoreList);
			}
			/*
			 * 每次查找完之后，重新接受一个新的输入
			 */
			inStr = console.readLine();
		}
	}

	/**
	 * 打印找到的学生成绩数据
	 * @param scoreList
	 */
	public static void printScore(List<JuniorStudent> scoreList) {
		String result = Arrays.toString(scoreList.toArray());
		System.out.println(result);
	}
	
	/**
	 * 根据班级号查找学生成绩数据
	 * @param inStr
	 * @return
	 */
	private static List<JuniorStudent> getScoreInfoByClassNum(String inStr) {
		return InitData.dbMap.get(inStr);
	}

	/**
	 * 根据学号查找学生成绩数据
	 * @param inStr
	 * @return
	 */
	private static List<JuniorStudent> getScoreInfoBySerialNum(String inStr) {
		/*
		 * 临时list用来封装所有班级学生的成绩
		 */
		List<JuniorStudent> tempList = new ArrayList<JuniorStudent>();
		/*
		 * 返回结果，由于同一个学号的学生可能有多门考试的成绩，
		 * 所有要用一个list来接收
		 */
		List<JuniorStudent> retList = new ArrayList<JuniorStudent>();
		
		tempList.addAll(InitData.dbMap.get("201601"));
		tempList.addAll(InitData.dbMap.get("201602"));
		tempList.addAll(InitData.dbMap.get("201603"));
		
		for(JuniorStudent stu : tempList){
			/*
			 * 若干找到了对于学号的学生，则放到要返回的List当中
			 */
			if(stu.getSerialNum().equals(inStr)){
				retList.add(stu);
			}
		}
		return retList;
	}

	/**
	 * 判断输入的数据是学号还是班级号，
	 * 如果是学号返回true，否则返回false。
	 * @param inStr 客户输入的参数
	 * @return 是否为学号
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
				throw new NotClassNumOrSerialNumException(inStr +"既不是学号也不是班级号，请确认后重新输入！");
			} catch (NotClassNumOrSerialNumException e) {
				e.printStackTrace();
			}
		}
		return ret;
	}
}
