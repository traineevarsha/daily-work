package com.tek.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamsWithParallel {
	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

		Stream<Integer> finalStream = numbers.stream().parallel().filter(number -> number % 2 == 0);

		finalStream.forEach(System.out::println);
	}
}