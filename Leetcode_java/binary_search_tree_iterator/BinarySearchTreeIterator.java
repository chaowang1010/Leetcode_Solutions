/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class BSTIterator {

    Stack<TreeNode> stack = null;
    
    public BSTIterator(TreeNode root) {
        stack = new Stack<TreeNode>();
        TreeNode temp = root;
        while(temp != null){
            stack.push(temp);
            temp = temp.left;
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode temp = stack.pop();
        int result = temp.val;
        if(temp.right != null){
            temp = temp.right;
            stack.push(temp);
            temp = temp.left;
            while(temp != null){
                stack.push(temp);
                temp = temp.left;
            }
        }
        return result;
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */