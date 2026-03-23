package com.tek.dsa;

import java.util.Stack;

public class StackStringReversal {
	public static void main(String[] args) {
		String str = "HELLO";
		Stack<Character> stack = new Stack<>();

		for (int i = 0; i < str.length(); i++) {
			stack.push(str.charAt(i));
		}
		while (!stack.isEmpty()) {
			System.out.println(stack.pop());
		}
	}

}
