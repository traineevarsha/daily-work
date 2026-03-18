package com.tek.threads;

public class MyThread extends Thread {
	@Override
	public void run() {
		try {
			sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Worker thread is runnning");
	}

}
