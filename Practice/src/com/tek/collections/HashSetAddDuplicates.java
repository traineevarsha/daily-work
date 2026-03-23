package com.tek.collections;

import java.util.HashSet;

public class HashSetAddDuplicates {
	public static void main(String[] args) {
		HashSet<Integer> hset = new HashSet<>();

		hset.add(1);
		hset.add(1);
		hset.add(3);
		hset.add(2);

		System.out.println(hset);
	}

}
