package Tree;
import java.util.*;

public class SymmetricTree {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
	
	public boolean isSymmetric2(TreeNode root) {
		if (root == null) {
			return true;
		}
		
		return compareLeftRight(root.left, root.right);
		
	}
	
	public boolean compareLeftRight(TreeNode left, TreeNode right) {
		if (left == null && right == null) {
			return true;
		}
		
		if (left == null && right != null) {
			return false;
		}
		
		if (right == null && left != null) {
			return false;
		}
		
		return (left.val == right.val) && compareLeftRight(left.left, right.right) 
		           && compareLeftRight(left.right, right.left);
	}

	public static boolean isSymmetric(TreeNode root) {
		if (root == null) {
			return true;
		}
		
		if (root.left == null && root.right == null) {
			return true;
		}
	
		ArrayList<Integer> leftList = new ArrayList<Integer>();
		ArrayList<Integer> rightList = new ArrayList<Integer>();
		
		boolean left = dfs(root.left, leftList);
		
		if (left == false) {
			return false;
		}
		
		boolean right = dfs(root.right, rightList);
		
		if (right == false) {
			return false;
		}
		
		if (left == true && right == true) {
			if (leftList.size() != rightList.size()) {
				return false;
			}
			
			for (int i = 0; i < leftList.size(); i++) {
				int l = leftList.get(i);
				int r = rightList.get(i);
				
				if (l != r) {
					return false;
				}
			}
		}
		
		return true;	
	}
	
	public static boolean dfs(TreeNode left, ArrayList<Integer> list) {
		
		if (left == null) {
			return false;
		}
		
		list.add(left.val);
		
		if (left.left == null && left.right == null) {
			return true;
		}
		
		if (left.left != null && left.right != null) {
			if (!dfs(left.left, list)) {
				return false;
			}
			if (!dfs(left.right, list)) {
				return false;
			}
		}
		
		return false;
	}

}
