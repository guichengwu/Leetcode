package Tree;

import java.util.*;

public class PostOrder {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        postorder(root, list);
        return list;
    }
    
    public void postorder(TreeNode root, List<Integer> list) {
    	if (root == null) {
    		return;
    	}
    	
    	if (root.left != null) {
    		postorder(root.left, list);
    	}
    	
    	if (root.right != null) {
    		postorder(root.right, list);
    	}
    	
    	list.add(root.val);
    }
}
