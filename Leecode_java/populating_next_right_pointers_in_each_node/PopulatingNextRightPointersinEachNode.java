public class Solution {

	// Recursive
    public void connect(TreeLinkNode root) {
        connecter(root, null);
    }

    public void connecter(TreeLinkNode root, TreeLinkNode parent){
    	if(root == null) 
    		return;
    	if(parent == null){
    		root.next = null;
    	}else{
    		if(parent.left == root && parent.right != null){  //is a left child
    			root.next = parent.right;
    		}else{    //is a right child
    			if(parent.next != null){
    				root.next = parent.next.left;
    			}else{
    				root.next = null;
    			}
    		} 

    	}

    	connecter(root.left, root);
    	connecter(root.right, root);
    }

    // Iteration....
    public void connect(TreeLinkNode root) {
    	if(root == null || root.left == null) return;

    	TreeLinkNode parent = root;
    	TreeLinkNode curr = root.left;
    	parent.next = null;
    	curr.next = parent.right;

    	while(curr != null){
    		while(parent != null){
    			parent.left.next = parent.right;
    			if(parent.next != null){
    				parent.right.next = parent.next.left;
    				parent = parent.next;
    			}else break;
    		}
    		parent = curr;
    		curr = curr.left;
    	}
    }

    // Iteration.... solution works
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

}