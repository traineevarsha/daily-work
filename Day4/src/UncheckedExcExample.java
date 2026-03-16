import java.util.*;
public class UncheckedExcExample {
	public static void main(String[] args) {
		//String str = null;
		//System.out.println(str.length());
		try {
			validateage(17);
		} catch (MyException e) {
			System.out.println("IllegalArgument Exception");
			
		}
		System.out.println("finished");
		
	}
	public static void validateage(int age) {
		if (age<18) {
			throw new MyException("Below 18");
		}
		
	}
}
