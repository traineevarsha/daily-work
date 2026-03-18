package com.tek.lambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class AnonymousClass {
	
	private static void comparatorwithAnonymousInnerClass()
	{
		List<String> names =Arrays.asList("Java","Python","Go");
		names.sort(new Comparator<String>()
				{
			public int compare(String o1,String o2)
			{
				return o1.length()-o2.length();
			}
				});
		System.out.println(names);
	}
	private static void consumer()
	{
		List<String> names =Arrays.asList("Java","Python","Go");
	}

}
