package com.tek.lambda;

import java.util.*;
import java.util.function.Consumer;

class MyComparator implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        return o1.length() - o2.length();
    }
}

public class LamdaWithCollections {
    public static void main(String[] args) {
        List<String> name = Arrays.asList("Java", "Python", "Go");
        
        comparator(name);
        Consumer(name);
    }

    private static void comparator(List<String> name) {
        name.sort(new MyComparator());
        System.out.println(name);
    }

    private static void Consumer(List<String> names) {
        Consumer<String> consumer = name -> {
            System.out.println(name);
        };
        names.forEach(consumer);
    }
}
