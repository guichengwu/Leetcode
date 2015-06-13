package Array;

public class Rotate {
	 public static void rotate(int[] nums, int k) {
		    if ( k <= 0 || nums.length == 0 || nums == null) {
		    	return;
		    }
		    
		    if (k > nums.length) {
		        k = k % nums.length;
		    }
		    
	        int[] rightPart = new int[k];

	        for (int i = 0; i < rightPart.length; i++) {
	            rightPart[i] = nums[nums.length - k + i];
	        }
	        
	        //move left elements to right, from end to begin
	        for (int i =  nums.length - k -1; i >= 0; i--) {
	        	nums[i+k] = nums[i];
	        }
	        
	        //add rightPart into left
	        for (int i = 0; i < k; i++) {
	            nums[i] = rightPart[i];
	        }
	    }
	 
	 public static void main(String[] args) {
		 int[] nums = {1,2,3,4,5,6,7};
		 rotate(nums, 6);
		 for (int i = 0; i < nums.length; i++) {
			 System.out.println(nums[i]);
		 }
	 }
}
