import java.util.*;

public class CommomElementsExercise {

	public static void main(String[] args) {
		List<Integer> list1 = Arrays.asList(1,2,3,4);
		List<Integer> list2 = Arrays.asList(3,4,5,6,3);
		
		List <Integer> common = new ArrayList<>();
		for(Integer num : list1) {
			for(Integer n : list2) {
				if(num.equals(n)) {
					common.add(num);
					break;
				}
			}
		}
		
		System.out.println("Common elements:" +common);
		

	}

}
