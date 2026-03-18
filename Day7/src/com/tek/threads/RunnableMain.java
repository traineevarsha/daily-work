package com.tek.threads;

public class RunnableMain {
	public static void main(String[] args) {
		Thread thread = new Thread(new MyTask());
		thread.start();
	}

}
