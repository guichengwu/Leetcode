package DivideAndConquer;

public class MaxSubarray {
    public static int maxSubArray(int[] nums) {
    	if (nums.length == 0) {
    		return -1;
    	}
        if (nums.length == 1) {
        	return nums[0];
        }
    	
    	int size = nums.length;
    	int[] leftPart= new int[size/2];
    	int[] rightPart = new int[size - size/2];
    	for (int i = 0; i < nums.length; i++) {
    		if (i < (size /2)) {
    			leftPart[i] = nums[i];
    			System.out.println("left index is " + i);
    		} else {
    			rightPart[i - size/2] = nums[i];
    		}
    	}
        int left = maxSubArray(leftPart);
        int right = maxSubArray(rightPart);
        
        return merge(left, right) / 2;
    }
    
    public static int merge(int left, int right) {
    	//left and right are both positive
    	//left and right are both negative
    	//left is positive, and right is negative
    	//left is negative, and right si positive
    	if (left >= 0 && right >= 0) {
    		return left + right;
    	}
    	
    	if (left >= 0 && right < 0) {
    		return left;
    	}
    	
    	if (left < 0 && right >= 0) {
    		return right;
    	}
    	
    	if (left < 0 && right < 0) {
    		if (left > right) {
    			return left;
    		} else {
    			return right;
    		}
    	}
    	
    	return -1;
    }
     
    
    //very trick solution learned from others
    public static int maxSubArray2(int[] nums) {
    	int result = nums[0];
    	int cur = nums[0];
    	
    	for (int i = 1; i < nums.length; i++) {
    		cur = Math.max(nums[i], nums[i]+ cur);
    		result = Math.max(cur, result);
    	}	
    	return result;
    }
    
    public static void main(String[] args) {
    	int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
    	 System.out.println(maxSubArray2(nums));
    }

}
