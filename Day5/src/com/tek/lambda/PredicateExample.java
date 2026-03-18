package com.tek.lambda;

import java.util.function.Predicate;

public class PredicateExample {
	public static void main(String[] args) {
		//Predicate<Integer> isEven = n->n%2==0;//return is implicit
		Predicate<Integer> isEven=(Integer n)->n%2==0;//here Integer is object
		//Predicate<Integer> isEen=(int n)->n%2==0;//here int is raw primitive data type
		//Predicate<Integer> isEven = n->
		//{
		//	return n%2==0;
		//};
		System.out.println(isEven.test(10));
	}

}
