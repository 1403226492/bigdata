package com.zhiyou100.collections.oldcollection;

import java.util.Enumeration;
import java.util.Vector;

public class TestVector {

	public static void main(String[] args) {
		Vector<Integer> vector = new Vector<Integer>();
		
		vector.addElement(1);
		vector.add(2);
		vector.add(1, 3);
		
		Enumeration<Integer> enumer = vector.elements();
		while(enumer.hasMoreElements()){
			System.out.println(enumer.nextElement());
		}
		
		System.out.println(vector.elementAt(1));
	}

}
