// Given a singly linked list where elements are sorted in ascending order, 
// convert it to a height balanced BST.

public class Solution {
    // naive solution
    //To get the length of the list (Ln 3-7), O(n) time. 
    //To build up the BST, T(n) = 2T(n/2) + n/2 = O(nlogn). So, in total, O(nlogn).
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null) return null;

        int len = 0;
        ListNode curr = head;
        while(curr != null){
        	curr = curr.next;
        	len ++;
        }
        return listToBST(head, 0, len - 1);
    }

    public TreeNode listToBST(ListNode head, int start, int end){
    	if(start > end) return null;
    	int mid = (start + end)/2;
    	int i = mid;
    	ListNode midNode = head;
    	while(i>start){
    		midNode = midNode.next;
    		i--;
    	}
    	TreeNode root = new TreeNode(midNode.val);
    	root.left = listToBST(head, start, mid - 1);
    	root.right = listToBST(midNode.next, mid + 1, end);
    	return root;
    }
}