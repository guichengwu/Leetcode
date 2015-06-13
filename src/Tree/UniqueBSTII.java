package Tree;

import java.util.*;

import Tree.SymmetricTree.TreeNode;

public class UniqueBSTII {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
    public List<TreeNode> generateTrees(int n) {
        return generateTrees(1, n);
    }
    
    public List<TreeNode> generateTrees(int start, int end) {
    	List<TreeNode> trees = new ArrayList<TreeNode>();
    	
    	if (start > end) {
    		trees.add(null);
    		return trees;
    	}
    	
    	for (int i = start; i <= end; i++) {
    		List<TreeNode> leftSubTrees = generateTrees(start, i - 1);
    		List<TreeNode> rightSubTrees = generateTrees(i+1, end);
    		
    		for (TreeNode leftSubTree : leftSubTrees) {
    			for (TreeNode rightSubTree : rightSubTrees) {
    				TreeNode root = new TreeNode(i);
    				root.left = leftSubTree;
    				root.right = rightSubTree;
    				
    				trees.add(root);
    			}
    		}
    	}
    	
    	return trees;
    }
}
