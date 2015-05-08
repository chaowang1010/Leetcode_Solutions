// Given a linked list, return the node where the cycle begins. If there is no cycle, return null.

// Follow up:
// Can you solve it without using extra space?

public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head == null) return null;

        ListNode l1 = head, l2 = head;
        do {
        	if(l2.next != null && l2.next.next != null){
        		l2 = l2.next.next;
        		l1 = l1.next;
        	} else{
        		return null;
        	}
        } while(l2 != l1);

        l1 = head;
       	while(l1 != l2){
       		l1 = l1.next;
       		l2 = l2.next;
       	}
       	return l1;
    }
}