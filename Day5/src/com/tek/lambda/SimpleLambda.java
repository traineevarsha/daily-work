package com.tek.lambda;

/*package Day5;
import java.util.Arrays;
import java.util.List;


public class SimpleLambda {
	public static void main(String[] args) {
		List<Integer> l=Arrays.asList(1,2,3,4);
		l.stream().filter(x->x%2==0);
		System.out.println(l);
	}

}
*/

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;  // Import the Collectors class
import java.util.stream.Stream;

public class SimpleLambda {

    public static void main(String[] args) {
        // List of integers
        List<Integer> l = Arrays.asList(1, 2, 3, 4);
        
        // Using stream() to filter even numbers and collect them into a list
        /*List<Integer> finalResult = l.stream()
                                     .filter(x -> x % 2 == 0)   // Filter even numbers
                                     .collect(Collectors.toList());  // Collect into a List
        */
        /*List<Integer> l1 =Arrays.asList(1,2,3);
        int r=l1.stream().map(x->x*2).reduce(0,Integer::sum);
        System.out.println(r);
        // Print the final result
        //System.out.println(finalResult);
        /// 
         */
        Stream<Integer> s =Stream.of(1,2,3);
        s.forEach(System.out::println);
        s.forEach(System.out::println);
    }
}
