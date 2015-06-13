package Stack;

import java.util.Stack;

public class ValidParentheses {
    public static  boolean isValid(String s) {
        char[] chs = s.toCharArray();
    	
        Stack stack = new Stack();   
        
        for (int i = 0; i < chs.length; i++) {
        	if ((chs[i] == '(') || (chs[i] == '{') || (chs[i] == '[')) {
        		stack.push(chs[i]);
        	}

        	if (chs[i] == ')' || chs[i] == '}' || chs[i] == ']') {
        		if (stack.isEmpty()) {
        			return false;
        		}
        	}
        	
        	if (chs[i] == ')') {
        		char c = (Character) stack.pop();
        		if (c != '(') {
        			return false;
        		}
        	}
        	
        	if (chs[i] == '}') {  
        		char c = (Character) stack.pop();
        		if (c != '{') {
        			return false;
        		}
        	}
        	
        	if (chs[i] == ']') {
        		char c = (Character) stack.pop();
        		if (c != '[') {
        			return false;
        		}
        	}
        }
        
        if (stack.isEmpty()) {
        	return true;
        }
        
    	return false;
    }
    
    public static void main(String[] args) {
    	System.out.println(isValid("]"));
    }

}
