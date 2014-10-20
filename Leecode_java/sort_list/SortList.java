public class Solution {
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null ) return head;
        
        // split the list to two from the middle
        ListNode l1 = head;
        ListNode l2 = head;
        
        while(l2.next != null && l2.next.next != null){
            l2 = l2.next.next;
            l1 = l1.next;
        }
        l2 = l1.next;
        l1.next = null;
        l1= head;
        
        // sort l1 and l2 respectively
        l1 = sortList(l1);
        l2 = sortList(l2);
        
        //merge the two sorted listed
        return merge(l1,l2);
    }
    
    public ListNode merge(ListNode l1, ListNode l2){
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        
        // make a root
        ListNode root = null;
        if(l1.val > l2.val){
            root = l2;
            l2 = l2.next;
        }else{
            root = l1;
            l1 = l1.next;
        }
        
        ListNode curr = root;
        while(l1 != null || l2 != null){
            if(l1 == null || (l2 != null && l1.val > l2.val)){
                curr.next = l2;
                l2 = l2.next;
            } else {
                curr.next = l1;
                l1 = l1.next;
            }
            curr = curr.next;
        }
        return root;
    }
}