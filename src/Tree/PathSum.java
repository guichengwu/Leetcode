package Tree;

import java.util.*;

import Tree.SameTree.TreeNode;

public class PathSum {
   	private int sumPath = 0;
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
	
    //Depth first search
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        
        return DFS(root, sum);
    }
    
    public boolean DFS(TreeNode root, int sum) {    	
    	sumPath += root.val;
    	if (root.left == null && root.right == null) {
            if (sumPath == sum) {
            	return true;
            }
    		sumPath = 0;
    	}
    	
    	if (root.left != null) {
    		DFS(root.left, sum);
    	}
    	
    	if (root.right != null) {
    		DFS(root.right, sum);
    	}
    	
    	return false;
    	
    }
    
    //recursive learned from others
    public boolean hasPathSum2(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        TreeNode current = root;

    	if (root.left == null && root.right == null) {
            if (current.val == sum) {
            	return true;
            } 
    	} else if (root.left != null && root.right != null) {
    	    root.left.val += current.val;
    	    root.right.val += current.val;
    	    
    	    return hasPathSum(root.left, sum) || hasPathSum(root.right, sum);
    	} else if (root.left != null) {
    	    root.left.val += current.val;
    	    return hasPathSum(root.left, sum);
    	} else  {
    		root.right.val += current.val;
    	    return hasPathSum(root.right, sum);
    	}
		return false;
    }

}
