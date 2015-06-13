package Tree;

import java.util.*;

import Tree.MinDepth.TreeNode;

public class OrderTravsersal {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
	
	//learn from others 2, BFS solution
	public List<List<Integer>> levelOrder3(TreeNode root) {
		
		List<List<Integer>> lists = new ArrayList<List<Integer>>();
		
		Queue<TreeNode> queue1 = new LinkedList<TreeNode>();
		Queue<TreeNode> queue2 = new LinkedList<TreeNode>();
		List<Integer> list = null;
		if (root != null) {
			list = new ArrayList<Integer>();
			lists.add(list);
			queue1.add(root);
		}
		
		while (!queue1.isEmpty()) {
			TreeNode node = queue1.poll();
			list.add(node.val);
			
			if (node.left != null) {
				queue2.add(node.left);
			}
			
			if (node.right != null) {
				queue2.add(node.right);
			}
			
			//one level is ended
			if (queue1.isEmpty() && !queue2.isEmpty()) {
				//exchange queue2 and queue1
				Queue<TreeNode> temp = queue1;
				queue1 = queue2;
				queue2 = temp;
				list = new ArrayList<Integer>();
				lists.add(list);
			}
		}
		
		List<List<Integer>> reverseLists = new ArrayList<List<Integer>>();
		for (int i = lists.size() - 1; i >= 0; i--) {
			reverseLists.add(lists.get(i));
		}
		return reverseLists;
	}
	
    //learn from others
    public List<List<Integer>> levelOrder2(TreeNode root) {
    	
    	List<List<Integer>> lists = new ArrayList<List<Integer>>();
    	dfs(root, lists, 0);
    	
    	return lists;
        
    }
    
    public void dfs(TreeNode root, List<List<Integer>> lists, int level) {
    	if (root == null) {
    		return;
    	}
    	
    	if (lists.size() == level) {
    		lists.add(new ArrayList<Integer>());
    	}
    	
    	lists.get(level).add(root.val);
    	
    	dfs(root.left, lists, level+1);
    	dfs(root.right, lists, level+1);
    }
	
    public List<List<Integer>> levelOrder(TreeNode root) {
    	List<List<Integer>> lists = new ArrayList<List<Integer>>();
        
    	bfs(root, lists);
        
        return lists;
    }
    
    public void bfs(TreeNode root, List<List<Integer>> lists) {
    	Queue<TreeNode> queue = null;
    	queue.add(root);
    	
    	while (!queue.isEmpty()) {
    		List<Integer> list = new ArrayList<Integer>();
    		TreeNode node = queue.peek();
    		if (node.left != null) {
    			list.add(node.left.val);
    		}
    		if (node.right != null) {
    			list.add(node.right.val);
    		}
    	}
    }
}
