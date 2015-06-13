package String;

import java.util.ArrayList;
import java.util.List;

public class Palindrome {
    public static boolean isPalindrome(String s) {
    	if (s == null || s== "") {
    		return true;
    	}
    	
    	List list = convertToValidChar(s);
    	int rightIndex = list.size() - 1;
    	int leftIndex = 0;
    	while (leftIndex < rightIndex) {
    		if (list.get(leftIndex) != list.get(rightIndex)) {
    			return false;
    		}
    		
    		leftIndex++;
    		rightIndex--;
    	}
	
    	return true;
    }
    
    public static List convertToValidChar(String s) {
    	
    	char[] chs = s.toLowerCase().toCharArray();
    	List list = new ArrayList<Character>();
    	for (int i = 0; i < chs.length; i++) {
    		//number
    		if ((chs[i] - 48) >= 0 && (chs[i] - 48) <= 9) {
    			list.add(chs[i]);
    		}
    		//abc..
    		else if ((((chs[i] - 97) >= 0) && ((chs[i] - 97) < 26))) {
    			list.add(chs[i]);
    		}
    	}
    	
    	
    	return list;
    }
    
    public static void main(String[] args) {
    	List list = convertToValidChar("A man, a plan, a canal: Panama");
    	System.out.println(isPalindrome(" "));
    }

}
