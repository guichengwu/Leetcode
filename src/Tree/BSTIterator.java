package Tree;

import Tree.SortArrayToBST.TreeNode;
import java.util.*;

public class BSTIterator {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
	 
	List<Integer> list = new ArrayList<Integer>();
	int pointer = 0;
	
	 public BSTIterator(TreeNode root) {
	        inorder(root, list);
	 }
	 
	 public void inorder(TreeNode root, List<Integer> list) {
		 if (root == null) {
			 return;
		 }
		 inorder(root.left, list);
		 list.add(root.val);
		 inorder(root.right, list);
	 }

	    public boolean hasNext() {
	        if (list.size() <= 0) {
	    		return false;
	    	}
	    	if (pointer < list.size() && list.get(pointer) != null) {
	    		return true;
	    	}
	    	
	    	return false;
	    }

	    /** @return the next smallest number */
	    public int next() {
	        if (hasNext()) {
	        	return (int)list.get(pointer++);
	        }
	        
	        return -1;
	    }
}
