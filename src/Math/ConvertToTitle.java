package Math;

import java.util.*;

public class ConvertToTitle {
	public static String convertToTitle(int n) {
		if (n <= 0) {
			return "";
		}
		String s = "";
		List<Character> list = new ArrayList<Character>();
		
		while (n > 0) {
			char c;
			if ((n % 26) == 0) {
				c = 'Z';
			} else {
				c = (char) ((n % 26) + -1 + 'A');
			}
			list.add(c);

			if (n == 26) {
				break;
			}
			
			n = ((n-(c - 'A')) / 26);

		}	
		for (int i = list.size() - 1; i >= 0 ; i--) {
			s += list.get(i);
		}
		return s;
	}
	
	   public static void main(String[] args) {
		   System.out.println(convertToTitle(494452));
		   System.out.println(convertToTitle(703));
	   }


}
