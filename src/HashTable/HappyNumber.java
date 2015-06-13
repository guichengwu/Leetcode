package HashTable;

import java.util.*;

public class HappyNumber {
	public static boolean isHappy(int n) {
		Set<Integer> set = new HashSet<Integer>();
		List<Integer> bitList = new ArrayList<Integer>();
		while (true) {
			// get each digit in n
			while (n > 0) {
				int temp = n % 10;
				n = n / 10;

				bitList.add(temp);
			}
			int sum = 0;

			// calculate the sum of square of each digit
			for (Integer digit : bitList) {
				sum += digit * digit;
			}

			if (sum == 1) {
				return true;
			}

			if (!set.add(sum)) {
				return false;
			}
			
			n = sum;
			bitList.clear();
		}
	}
	
	public static void main(String[] args) {
		System.out.println(isHappy(12));
	}

}
