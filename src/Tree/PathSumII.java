package Tree;

import java.util.*;

import Tree.SumPaths.TreeNode;

public class PathSumII {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
	
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        ArrayList<Integer> path = new ArrayList<Integer>();
        List<List<Integer>> paths = new  ArrayList<List<Integer>>();

        pathSumHelper(root, root, sum, path, paths);
        
        return paths;
        
    }
   
	
	public void pathSumHelper(TreeNode root, TreeNode sumNode, int sum, List<Integer> path, List<List<Integer>> paths) {
		
		TreeNode current = root;
		TreeNode currentSum = sumNode;
		path.add(current.val);
		if (root.left == null && root.right == null) {
			if (currentSum.val == sum) {
				paths.add(path);
				path.clear();
			}
		}
		
		if (root.left != null) {
			sumNode.val += current.left.val;
			pathSumHelper(current.left, sumNode, sum, path, paths);
		}
		
		if (root.right != null) {
			sumNode.val += current.right.val;
			pathSumHelper(current.right, sumNode, sum, path, paths);
		}
		
	}

}
