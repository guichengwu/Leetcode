package Tree;

import java.util.ArrayList;

public class SumPaths {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public int sumNumbers(TreeNode root) {
		if (root == null) {
			return 0;
		}
		ArrayList<Integer> paths = new ArrayList<Integer>();
		paths(root, paths);
		int sum = 0;
		for (Integer path : paths) {
			sum += path;
		}
		
		return sum;
	}
	
	public void paths(TreeNode root, ArrayList<Integer> paths) {
		TreeNode current = root;
		
		if (current.left == null && current.right == null) {
			paths.add(current.val);
		} 
		if (current.left != null) {
			current.left.val += current.val*10;
			paths(current.left, paths);
		} 
		if (current.right != null) {
			current.right.val += current.val*10;
			paths(current.right, paths);
		}
	}
}
