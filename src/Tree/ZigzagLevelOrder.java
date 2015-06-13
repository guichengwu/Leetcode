package Tree;

import java.util.*;

import Tree.BSTIterator.TreeNode;

public class ZigzagLevelOrder {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
	
	//BFS
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        if (root == null) {
        	return lists;
        }
        List<Integer> list = new ArrayList<Integer>();
        List<TreeNode> current = new ArrayList<TreeNode>();
        current.add(root);
        list.add(root.val);
        
        while (current.size() > 0) {
        	lists.add(list);
        	List<TreeNode> parents = current;
        	current = new ArrayList<TreeNode>();
        	list = new ArrayList<Integer>();
        	
        	for (TreeNode parent : parents) {
        		if (parent.left != null) {
        			current.add(parent.left);
        			list.add(parent.left.val);
        		}
        		
        		if (parent.right != null) {
        			current.add(parent.right);
        			list.add(parent.right.val);
        		}
        	}
        }
        
        transfer(lists);
        
        return lists;
    }
    
    public void transfer(List<List<Integer>> lists) {
    	
    	for (int i = 1; i < lists.size(); i+= 2) {
    		List<Integer> list = lists.get(i);
    		List<Integer> reverseList = reverseList(list);
    		lists.set(i, reverseList);
    	}
    }
    
    public List<Integer> reverseList(List<Integer> list) {
    	List<Integer> newList = new ArrayList<Integer>();
    	for (int i = list.size() - 1; i >= 0; i--) {
    		newList.add(list.get(i));
    	}
    	
    	return newList;
    }
}
