package Array;

import java.util.List;
import java.util.ArrayList;

public class RemoveElement {
    public int removeElement(int[] nums, int val) {
    	int originLength = nums.length;
        List<Integer> list = new ArrayList<Integer>(); 
        
        for (int i = 0; i < nums.length; i++) {
        	if (nums[i] != val) {
        		list.add(nums[i]);
        	}
        }
       
        for (int i = 0; i < list.size(); i++) {
        	nums[i] = list.get(i);
        }
        
        return list.size();
    }

}
