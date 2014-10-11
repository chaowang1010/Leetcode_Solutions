// Iteration.... solution works
public class Solution{
    public void connect(TreeLinkNode root) {
        TreeLinkNode parent = root;
        TreeLinkNode head = null;
        TreeLinkNode tail = null;
        while(parent != null) {

            while(parent != null) {
                if(parent.left != null){
                    if(tail != null) 
                        tail.next = parent.left;
                    else head = parent.left;
                    tail = parent.left;
                }
                if(parent.right != null){
                    if(tail != null){
                        tail.next = parent.right;
                    }else head = parent.right;
                    tail = parent.right;
                }

                parent = parent.next;    
            }
        parent = head;
        head = null;
        tail = null;
        }
    }
}