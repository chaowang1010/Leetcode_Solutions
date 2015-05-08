import java.util.ArrayList;

import common.TreeNode;

public class BinaryTreeInorderTraversal {

    public class Solution {

    	// Recursion ... 
    	public ArrayList<Integer> inorderTraversal(TreeNode root){
    		ArrayList<Integer> result = new ArrayList<Integer>();
    		inorderTraversal(root, result);
    		return result;
    	}

    	public void inorderTraversal(TreeNode root, ArrayList<Integer> result){
    		if(root == null) return;

    		inorderTraversal(root.left , result);
    		result.add(root.val);
    		inorderTraversal(root.right, result);
    	}


    	// Do not use stack...
    	// public static ArrayList<Integer> inorderTraversal(TreeNode root){
    	// 	ArrayList<Integer> result = new ArrayList<Integer>();
    	// 	TreeNode curr = root; //new TreeNode();
    	// 	while(curr != null){
    	// 		if(curr.left == null){
    	// 			result.add(curr.val);
    	// 			curr = curr.right;
    	// 		}else{

    	// 		}

    	// 	}
    	// }

    	// Using stack ...
    	public static ArrayList<Integer> inorderTraversal(TreeNode root){
    		ArrayList<Integer> result = new ArrayList<Integer>();
    		Stack<TreeNode> stack = new Stack<TreeNode>();
    		TreeNode curr = root;
    		while(curr != null || !stack.empty()){
    			if(curr != null){
    				stack.push(curr);
    				curr = curr.left;
    			}else{
    				curr = stack.pop();
    				result.add(curr.val);
    				curr = curr.right;
    			}
    		}
    		return result;
    	}

    	//
    }

}