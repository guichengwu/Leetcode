package HashTable;

public class TwoNum {
	
    public static int[] twoSum(int[] nums, int target) {
    	int[] result = new int[2];
    	int value;
    	for (int i = 0; i < nums.length; i++) {
    		for (int j = i + 1; j < nums.length; j++) {
    			value = nums[i] + nums[j];
    			
    			if (value == target) {
    				result[0] =i+1;
    				result[1] =j+1;
    				
    				return result;
    			}
    				
    		}
    	}
    	
    	return result;
    }
    
    public static void main(String[] args) {
    	int[] nums = {3,2,4};
    	int[] result = twoSum(nums, 6);
    	System.out.println(result[0]);
    	System.out.println(result[1]);
    }
    

}
