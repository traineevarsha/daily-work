package com.tek.collections;

import java.util.HashMap;

public class HashMapPrint {
	public static void main(String[] args) {
		HashMap<Integer, String> hset = new HashMap<>();

		hset.put(1, "A");
		hset.put(1, "B");
		hset.put(3, "C");
		hset.put(2, "D");

		System.out.println(hset.get(3));
		System.out.println(hset);
	}

}
