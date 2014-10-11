
public class Solution {
    // Recursive ... not in place. 
    
    public void flatten(TreeNode root) {
        flattenTree(root);
    }

    private TreeNode flattenTree(TreeNode root){
    	if(root == null) return null;
    	
    	TreeNode left = root.left;
        TreeNode right = root.right;
        
        TreeNode leftTail = flattenTree(root.left);
        if(leftTail == null) leftTail = root;
        TreeNode rightTail = flattenTree(root.right);
        if(rightTail == null) rightTail = leftTail;
        
        root.left = null;
        root.right = left;
        leftTail.right = right;
        return rightTail;
    }
    
    // iteration.. stack..
    public void flatten(TreeNode root){
    	Stack<TreeNode> stack = new Stack<TreeNode>();
    	TreeNode curr = root;
    	while(curr != null || !stack.empty()){
    		if(curr.right != null) {
    			stack.push(curr.right);
    		}

    		if(curr.left != null){
    			curr.right = curr.left;
    			curr.left = null;
    		}else if(!stack.empty()){
    			curr.right = stack.pop();
    		}
    		curr = curr.right;
    	}
    }
    
    // Iteration...
    private TreeNode pre = null;

    public void flatten(TreeNode root){
    	TreeNode dummy = new TreeNode(0);
    	dummy.right = root;
    	dummy.left = null;
    	pre = dummy;
    	flattenHelper(root);
    }

    public void flattenHelper(TreeNode root){
    	if(root == null) 
    		return;

    	pre.right = root;
    	pre.left = null;

    	pre = root;

    	// after invoke flattenHelper on root.left, root.right will revised
    	// so record this value
    	TreeNode right = root.right;
    	flattenHelper(root.left);
    	flattenHelper(right);

    }
}




