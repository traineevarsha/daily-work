package com.tek.threads;

public class Main {
	public static void main(String[] args) throws InterruptedException {
		// 1.using thread class
		Thread t1 = new MyThread();
		t1.start();
		t1.join();
		System.out.println("main");

		// 2. Using runnable interface
		Thread task = new Thread(new MyTask());
		task.start();
	}
}
