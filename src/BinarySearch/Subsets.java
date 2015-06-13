package BinarySearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets {
	public static List<List<Integer>> subsets(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> solutions = new ArrayList<List<Integer>>();
		int totalSize = 1;
		for (int i = 0; i < nums.length; i++) {
			//left move 
			totalSize <<= 1;
		}
		List<Integer> result = new ArrayList<Integer>();
		for (int i = 0; i < totalSize; i++) {
			result = convertIntToList2(i, nums);
			solutions.add(result);
		}
		return solutions;

	}
	
	public static List<Integer> convertIntToList(int n, int[] nums) {
		List<Integer> list = new ArrayList<Integer>();
		 //System.out.println(n);
		for (int i = 0; i < nums.length; i++) {
		  System.out.println(n);
			if ((n & 1) == 1) {
				list.add(nums[i]);
			}
			//right move
			n >>= 1;
		}
		
		return list;
	}
	
	public static List<Integer> convertIntToList2(int n, int[] nums) {
		List<Integer> list = new ArrayList<Integer>();
		int index = 0;
		for (int k = n; k > 0; k >>= 1) {
			if ((k & 1) == 1) {
				list.add(nums[index]);
			}
			index++;
		}
		
		return list;
	}
	
	public static void main(String[] args) {
		int[] nums = {1,0,5};
		List<List<Integer>> solutions = new ArrayList<List<Integer>>();
		solutions = subsets(nums);
		System.out.println(solutions.toString());
	}

}
