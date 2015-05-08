// Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

// For example, this binary tree is symmetric:

//     1
//    / \
//   2   2
//  / \ / \
// 3  4 4  3
// But the following is not:
//     1
//    / \
//   2   2
//    \   \
//    3    3
// Note:
// Bonus points if you could solve it both recursively and iteratively.

public class Solution{
	// Recursion
	public boolean isSymmetric(TreeNode root){
		if(root == null) return true;

		return isSymmetric(root.left, root.right);
	}

	public boolean isSymmetric(TreeNode left, TreeNode right){
		if(left == null && right == null) return true;

		if(left == null || right == null) return false;

		return (left.val == right.val) && isSymmetric(left.left, right.right) &&isSymmetric(left.right,right.left); 
	}

	// Iteration ...
	private boolean isSymmetric(TreeNode left, TreeNode right) {  
   if (left == null && right == null) return true;  
   if (left == null || right == null || left.val != right.val) return false;  
   
   Queue<TreeNode> lque = new ArrayDeque<TreeNode>();  
   Queue<TreeNode> rque = new ArrayDeque<TreeNode>();  
   lque.add(left); rque.add(right);  
   while (!lque.isEmpty() && !rque.isEmpty()) {  
     TreeNode l = lque.remove();  
     TreeNode r = rque.remove();  
   
     if (l.left != null && r.right != null && l.left.val == r.right.val) {  
       lque.add(l.left); rque.add(r.right);  
     } else if (!(l.left == null && r.right == null)) {  
       return false;  
     }  
   
     if (l.right != null && r.left != null && l.right.val == r.left.val) {  
       lque.add(l.right); rque.add(r.left);  
     } else if (!(l.right == null && r.left == null)) {  
       return false;  
     }  
   }  
   
   return (lque.isEmpty() && rque.isEmpty());  
 }  
   
 public boolean isSymmetric(TreeNode root) {  
   return (root == null ) || isSymmetric(root.left, root.right);  
 }  
}

