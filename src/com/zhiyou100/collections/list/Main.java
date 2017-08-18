package com.zhiyou100.collections.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		List<Integer> myList = new ArrayList<Integer>();
		
		for(int i=0;i<100;i++){
			myList.add(i);
		}
		
		//testInit(myList);
		
		Iterator<Integer> iterator = myList.iterator();
		for(;iterator.hasNext();){
			System.out.println(iterator.next());
		}
		
		for(Integer temp : myList){
			System.err.println(temp);
		}
	}

	public static void testInit(List<Integer> myList) {
		for(int i=0;i<myList.size();i++){
			System.out.println(myList.get(i));
		}
		
		for(int i=100;i>0;i--){
			myList.remove(i);
		}
		
		for(int i=0;i<myList.size();i++){
			System.out.println(myList.get(i));
		}
	}

}
