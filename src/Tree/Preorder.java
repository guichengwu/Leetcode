package Tree;

import java.util.*;

public class Preorder {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
	public List<Integer> preorderTraversal(TreeNode root) {
	     List<Integer> list = new ArrayList<Integer>();
	     preorder(root, list);
	     
	     return list;
		
	}	
	
	public void preorder(TreeNode root, List<Integer> list) {
		if (root == null) {
			return;
		}
		
		list.add(root.val);
		preorder(root.left, list);
		preorder(root.right, list);
	}
}
