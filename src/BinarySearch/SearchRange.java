package BinarySearch;

public class SearchRange {
    public int[] searchRange(int[] nums, int target) {
        int firstIndex = searchRangeHelp(nums, 0, nums.length - 1, target);
        System.out.println("firstIndex :" + firstIndex);
        int[] result = new int[2];
       
        if (firstIndex == -1) {
        	result[0] = -1;
        	result[1] = -1;
        	return result;
        }
        
        
        //only one elelment in the array
        if (nums.length == 1) {
        	result[0] = firstIndex;
        	result[1] = firstIndex;
        	return result;
        }
        
        
        //if firstIndex is 0, then search right
        if (firstIndex == 0) {
        	return searchRight(nums, firstIndex);
        }
        //if firstIndex is the last one , then search left
        if (firstIndex == nums.length - 1) {
        	int lastIndex = firstIndex;
        	return searchLeft(nums, lastIndex);
        } 
        
    	//search left 
        if (nums[firstIndex -1] == nums[firstIndex] && nums[firstIndex + 1] != nums[firstIndex]) {
        	int lastIndex = firstIndex;
        	return searchLeft(nums, lastIndex);
        } 
        //search right
        else if (nums[firstIndex + 1] == nums[firstIndex] && nums[firstIndex -1] != nums[firstIndex]) {
        	return searchRight(nums, firstIndex);
        }
        //search left and right
        else if (nums[firstIndex -1] == nums[firstIndex] && nums[firstIndex + 1] == nums[firstIndex]) {
        	int midIndex = firstIndex;
        	return searchLeftAndRight(nums, midIndex);
        }
        //unique value
        else if (nums[firstIndex - 1] < nums[firstIndex] && nums[firstIndex + 1] > nums[firstIndex]) {
        	System.out.println("hi");
        	result[0] = firstIndex;
        	result[1] = firstIndex;
        	return result;
        } 
        
        return result;
    }
    
    public int searchRangeHelp(int[] nums, int start, int end, int target) {
    	int midIndex = (start + end) / 2;
    	int result;
    	
    	if (end < start) {
    		return -1;
    	}
    	
    	if (nums[midIndex] == target) {
    		return midIndex;
    	}
    	else if (nums[midIndex] > target) {
    		result = searchRangeHelp(nums, start, midIndex - 1, target);
    		return result;
    	}    	
    	else if (nums[midIndex] < target) {
    		result = searchRangeHelp(nums, midIndex + 1, end, target);
    		return result;
    	}
    	
    	return -1;
    }
    
    public int[] searchLeft(int[] nums, int lastIndex) {
    	int[] result = new int[2];
    	int firstIndex;
    	
    	int i = lastIndex;
        while (nums[i] == nums[i-1]) {
        	i--;
        	
        	if (i == 0)
        		break;
        }
        firstIndex = i;
        result[0] = firstIndex;
        result[1] = lastIndex;
        
        return result;
    }
    
    public int[] searchRight(int[] nums, int firstIndex) {
       	int[] result = new int[2];
    	int lastIndex;
    	
    	int i = firstIndex;
    	while (nums[i] == nums[i+1]) {
    		i++;
    		if (i + 1 == nums.length) 
    			break;
    	}
    	
    	lastIndex = i;
    	result[0] = firstIndex;
    	result[1] = lastIndex;
    	
    	return result;
    }
    
    public int[] searchLeftAndRight(int[] nums,int midIndex) {
       	int[] result = new int[2];
    	int leftIndex = midIndex;
    	int rightIndex = midIndex;
    	
    	while (nums[leftIndex] == nums[leftIndex-1]) {
    		leftIndex--;
    		
    		if (leftIndex == 0)
    			break;
    	}
    	
    	while (nums[rightIndex] == nums[rightIndex+1]) {
    		rightIndex++;
    		if (rightIndex + 1 == nums.length)
    			break;
    	}
    	
    	result[0] = leftIndex;
    	result[1] = rightIndex;
    	
    	return result;
    }
    

    public int[] searchRange2(int[] nums, int target) {
    	int firstIndex = -1; 
    	int secondIndex = -1;
    	int[] result = new int[2];
    	for (int i = 0; i < nums.length; i++) {
    		if (nums[i] == target) {
    			firstIndex = i;
    			secondIndex = i;
    			for (int j = i+1; j < nums.length; j++) {
    				if (nums[j] == target) {
    					secondIndex = j;
    				} else {
    					secondIndex = j - 1;
    					break;
    				}
    			}
    			break;
    		}
    	}
    	
    	result[0] = firstIndex;
    	result[1] = secondIndex;
    	
    	return result;	
    }
    
    public static void main(String[] args) {
    	SearchRange search = new SearchRange();
    	int[] nums ={1,1,1,8,8,9,9};
    	int result[];
    	result = search.searchRange2(nums, 10);
    	
    	for (int i = 0; i < result.length; i++)
    		System.out.println(result[i]);
    }

}
