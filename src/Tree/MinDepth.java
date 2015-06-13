package Tree;

import Tree.BalancedBinaryTree.TreeNode;

public class MinDepth {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
	
    public int minDepth(TreeNode root) {
    	   if (root ==  null) {
               return 0;
           }
           if (root.left == null && root.right == null) {
               return 1;
           } else if (root.left != null && root.right != null) {
               return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
           } else if (root.left != null && root.right == null) {
               return minDepth(root.left) + 1;
           } else {
               return minDepth(root.right) + 1;
           } 
    }

}
