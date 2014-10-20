public class Solution {
    public ListNode partition(ListNode head, int x) {
        if(head == null) return null;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
          
        // This is neccessary!  
	    while (pre.next != null && pre.next.val < x) pre = pre.next;

	    ListNode curr = pre;
        while(curr.next != null){
            if(curr.next.val < x){
                ListNode temp = pre.next;
                pre.next = curr.next;
                curr.next = curr.next.next;
                pre.next.next = temp;
                pre = pre.next;
            } else {
            	curr = curr.next;
            }
        }

        return dummy.next;
    }
}