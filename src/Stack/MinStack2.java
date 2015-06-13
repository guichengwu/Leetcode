package Stack;

import java.util.Stack;

public class MinStack2 {
	private Stack<Integer> stack = new Stack<Integer>();
	private Stack<Integer> minStack = new Stack<Integer>();
	
	public void push(int x) {
		if (minStack.isEmpty() || x <= minStack.peek()) {
			minStack.push(x);
		}
		stack.push(x);
	}
	
	public int top() {
		return stack.peek();
		
	}

	public void pop() {
		if (!stack.isEmpty()) {
		    int x = stack.pop();
		if (x == minStack.peek()) {
            minStack.pop();
		} 
	}
	}
	
	public int getMin() {
		return minStack.peek();
	}

}
