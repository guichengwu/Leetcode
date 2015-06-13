package Array;
import java.util.*;

public class removeDuplicate {
	   public static int removeDuplicates(int[] nums) {
	        if (nums == null || nums.length == 0) {
	            return 0;
	        }
	        Set<Integer> set = new LinkedHashSet<Integer>();
	        for (int i = 0; i < nums.length; i++) {
	            set.add(nums[i]);
	        }
        
	        Iterator<Integer> iterator = set.iterator();
	  
	        int i = 0;
	        while (iterator.hasNext()) {
	        	nums[i] =  iterator.next();
	        	i++;
	        }
	        return set.size();
	    }
	   
	   public static int removeDuplicates2(int[] nums) {
		   if (nums.length == 0 || nums == null) {
			   return 0;
		   }
		   int pointer = nums[0];
		   int k = 1;
		   for (int i = 1; i < nums.length; i++) {
			   if (pointer != nums[i]) {
				   nums[k] = nums[i];
				   pointer = nums[k];
				   k++;   
			   }
		   }
		   
		   return k;
	   }
	   public static void main(String[] args) {
		   int[] nums = {-3,-1,0,0,0,3,3};
		   int k = removeDuplicates2(nums);
		   for (int i = 0; i < k; i++) {
		        System.out.println(nums[i]);
		   }
	   }
}
