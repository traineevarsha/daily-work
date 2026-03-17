import java.util.ArrayList;
import java.util.List;

public class StackArray {
	int top = -1;
	List<Integer> stack = new ArrayList<>();

	void push(int x) {
		stack.add(x);
		top++;
	}

	int pop() {
		if (top == -1) {
			System.out.println("Stack underflow");
			System.out.println("stack underflow");
			return -1;
		}
		int value = stack.get(top);
		stack.remove(top);      
		top--;
		return value;
	}
}