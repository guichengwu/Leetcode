package Tree;

import java.util.ArrayList;

import Tree.PathSum.TreeNode;

public class FlatenBinaryTree {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
	
	//Learn from others
	private TreeNode tail = null;
	
	public void flatten2(TreeNode root) {
		if (root == null) {
			return;
		}
		TreeNode left = root.left;
		TreeNode right = root.right;
		
		root.left = null;
		root.right = null;
		
		if (tail == null) {
			tail = root;
		} else {
			tail.right = root;
		}
		
		tail = root;
		flatten2(left);
		flatten2(right);
	}
	
	public void flatten(TreeNode root) {
		if (root == null) {
			return;
		}
	    
		ArrayList<Integer> array = new ArrayList<Integer>();
		TreeNode temp = root;
		dfs(root, array);
		for (Integer i : array) {
			if (temp == null) {
				temp = new TreeNode(-1);
			}
			temp.left = null;
			temp.val = i;
			temp = temp.right;
		}
	}
	
    
	void dfs(TreeNode root, ArrayList<Integer> array) {
		if (root == null) {
			return;
		}
		array.add(root.val);
		
		if (root.left == null && root.right == null) {
			return;
		}
		
		if (root.left != null) {
			dfs(root.left, array);
		}
		
		if (root.right != null) {
			dfs(root.right, array);
		}
	}
	
   
}
