package Stack;

import java.util.ArrayList;
import java.util.Stack;

public class MinStack {
	private ArrayList<Integer> stack;
	private int topVal;
	private int topIndex;
	private int min;
	private int size;
	
	public MinStack() {
		stack = new ArrayList<Integer>();
		size = 0;
		topIndex = -1;
		min = Integer.MAX_VALUE;
	}
	
    public void push(int x) {
        topVal = x;
        topIndex++;
        stack.add(x);
        
        if (x < min) {
        	min = x;
        }
        size++;
    }

	public void pop() {
		if (topIndex < 0) {
			return;
		}
		if (stack.get(topIndex) == min) {
			stack.remove(topIndex);
			topIndex--;
			if (!stack.isEmpty()) {
				min = stack.get(0);
				for (int i : stack) {
					if (i < min) {
						min = i;
					}
				}
			} else {
				min = Integer.MAX_VALUE;
			}
		} else {
			stack.remove(topIndex);
			topIndex--;
		}
		size--;
	}

    public int top() {
    	if (topIndex < 0) {
    		return -1;
    	}
    	return stack.get(topIndex);
        
    }

    public int getMin() {
    	   return min;   
    }
    
    public static void main(String[] args) {
    	MinStack stack = new MinStack();
    	stack.push(2147483646);
    	stack.push(2147483646);
    	stack.push(2147483647);
    	
    	System.out.println(stack.top());
        stack.pop();
        System.out.println(stack.getMin());
        stack.pop();
        System.out.println(stack.getMin());
        stack.pop();
    	stack.push(2147483647);
    	System.out.println(stack.top());
        System.out.println(stack.getMin());
        stack.push(-2147483648);
        //top,getMin,pop,getMin
        System.out.println(stack.top());
        System.out.println(stack.getMin());
        stack.pop();
        System.out.println(stack.getMin());
        //System.out.println(stack.getMin());
    }

}
