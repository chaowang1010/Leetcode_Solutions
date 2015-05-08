Given a binary tree, find the maximum path sum.

The path may start and end at any node in the tree.

For example:
Given the below binary tree,

    -1
   /  \
  1    2
 / \
2   3
Return 6.

public class Solution {
	public class Path{
		int patialSum = 0;
		int sum = Integer.MIN_VALUE;
	}

    public int maxPathSum(TreeNode root) {
        Path path = maxSubPath(root);
        return path.sum;
    }

    public Path maxSubPath(TreeNode root) {
    	Path path = new Path();
    	if(root == null) return path;

    	Path left = maxSubPath(root.left);
    	Path right = maxSubPath(root.right);

    	path.patialSum = Math.max(0, Math.max(left.patialSum, right.patialSum) + root.val);
    	path.sum = Math.max(Math.max(left.sum, right.sum), right.patialSum + left.patialSum + root.val);
    	return path;
    }
}