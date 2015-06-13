package HashTable;

import java.util.*;
import java.util.Map.Entry;

public class Isomorphic {
    public static boolean isIsomorphic(String s, String t) {
    	if (s.length() != t.length()) {
    		return false;
    	}
    	
    	Map<Character, Character> map = new HashMap<Character, Character>();
    	
    	for (int i = 0; i < s.length(); i++) {
    		char cs = s.charAt(i);
    		char ct = t.charAt(i);
    		
    		if (!map.containsKey(cs)) {
    			for (Entry<Character, Character> entry : map.entrySet()) {
    				char ch = entry.getValue();
    				if (ch == ct) {
    					return false;
    				}
    			}
    			map.put(cs, ct);
    		} else {
    			char temp = map.get(cs);
    			if (temp != ct) {
    				return false;
    			}
    		}
    	}
    	
    	return true;      
    }
    
    public static void main(String[] args) {
    	System.out.println(isIsomorphic("ab", "aa"));
    }

}
