import java.util.ArrayList;

import common.TreeNode;

public class BinaryTreePostorderTraversal {

    public class Solution {

    	// recursion...
		public ArrayList<Integer> postorderTraversal(TreeNode root){
			ArrayList<Integer> result = ArrayList<Integer>();
			postorderTraversal(root, result);
			retrun result;
		}

		public ArrayList<Integer> postorderTraversal(TreeNode root, ArrayList<Integer> result){
			if(root == null)
				return;
			postorderTraversal(root.left, result);
			postorderTraversal(root.right, result);
			result.add(root.val);
		}

		//1.1 Create an empty stack
		// 2.1 Do following while root is not NULL
		//     a) Push root's right child and then root to stack.
		//     b) Set root as root's left child.
		// 2.2 Pop an item from stack and set it as root.
		//     a) If the popped item has a right child and the right child 
		//        is at top of stack, then remove the right child from stack,
		//        push the root back and set root as root's right child.
		//     b) Else print root's data and set root as NULL.
		// 2.3 Repeat steps 2.1 and 2.2 while stack is not empty.
		

		// Iteration.. stack    
	    public ArrayList<Integer> postorderTraversal(TreeNode root){
				ArrayList<Integer> result = new ArrayList<Integer>();
				Stack<TreeNode> stack = new Stack<TreeNode>();
				TreeNode pre = null;
				if(root == null) return result;
				stack.push(root);

				while(!stack.empty()){
					TreeNode curr = stack.peek();
					if(curr.left == null && curr.right == null){
						result.add(curr.val);
						pre =curr;
						stack.pop();
						continue;
					}
					if(pre != null && (curr.left == pre)||(curr.right == pre) ){
						pre = curr;
						stack.pop();
						result.add(curr.val);
					}else{
						if(curr.right != null) stack.push(curr.right);
	            		if(curr.left != null) stack.push(curr.left);
					}
				}
				
				return result;
			}    
	}
}