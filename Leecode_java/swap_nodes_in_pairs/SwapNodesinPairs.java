public class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode dummy = new ListNode(0); // dummy = null is not OK
        dummy.next = head;
        ListNode curr = dummy;
        while(curr.next != null && curr.next.next != null ){
        	ListNode temp = curr.next;
        	curr.next = curr.next.next;
        	curr = curr.next;
        	temp.next = curr.next;
        	curr.next = temp;
        	curr = curr.next;
        }
        return dummy.next;
    }
}