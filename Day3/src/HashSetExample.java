import java.util.HashSet;
import java.util.*;
public class HashSetExample {

	public static void main(String[] args) {
		HashSet<Integer> numbers = new HashSet<>();
		numbers.add(10);
		numbers.add(20);//no duplicates allowed
		numbers.add(10);
		System.out.println(numbers);

	}

}
