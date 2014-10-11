public class Solution {

	// DFS, Recursive
    public int minDepth(TreeNode root){
        if(root == null) return 0;
        int l = minDepth(root.left);
        int r = minDepth(root.right);

        if(l == 0) return r + 1;  // Note 
        if(r == 0) return l + 1;  // Note
        return Math.min(l , r) + 1;
    }

    // BFS, BFS can stop as soon as it hits the first leaf and return the depth there.
    public int minDepth(TreeNode root){
    	if(root == null) return 0;

    	int depth = 0;
    	Queue<TreeNode> queue = new LinkedList<TreeNode> ();
    	queue.offer(root);
    	queue.offer(null);

    	while(!queue.isEmpty()){
    		TreeNode curr = queue.pool();
    		if(curr == null){
    			depth ++;
    			
    		}
    	}
    }
}