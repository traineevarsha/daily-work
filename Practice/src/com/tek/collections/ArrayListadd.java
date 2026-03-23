package com.tek.collections;

import java.util.ArrayList;

public class ArrayListadd {
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>();
		list.add(10);
		list.add(20);
		list.add(30);
		int sum = 0;
		for (Integer ele : list) {

			sum += ele;
		}
		System.out.println(sum);

	}

}
