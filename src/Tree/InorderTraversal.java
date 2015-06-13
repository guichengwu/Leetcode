package Tree;

import java.util.*;

public class InorderTraversal {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
	
    public List<Integer> inorderTraversal(TreeNode root) {
    	List<Integer> list = new ArrayList<Integer>();
    	
    	//DFS
    	dfs(root, list);
    	
    	return list;
    }
    
    public void dfs(TreeNode root, List<Integer> list) {
    	if (root == null) {
    		return;
    	}
    	
    	if (root.left != null) {
    		dfs(root.left, list);
    	}
    	
    	list.add(root.val);
    	
    	if (root.right != null) {
    		dfs(root.right, list);
    	}
    	
    	if (root.left == null && root.right == null) {
    		return;
    	}
    }
}
