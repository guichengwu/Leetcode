package Tree;

public class ValidBST {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
    public TreeNode rootTmp;
    public boolean search(TreeNode root) {
        rootTmp = root;
        if (root == null) {
            return true;
        }
        if (root.left != null) {
            if (root.left.val >= rootTmp.val) {
                return false;
            } else {
                search(root.left);
            }
        }
        
        if (root.right != null) {
            if (root.right.val <= rootTmp.val) {
                return false;
            } else {
                search(root.right);
            }
        }
        
        return true;
    }
    
	public static boolean isValidBST(TreeNode root) {

		if (root == null) {
			return true;
		}
		if (root.left != null) {
			if (root.left.val >= root.val) {
				return false;
			} else {
				isValidBST(root.left);
			}
		}

		if (root.right != null) {
			if (root.right.val <= root.val) {
				return false;
			} else {
				isValidBST(root.right);
			}
		}

		return true;

	}
	
	public static boolean isValidBST2(TreeNode root) {
		if (root == null)
			return true;
		return isValidBST2(root, Long.MIN_VALUE, Long.MAX_VALUE);
	}
	
	public static boolean isValidBST2(TreeNode root, long min, long max) {
		if (root == null) {
			return true;
		}
		
		if (root.val < min || root.val > max) {
			return false;
		}
		//     isValidBST(root.left,min,(long)root.val-1)&&isValidBST(root.right,(long)root.val+1,max);
		return isValidBST2(root.left, min, (long)(root.val - 1)) && isValidBST2(root.right, (long)(root.val + 1), max);
	
	}
	
	public boolean isValidBST3(TreeNode root) {
	    if(root ==null)
	    return true;
	    return isValidBST3(root,Long.MIN_VALUE,Long.MAX_VALUE);
	}
	public boolean isValidBST3(TreeNode root, long min, long max)
	{
	    if(root == null)
	    return true;
	    if(root.val < min || root.val > max)
	    return false;
	    return isValidBST3(root.left,min,(long)root.val-1)&&isValidBST3(root.right,(long)root.val+1,max);
	}
	
	public static void main(String[] args) {
		
	}

}
