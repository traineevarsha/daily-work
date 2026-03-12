import java.util.*;
public class CollectionsExample {
	public static void main(String[] args) {
		List<String> fruits = new ArrayList<>();
		fruits.add("Apple");
		fruits.add("Mango");
		fruits.add (new String("Mango"));
		fruits.add("Banana");
		System.out.println(fruits);
		System.out.println(fruits.get(1)==fruits.get(2));
		
	
	}

}
