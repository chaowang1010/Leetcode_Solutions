public class Solution {
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        
        int diff = getDepth(root.left) - getDepth(root.right);
        if(Math.abs(diff) > 1) return false;
        
        return (isBalanced(root.left) && isBalanced(root.right));
    }
    
    public int getDepth(TreeNode root){
        if(root == null) return 0;
        
        return Math.max(getDepth(root.left), getDepth(root.right)) + 1;
    }
}