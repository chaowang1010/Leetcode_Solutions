public class Solution {

	//Recursive
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        
        return Math.max(maxDepth(root.left) , maxDepth(root.right)) + 1;
    }

    // Iteration...
    public int maxDepth(TreeNode root) {
    	if(root == null) return 0;
    	int depth = 0;
    	LinkedList<TreeNode> nodes = new LinkedList<TreeNode>();
    	nodes.addLast(root);
    	nodes.addLast(null);
    	

    	while(!nodes.isEmpty()){
    		TreeNode curr = nodes.removeFirst();
    		if (curr == null){  // finish search on this level
    			depth ++;
    			if(!nodes.isEmpty()) nodes.addLast(null);
    		} else {
    			if(curr.left != null) nodes.addLast(curr.left);
    			if(curr.right != null) nodes.addLast(curr.right);
    		}
    	}

    }
}