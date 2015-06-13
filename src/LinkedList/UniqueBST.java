package LinkedList;

import java.util.HashMap;
import java.util.Map;

public class UniqueBST {
	
	/**
	 * numTrees(n) =root(1) + root(2)+ .... + root(n);
	   root(i) = numTrees(i - 1) * numTrees(n - i);
	   numTrees(n) = numTrees(0)* numTrees(n-1)+ numTrees(1)*numTrees(n-2)+....+ numTrees(n-1)*numtrees(0);
	   numTrees(0) = 1;
	   numTrees(1) = 1;
	 */
    public static int numTrees(int n) {
    	 int[] map = new int[n+1];
    	 return numTrees(n, map);
    }
    
    public static int numTrees(int n, int[] map) {
    	if (n == 0 || n == 1) {
    		return 1;
    	}

    	if (map[n] > 0) {
    		return map[n];
    	}
    	
    	int sum = 0;
    	int temp = 0;
    	for (int i = 0; i < n; i++) {
    		temp = numTrees(i, map) * numTrees(n -i-1, map);
        	sum += temp;
    	}
    	 map[n] = sum;
    	 return sum;
    }
    
    public static void main(String[] args) {
    	System.out.println(numTrees(19));
    }
    
    
    
    

}
