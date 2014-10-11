public class Solution {
    public static TreeNode pre;
	public static TreeNode first;
	public static TreeNode second;

	public void recoverTree(TreeNode root) {
	    pre = null;
	    first = null;
    	second = null;
    	
        search( root);
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    public void search(TreeNode root){
    	if(root == null) return;

    	search(root.left);

    	if(pre != null && pre.val > root.val){
    		if(first == null) 
    			first = pre;
    		second = root;
    	}

    	pre = root;
    	
    	search(root.right);	
    }
}