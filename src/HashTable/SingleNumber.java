package HashTable;
import java.util.*;
import java.util.Map.Entry;

public class SingleNumber {
    public int singleNumber(int[] nums) {
    	Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    	int result = nums[0];
    	for (int i = 0; i < nums.length; i++) {
    	      if (!map.containsKey(nums[i])) {
    	    	  map.put(nums[i], 1);
    	      } else {
    	    	  map.put(nums[i], 2);
    	      }
    	}
    	
    	for (Entry<Integer, Integer> entry : map.entrySet()) {
    		if (1 == entry.getValue()) {
    			result = entry.getKey();
    			break;
    		}		
    	}
    	
    	return result;
        
    }

}
