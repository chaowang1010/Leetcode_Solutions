import java.util.ArrayList;

import common.TreeNode;

public class BinaryTreePreorderTraversal {

    public class Solution {
    	// Recursion
    	public ArrayList<Integer> preorderTraversal(TreeNode root){
    		ArrayList<Integer> result = new ArrayList<Integer>();
    		preorderTraversal(root, result);
    		return result;
    	}

		public void preorderTraversal(TreeNode root, ArrayList<Integer> result){
    		if(root == null) return;

    		result.add(root.val);
    		if(root.left != null) preorderTraversal(root.left, result);
    		if(root.right != null) preorderTraversal(root.right, result);
    	} 

    	// Iteration
    	public ArrayList<Integer> preorderTraversal(TreeNode root){
            ArrayList<Integer> result = new ArrayList<Integer>();
    		Stack<TreeNode> stack = new Stack<TreeNode>();
    		stack.push(root);
    		if (root == null) return result;
    		while(!stack.empty()){
    			TreeNode curr = stack.peek();
    			result.add(curr.val);
    			stack.pop();
    			if(curr.right != null) stack.push(curr.right);
    			if(curr.left != null) stack.push(curr.left);
    		}
    		return result;
        }
    }
}