package Tree;

import Tree.PostOrder.TreeNode;

public class SortArrayToBST {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
    public TreeNode sortedArrayToBST(int[] nums) {
        return arrayToBST(nums, 0 , nums.length - 1);
    }
    
    public TreeNode arrayToBST(int[] nums, int start, int end) {
    	TreeNode root = null;
    	if (start > end) {
    		return root;
    	}

    	int mid = (start + end) / 2;
    	root = new TreeNode(nums[mid]);
    	root.left = arrayToBST(nums, start, mid - 1);
    	root.right = arrayToBST(nums, mid+1, end);
    	
    	return root;
    }
}
