package BitOperation;

import java.util.*;

public class RepeatedDNA {
	//using hashMap and HashSet
	public static List<String> findRepeatedDnaSequences(String s) {
		
		if (s.length() <= 10) {
			return null;
		}
		
		Set<String> set = new HashSet<String>();
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		for (int i =0; i <= s.length() - 10; i++) {
			String substring = s.substring(i, i + 10);
			
			if (map.containsKey(substring)) {
				set.add(substring);
			} else {
				map.put(substring, i);
			}
		}
		
		List<String> list = new ArrayList<String>(set);
        return list;

	}
	
	public int transferStringToInt(String s) {
		int result = 0;
		for (int i = 0; i < s.length(); i++) {
			char c  = s.charAt(i);
			if (c == 'A') {
				result += 0;
			} else if (c == 'C') {
				result += 1;
			} else if (c == 'G') {
				result += 2;
			} else if (c == 'T') {
				result += 3;
			}
			
			result >>= 2;
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		List<String> list = findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT");
		for (String s : list) {
			System.out.println(s);
		}
	}

}
