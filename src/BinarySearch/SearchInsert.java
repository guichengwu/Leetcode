package BinarySearch;

public class SearchInsert {
	
    public int searchInsert(int[] nums, int target) {
    	return searchInsertHelp(nums, 0, nums.length - 1, target);
    }
    
    public int searchInsertHelp(int[] nums, int start, int end, int target) {
    	int midIndex = (start + end) / 2;
    	if (end <= start) {
    		if (target > nums[start]) {
    			return start + 1;
    		} else {
    			return start;
    		}
    	
    	}
    	int result;
    	if (nums[midIndex] == target) {
    		return midIndex;
    	}
    	else if (nums[midIndex] > target) {
    		result = searchInsertHelp(nums, start, midIndex - 1, target);
    		return result;
    		
    	}    	
    	else if (nums[midIndex] < target) {
    		result = searchInsertHelp(nums, midIndex + 1, end, target);
    		return result;
    	}
    	
    	return -1;
    }
    
    public static void main(String[] args) {
    	SearchInsert search = new SearchInsert();
    	
    	int[] nums = {1,3};
    	System.out.println(nums.length);
    	System.out.println(search.searchInsert(nums, 4));
    }

}
