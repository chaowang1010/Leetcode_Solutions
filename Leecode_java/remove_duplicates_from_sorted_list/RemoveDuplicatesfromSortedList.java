public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode curr = head;

        while(curr != null && curr.next != null){
        	if(curr.val == curr.next.val){ // found a hit
        		curr.next = curr.next.next;
        	} else{
        		curr = curr.next;
        	}
        }
        return head;
    }
}