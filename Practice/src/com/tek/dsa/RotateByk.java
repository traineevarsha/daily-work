package com.tek.dsa;

public class RotateByk {

	public static void rotate(int[] arr, int k) {
		int n = arr.length - 1;
		k = k % n;
		for (int r = 0; r < k; r++) {
			int last = arr[n - 1];
			for (int i = n - 1; i > 0; i--) {
				arr[i] = arr[i - 1];
			}
			arr[0] = last;

		}

	}

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5 };
		rotate(arr, 2);
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i] + " ");
		}

	}

}
