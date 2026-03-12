import java.util.*;

public class FrequencyExercise {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1,2,2,3,2,4);
		int count = 0;
		for (Integer n: list) {
			if(n==2) {
				count++;
			}
		}
		System.out.println(count);

	}

}
