public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // using two node;
        
        ListNode l1 = head;
        ListNode l2 = head;
        for(int i = 0; i < n - 1 ; i ++){
                l2 = l2.next;
        }
        
        if(l2.next == null) return head.next;
        
        l2 = l2.next;
        while(l2.next != null){
            l1 = l1.next;
            l2 = l2.next;
        }
        l1.next = l1.next.next;
        return head;
    }

    // More eligant 
    // Keep l2 n+1 nodes away from l1;
    public ListNode removeNthFromEnd(ListNode head, int n) {  
   	// pilot is supposed to be n+1 ahead of pre  
   	// so when pilot reaches the end, pre points to the node right before n-th  
   	// that said, there has to be n nodes between the two pointers  
    ListNode pilot = head, pre = head;  
   	while (pilot != null) {  
    if (n >= 0) { // forward pilot pointer  
    --n;  
    } else { // forward pre pointer  
    pre = pre.next;  
    }  
    pilot = pilot.next;  
   	}  
   
   	if (n > 0) { // nothing to remove  
   	} else if (n == 0) { // remove head  
    head = head.next;  
   	} else { // remove n-th  
    pre.next = pre.next.next;  
   	}  
   	return head; 
}