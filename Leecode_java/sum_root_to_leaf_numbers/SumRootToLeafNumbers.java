public class Solution{
	public int sumNumbers(TreeNode root){
		if(root == null) return 0;
		return sumNumbersHelper(root, root.val, 0);  // include the current node value
	}

	public int sumNumbersHelper(TreeNode root, int path, int sum){
		if(root.right == null && root.left == null){
			return sum + path;
		}
		
		if(root.left != null) 
			sum = sumNumbersHelper(root.left, path * 10 + root.left.val, sum);

		if(root.right != null) 
			sum = sumNumbersHelper(root.right, path * 10 + root.right.val, sum);

		return sum;
	}
}