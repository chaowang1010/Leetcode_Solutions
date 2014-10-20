/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
// Given a singly linked list L: L0→L1→…→Ln-1→Ln,
// reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…

// You must do this in-place without altering the nodes' values.

// For example,
// Given {1,2,3,4}, reorder it to {1,4,2,3}.

public class Solution {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null) return;

        ListNode l1 = head;
        ListNode l2 = head;

        // split the linked list to two parts
        while(l2.next != null && l2.next.next != null){
        	l1=l1.next;
        	l2 = l2.next.next;
        }
        // if(l2.next != null){ // even number of nodes
        // 	l1 = l1.next;
        // }
        l2 = l1.next;
        l1.next = null;
        l1 = head;

        // Reverse l2
        l2 = reverseOrder(l2);

        //put l1 and reversed l2 to head;
        head = l1;
        while(l2 != null){
        	ListNode temp1 = l1.next;
        	ListNode temp2 = l2.next;
        	l1.next = l2;
        	l1.next.next = temp1;
        	l2 = temp2;
        	l1 = temp1;
        }
    }


    // Reverse order root
    public ListNode reverseOrder(ListNode head){
    	if(head == null || head.next == null) return head;

    	ListNode dummy = new ListNode(0);
    	dummy.next = head;
    	ListNode curr = head;

    	while(curr.next != null){
    		ListNode temp = curr.next;
    		curr.next = temp.next;
    		temp.next = dummy.next;
    		dummy.next = temp;
    	}
    	return dummy.next;
    }
}