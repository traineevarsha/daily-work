package com.tek.dsa;

public class StackUsingArray {
	int top = -1;
	int size = 5;
	int[] stack = new int[size];

	void push(int element) {
		if (top == size - 1) {
			System.out.println("Stack overflow");
		} else {
			stack[++top] = element;
		}
	}

	int pop() {
		if (top == -1) {
			System.out.println("Stack is empty - underflow");
			return -1;
		} else {
			return stack[top--];
		}
	}

	int peek() {
		if (top == -1) {
			System.out.println("Stack is empty");
			return -1;
		} else {
			return stack[top];
		}
	}

	public static void main(String[] args) {
		StackUsingArray st = new StackUsingArray();
		st.push(10);
		st.push(50);
		st.push(66);
		st.push(22);

		System.out.println(st.pop());
		System.out.println(st.peek());

	}
}
