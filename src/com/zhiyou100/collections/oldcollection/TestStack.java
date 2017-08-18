package com.zhiyou100.collections.oldcollection;

import java.util.Stack;

public class TestStack {

	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		
		System.out.println(stack);
		stack.pop();
		System.out.println(stack);
		Integer peek = stack.peek();
		System.out.println(stack);
	}

}
