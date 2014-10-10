
public class Solution {
    public void flatten(TreeNode root) {
        flattenTree(root);
    }

    private TreeNode flattenTree(TreeNode root){
    	if(root == null) return null;
    	TreeNode right = root.right;
    	TreeNode temp = root;

    	if(root.left != null){
    		temp = flattenTree(root.left);
    		root.right = temp;
    		temp.right = right;
    		root.left = null;
    	}

    	if(root.right != null)
    		temp = flattenTree(root.right);
    	
    	return temp;
    }

    // Using stack ... not in place
    public void flatten(TreeNode root){
    	Stack<TreeNode> curr = Stack<TreeNode>();
    	curr = root;
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
}