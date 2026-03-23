package com.tek.dsa;

public class ArraySecLarg {
	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5, 6 };
		int largest = Integer.MIN_VALUE;
		int second = Integer.MIN_VALUE;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > largest) {
				second = largest;
				largest = arr[i];

			} else if (arr[i] > second && arr[i] != largest) {
				second = arr[i];
			}
		}
		System.out.println("largest = " + largest);
		System.out.println("second largest =" + second);
	}

}
