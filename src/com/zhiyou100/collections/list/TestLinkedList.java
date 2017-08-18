package com.zhiyou100.collections.list;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class TestLinkedList {

	public static void main(String[] args) {
		List<Integer> myList = new LinkedList<Integer>();
		int i = 1;
		myList.add(i++);
		myList.add(i++);
		myList.add(i++);
		myList.add(i++);
		myList.add(i++);
		myList.add(i++);
		myList.add(i++);
		myList.add(i++);
		myList.add(i++);
		myList.add(i++);
		
		System.out.println(Arrays.toString(myList.toArray()));
		LinkedList<Integer> myLinkedList = (LinkedList<Integer>) myList;
		
		myLinkedList.pollFirst();
		System.err.println(Arrays.toString(myLinkedList.toArray()));
		
		myLinkedList.pollLast();
		System.out.println(Arrays.toString(myLinkedList.toArray()));
	}

}
