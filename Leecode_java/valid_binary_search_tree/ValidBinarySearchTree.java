public class Solution {
	public boolean isValidBST(TreeNode root) {
		return isValidBST(root, Integer.MAX_VALUE, Integer.MIN_VALUE);
	}

	public boolean isValidBST(TreeNode root, int max, int min){
		if(root == null) 
			return true;
		if(root.val >= max || root.val <= min)
			return false;
		return isValidBST(root.left, root.val, min) && isValidBST(root.right, max, root.val);
	}
}