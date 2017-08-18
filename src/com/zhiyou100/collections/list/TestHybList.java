package com.zhiyou100.collections.list;

public class TestHybList {

	public static void main(String[] args) {
		IList<Integer> myList = new HybList<Integer>();
		for(int i=0;i<100;i++){
			myList.add(i);//自动打包
		}
		
		for(int j=0;j<myList.size();j++){
			System.out.println("打印结果为：" + j);
		}
		
		System.out.println(myList.indexOf(4));
		System.out.println(myList.contains(8));
		
	}

}
