package BitOperation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class RepeatDNA2 {
public static List<String> findRepeatedDnaSequences(String s) {
	    List<String> list2 = new ArrayList<String>();
		if (s.length() <= 10) {
			return list2;
		}
		
		Set<String> set = new HashSet<String>();
		Set<Integer> intSet = new HashSet<Integer>();
		for (int i =0; i <= s.length() - 10; i++) {
			String substring = s.substring(i, i + 10);
			int n = transferStringToInt(substring);
			if (!intSet.add(n)) {
				System.out.println(n);
				set.add(substring);
			}
		}
		
		 List<String> list = new ArrayList<String>(set);
        return list;

	}
	
	public static int transferStringToInt(String s) {
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
			
			result <<= 2;
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		List<String> list = findRepeatedDnaSequences("");
	System.out.println(list.toString());
	/*			for (String s : list) {
			System.out.println(s);
		}*/
	}

}
