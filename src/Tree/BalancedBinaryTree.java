package Tree;

import Tree.PathSum.TreeNode;

public class BalancedBinaryTree {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
	public static boolean isBalanced(TreeNode root) {
    	if (root == null) {
    		return true;
    	}
    	
    	int leftHeight = getHeight(root.left);
    	int rightHeight = getHeight(root.right);
    	
    	if (Math.abs(leftHeight - rightHeight) > 1) {
            return false;
    	} else {
    	    return isBalanced(root.left) && isBalanced(root.right);
    	}
    	
    	
    }
    
    public static int getHeight(TreeNode root) {
    	if (root == null) {
    		return 0;
    	}
    	
    	return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
    }
    
    public static int checkHeight(TreeNode root) {
    	if (root == null) {
    		return 0;
    	}
    	
    	int leftHeight = checkHeight(root.left);
    	if (leftHeight == -1) {
    		return -1;
    	}
    	
    	int rightHeight = checkHeight(root.right);
    	if (rightHeight == -1) {
    		return -1;
    	}
    	
    	int hieghtDiff = leftHeight - rightHeight;
    	
    	if (Math.abs(hieghtDiff) > 1) {
    		return -1;
    	} else {
    		return Math.max(leftHeight, rightHeight) + 1;
    	}
    }
    
    public static boolean isBalanced2(TreeNode root) {
    	if (checkHeight(root) == -1) {
    		return false;
    	} else {
    		return true;
    	}
    	
    }

}
