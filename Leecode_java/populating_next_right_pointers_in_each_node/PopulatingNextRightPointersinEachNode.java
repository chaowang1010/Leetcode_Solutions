// Given a binary tree

//     struct TreeLinkNode {
//       TreeLinkNode *left;
//       TreeLinkNode *right;
//       TreeLinkNode *next;
//     }
// Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

// Initially, all next pointers are set to NULL.

// Note:

// You may only use constant extra space.
// You may assume that it is a perfect binary tree (ie, all leaves are at the same level, and every parent has two children).
// For example,
// Given the following perfect binary tree,
//          1
//        /  \
//       2    3
//      / \  / \
//     4  5  6  7
// After calling your function, the tree should look like:
//          1 -> NULL
//        /  \
//       2 -> 3 -> NULL
//      / \  / \
//     4->5->6->7 -> NULL
    


/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    // public void connect(TreeLinkNode root) {
    //     connecter(root, null);
    // }

    // public void connecter(TreeLinkNode root, TreeLinkNode parent){
    //  if(root == null) 
    //      return;
    //  if(parent == null){
    //      root.next = null;
    //  }else{
    //      if(parent.left == root && parent.right != null){  //is a left child
    //          root.next = parent.right;
    //      }else{    //is a right child
    //          if(parent.next != null){
    //              root.next = parent.next.left;
    //          }else{
    //              root.next = null;
    //          }
    //      } 

    //  }
    
    //  connecter(root.left, root);
    //  connecter(root.right, root);
    // }
    
    // Iteration
    public void connect(TreeLinkNode root) {
        if(root == null || root.left == null) return;
        TreeLinkNode pre = root;
        TreeLinkNode cur = null;
        while(pre.left != null) {
            cur = pre;
            while(cur != null) {
                cur.left.next = cur.right;
                if(cur.next != null) cur.right.next = cur.next.left;
                cur = cur.next;
            }
        pre = pre.left;
        }
    }
    
    // public void connect(TreeLinkNode root) {
    //  if(root == null || root.left == null) return;
    //  TreeLinkNode parent = root;
    //  TreeLinkNode curr = root.left;
    //  parent.next = null;
    //  curr.next = parent.right;

    //  while(curr != null){
    //      while(parent != null){
    //          parent.left.next = parent.right;
    //          if(parent.next != null){
    //              parent.right.next = parent.next.left;
    //              parent = parent.next;
    //          }else break;
    //      }
    //      parent = curr;
    //      curr = curr.left;
    //  }
    // }
}