import java.util.Stack;

public class ReverseStackString {
	public static void main(String[] args) {
		String str = "hello";
		String reversed = reverse(str);
		System.out.println(reversed);

	}

	static String reverse(String str) {
		Stack<Character> stack = new Stack<>();
		for (char ch : str.toCharArray()) {
			stack.push(ch);
		}
		String result = "";
		while (!stack.isEmpty()) {
			result += stack.pop();
		}

		return result;
	}
}