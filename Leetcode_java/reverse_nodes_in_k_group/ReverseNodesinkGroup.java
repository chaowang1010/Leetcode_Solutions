public class Solution {
        public ListNode reverseKGroup(ListNode head, int k) {
    	if(k <= 1 || head == null) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode start=dummy;
        int i = 0;
        while(head != null){
        	++i;
        	if( i % k == 0){
        		start = reverse(start, head.next);
        		head = start.next; // HEAD HAS BEEN CHANGED, SO HEAD = HEAD.NEXT IS WRONG
        	} else
        	head = head.next;
        }
        return dummy.next;
    }

    // reverse dummy.next and end, and so on THIS IS NOT RIGHT, BECAUSE END HAS BEEN CHANGED
    // * a linked list:
    //  * 0->1->2->3->4->5->6
    //  * |        |   
    //  * dummy    end    
    //  * after call pre = reverse(pre, next)
    //  * 
    //  * 0->3->2->1->4->5->6
    //  *          |  |
    //  *          du next


     // reverse dummy.next and THE NODE BEFORE end, and so on 
    // * a linked list: K=3
    //  * 0->1->2->3->4->5->6
    //  * |        	  |   
    //  * dummy      end    
    //  * after call pre = reverse(pre, next)
    //  * 
    //  * 0->3->2->1->4->5->6
    //  *          |  |
    //  *          du END
    public ListNode reverse(ListNode dummy, ListNode end) {
    	ListNode tail = dummy.next;
    	ListNode curr = tail.next;

    	while(curr != end){
    		tail.next = curr.next;
    		curr.next = dummy.next;
    		dummy.next = curr;

    		curr = tail.next;
    	}
    	return tail;
    }
}