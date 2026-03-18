package com.tek.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsWithChain {

	public static void main(String[] args) { // Move main here
		streamWithChain();
	}

	private static void streamWithChain() {
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

		// Fixed the filter logic and added correct stream collection
		Stream<Integer> finalStream = numbers.stream().map(number -> number * number) // Square each number
				.filter(number -> number % 2 != 0) // Keep only odd numbers
				.filter(number -> {
					System.out.println(number); // Print each number
					return number % 2 != 0; // Keep only odd numbers
				});

		// Correctly collect the stream into a List
		List<Integer> finalList = finalStream.collect(Collectors.toList()); // Specify the correct type

		System.out.println(finalList); // Print the final list
	}

	private static void stream1() {
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
		Stream<Integer> stream = numbers.stream();
		Stream<Integer> squaredStream = stream.map(number -> number * number);
		Stream<Integer> filteredStream = squaredStream.filter((number) -> {
			System.out.println(number);
			return number % 2 != 0; // Keep only odd numbers
		});

		// The count method is terminal and consumes the stream, so it works here:
		System.out.println(filteredStream.count());
	}
}
//
//private static void streamsWithChain()
//{
//List<Integer> numbers=Arrays.asList(1,2,3,4,5);
//Stream<Integer>finalStream = numbers.stream().map(number->){
// if(number%2==1)
// {
// return number*number;
// }
// else
// {
// return number;
// }

//or return(number%2==1) ? number*number:number;
