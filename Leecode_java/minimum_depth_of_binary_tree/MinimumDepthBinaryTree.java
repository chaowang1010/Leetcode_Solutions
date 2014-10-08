public class Solution {
    public int minDepth(TreeNode root){
        if(root == null) return 0;
        int l = minDepth(root.left);
        int r = minDepth(root.right);

        if(l == 0) return r + 1;  // Note 
        if(r == 0) return l + 1;  // Note
        return Math.min(l , r) + 1;
    }
}