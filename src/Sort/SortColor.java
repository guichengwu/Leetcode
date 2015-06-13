package Sort;

public class SortColor {
    public void sortColors(int[] nums) {
        //we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively
    	int red = 0;
    	int white = 0;
    	int blue = 0;
    	
    	for (int i = 0; i < nums.length; i++) {
    		if (nums[i] == 0)
    			red++;
    		if (nums[i] == 1)
    			white++;
    		if (nums[i] == 2)
    			blue++;
    	}
    	
    	for (int i = 0; i < nums.length; i++) {
    		if (i < red) {
    			nums[i] = 0;
    		} else if (i >= red && i < red+white) {
    			nums[i] = 1;
    		} else if (i >= red+ white && i < red+white+blue) {
    			nums[i] = 2;
    		}
    	}
    }

}
