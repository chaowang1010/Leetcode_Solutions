public class Solution {
	// Recursion...
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

	// Iteration...
	public boolean isValidBST(TreeNode root){
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode curr = root;
		TreeNode pre = null;
		while(curr != null){
			stack.push(curr);
			curr = curr.left;
		}

		while(!stack.empty()){
			curr = stack.pop();
			if(pre != null && pre.val >= curr.val) return false;
			pre = curr;
			curr = curr.right;
			while(curr != null){
				stack.push(curr);
				curr = curr.left;
			}
		}
		return true;
	}
}