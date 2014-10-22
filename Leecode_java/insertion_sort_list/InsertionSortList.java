
// Sort a linked list using insertion sort.

public class Solution {
    public ListNode insertionSortList(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode dummy = new ListNode(0);
        //dummy.next = head;
        ListNode curr = head;
        ListNode pre = dummy;

        while(curr != null){
        	pre = dummy;
        	ListNode temp = curr.next;
        	while(pre.next != null && pre.next.val <= curr.val){ // the node will break at curr
        		pre = pre.next;
        	}
        	curr.next = pre.next;
        	pre.next = curr;
        	curr = temp;  // the node will break at curr
        }
        return dummy.next;
    }
}