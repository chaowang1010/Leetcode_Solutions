/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public int minDepth(TreeNode root) {
        return minDepth_1(root, false);
    }
    public int minDepth_1(TreeNode root, boolean isnull){
        if (root==null)
        {
            if (!isnull)
                return 0;
            else 
                return Integer.MAX_VALUE; //
        }    
        return ( Math.min(minDepth_1(root.left, root.right != null), minDepth_1(root.right, root.left != null)) + 1 );
    }
}